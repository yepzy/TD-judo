package org.judo.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.utils.ArgsPageLabel;

public class LoginService extends Services {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	HttpSession sessionLogin = null;
	System.out.println("Login");

	req.setAttribute("pageTitle", "Login");
	req.setAttribute("slug", "login");

	if (session != null && session.getAttribute("login") != null)
	    req.setAttribute("message", "You are already connected");
	else if (req.getParameter("login").toString().equals("admin")
		&& req.getParameter("password").toString().equals("OK")) {
	    sessionLogin = req.getSession();
	    sessionLogin.setAttribute("login", "admin");
	    req.setAttribute("message", "You are connected");
	} else {
	    req.setAttribute("message", "Wrong Login or Password");
	}
	resp.sendRedirect(req.getContextPath() + "/action");
	return arrayReturnGen(rd, req, resp, sessionLogin);
    }

}
