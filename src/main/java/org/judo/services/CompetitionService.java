package org.judo.services;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.bean.Competition;
import org.judo.bean.Grade;
import org.judo.utils.ArgsPageLabel;

public class CompetitionService extends Services{

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	req.setAttribute("pageTitle", "Compétitions");
	req.setAttribute("slug", "competition");

	List<Competition> list_c =  Service.getCompetitions();
	req.setAttribute("list", list_c);

	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, session);
    }

}
