package org.judo.services;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.utils.ArgsPageLabel;

public class ProfilService extends Services {

    @Override
    public Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException {
	HttpSession sessionLogin = null;
	System.out.println("Profil");
		
	req.setAttribute("pageTitle", "Profil");
	req.setAttribute("slug", "profil");
	
	
	rd = req.getRequestDispatcher("/jsp/layout.jsp");
	return arrayReturnGen(rd, req, resp, sessionLogin);
    }

}
