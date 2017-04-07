package org.judo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.bean.User;
import org.judo.services.Service;
import org.judo.utils.ArgsPageLabel;

/**
 * Save the profil and redirect to page profile
 * 
 * @author root
 *
 */
public class ProfilSaveController extends BaseController {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	req.getServletContext().log("Profil/save page called");

	req.setAttribute("pageTitle", "Profil Saving");
	req.setAttribute("slug", "profil-save");
	

	req.getServletContext().log("save user -> "+req.getParameter("name"));

	List<User> users = Service.getUsers();

	User user = null;

	for (User u : users) {
	    user = u.getLogin().equals(session.getAttribute("login")) ? u : user;
	}

	req.setAttribute("user", user);

	resp.sendRedirect(req.getContextPath() + "/action/profil");
	return arrayReturnGen(rd, req, resp, session);
    }

}
