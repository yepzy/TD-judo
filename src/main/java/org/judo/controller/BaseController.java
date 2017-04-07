package org.judo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.judo.utils.ArgsPageLabel;

public abstract class BaseController {
    
    protected RequestDispatcher rd;

    public abstract Map<ArgsPageLabel, Object> execute(HttpServletRequest req, HttpServletResponse resp, HttpSession session)
	    throws ServletException, IOException;

    public Map<ArgsPageLabel, Object> arrayReturnGen(RequestDispatcher rd, HttpServletRequest req, HttpServletResponse resp,
	    HttpSession session) {
	Map<ArgsPageLabel, Object> array = new HashMap<>();
	
	array.put(ArgsPageLabel.REQUEST_DISPATCHER, rd);
	array.put(ArgsPageLabel.REQUEST, req);
	array.put(ArgsPageLabel.RESPONSE, resp);
	array.put(ArgsPageLabel.SESSION, session);

	return array;
    }
}
