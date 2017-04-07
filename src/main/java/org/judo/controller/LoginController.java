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
 * Login the user
 * @author root
 *
 */
public class LoginController extends BaseController {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	req.getServletContext().log("Login page called");

	req.setAttribute("pageTitle", "Login");
	req.setAttribute("slug", "login");

	HttpSession sessionLogin = null;
	if (session != null && session.getAttribute("login") != null) {
	    req.setAttribute("message", "You already connected");
	} else if (validPassword(req.getParameter("login"), req.getParameter("password"))) {
	    sessionLogin = req.getSession();
	    sessionLogin.setAttribute("login", "admin");
	    req.setAttribute("message", "You are connected");
	} else {
	    req.setAttribute("message", "Wrong Login or Password");
	}

	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, sessionLogin);
    }

    private boolean validPassword(String login, String password) {
	List<User> users = Service.getUsers();
	for (User u : users) {
	    if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
		return true;
	    }
	}
	return false;
    }

}
