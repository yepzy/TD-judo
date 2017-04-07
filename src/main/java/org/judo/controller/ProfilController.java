package org.judo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.bean.Grade;
import org.judo.bean.User;
import org.judo.services.Service;
import org.judo.utils.ArgsPageLabel;

/**
 * Display profil page
 * 
 * @author yepzy
 *
 */
public class ProfilController extends BaseController {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	req.getServletContext().log("Profil page called");

	req.setAttribute("pageTitle", "Profil");
	req.setAttribute("slug", "profil");

	List<Grade> grades = Service.getGrades();
	List<User> users = Service.getUsers();

	User user = null;

	for (User u : users) {
	    user = u.getLogin().equals(session.getAttribute("login")) ? u : user;
	}

	req.setAttribute("user", user);
	req.setAttribute("grades", grades);

	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, session);
    }

}
