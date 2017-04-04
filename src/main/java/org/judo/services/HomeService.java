package org.judo.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.utils.ArgsPageLabel;

public class HomeService extends Services {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	System.out.println("Home");
	req.setAttribute("pageTitle", "Home");
	req.setAttribute("slug", "home");
	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, session);
    }

}
