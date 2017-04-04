package org.judo.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

	if (session != null)
	    req.setAttribute("message", "You are already connected");
	else if (req.getParameter("login").toString().equals("admin")
		&& req.getParameter("password").toString().equals("OK")) {
	    sessionLogin = req.getSession();
	    sessionLogin.setAttribute("login", "admin");
	    // setting session to expiry in 30 mins
	    sessionLogin.setMaxInactiveInterval(30 * 60);
	    Cookie userName = new Cookie("login", "admin");
	    userName.setMaxAge(30 * 60);
	    resp.addCookie(userName);
	    System.out.println(sessionLogin.getId());
	    req.setAttribute("message", "You are connected");
	} else {
	    req.setAttribute("message", "Wrong Login or Password");
	}
	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, sessionLogin);
    }

}
