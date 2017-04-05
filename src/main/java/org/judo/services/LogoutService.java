package org.judo.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.utils.ArgsPageLabel;

public class LogoutService extends Services {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	System.out.println("Logout");
	req.setAttribute("pageTitle", "Logout");
	if (session == null)
	    req.setAttribute("message", "You are not connected");
	else {
	    session.invalidate();
	    req.setAttribute("message", "You have been disconnected");
	}
	resp.sendRedirect(req.getContextPath() + "/action");
	return arrayReturnGen(rd, req, resp, session);
    }

}
