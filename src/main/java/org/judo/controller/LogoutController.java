package org.judo.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.utils.ArgsPageLabel;

/**
 * Logout the user connected
 * @author root
 *
 */
public class LogoutController extends BaseController {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	req.getServletContext().log("Logout page called");

	req.setAttribute("pageTitle", "Logout");
	req.setAttribute("slug", "logout");

	if (session == null) {
	    req.setAttribute("message", "You are not connected");
	} else {
	    session.invalidate();
	    req.setAttribute("message", "You have been disconnected");
	}
	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, session);
    }

}
