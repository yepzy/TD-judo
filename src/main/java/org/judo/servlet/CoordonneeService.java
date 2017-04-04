package org.judo.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.bean.Grade;
import org.judo.services.Service;
import org.judo.services.Services;
import org.judo.utils.ArgsPageLabel;

public class CoordonneeService extends Services{

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	req.setAttribute("pageTitle", "Coordonnées");
	req.setAttribute("slug", "coordonnee");
	List<Grade> list =  Service.getGrades();
	

	
	req.setAttribute("list", list);

	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, session);
    }

}
