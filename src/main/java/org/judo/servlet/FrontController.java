package org.judo.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.controller.BaseController;
import org.judo.controller.CompetitionController;
import org.judo.controller.CoordonneeController;
import org.judo.controller.HomeController;
import org.judo.controller.LoginController;
import org.judo.controller.LogoutController;
import org.judo.controller.ProfilController;
import org.judo.controller.ProfilSaveController;
import org.judo.utils.ArgsPageLabel;

public class FrontController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Map<String, Class<? extends BaseController>> router;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.GenericServlet#init()
     */
    @Override
    public void init() throws ServletException {
	super.init();
	router = new HashMap<>();
	router.put("home", HomeController.class);
	router.put("login", LoginController.class);
	router.put("logout", LogoutController.class);
	router.put("profil", ProfilController.class);
	router.put("profil/save", ProfilSaveController.class);
	router.put("competition", CompetitionController.class);
	router.put("coordonnee", CoordonneeController.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	RequestDispatcher rd = null;

	HttpSession session = null;
	session = req.getSession(false);
	if (session != null)
	    req.setAttribute("bandeau", "Administrateur");

	String[] urlValArray = null;
	String slug = null;
	Map<ArgsPageLabel, Object> argsPage = null;
	if (req.getRequestURL().toString().contains("/action/")) {
	    urlValArray = req.getRequestURL().toString().split("/action/");

	    if (urlValArray != null && urlValArray.length > 1) {
		slug = urlValArray[1].contains("?") ? urlValArray[1].split("?")[0] : urlValArray[1];
	    }

	    if (slug != null) {
		try {
		    argsPage = router.get(slug).newInstance().execute(req, resp, session);
		    rd = (RequestDispatcher) argsPage.get(ArgsPageLabel.REQUEST_DISPATCHER);
		} catch (InstantiationException | IllegalAccessException e) {
		    System.err.println(e.getMessage());
		}
	    } else {
		try {
		    argsPage = router.get("home").newInstance().execute(req, resp, session);
		    rd = (RequestDispatcher) argsPage.get(ArgsPageLabel.REQUEST_DISPATCHER);
		} catch (InstantiationException | IllegalAccessException e) {
		    System.err.println(e.getMessage());
		}
	    }
	} else {
	    resp.sendRedirect(req.getContextPath() + "/action/");
	}

	if (rd != null) {
	    rd.forward((HttpServletRequest) argsPage.get(ArgsPageLabel.REQUEST),
		    (HttpServletResponse) argsPage.get(ArgsPageLabel.RESPONSE));
	}

    }

}
