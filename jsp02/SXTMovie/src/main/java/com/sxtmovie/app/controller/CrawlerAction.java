package com.sxtmovie.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sxtmovie.action.Action;
import com.sxtmovie.action.ActionForward;
import com.sxtmovie.action.Crawler;
import com.sxtmovie.app.dao.MovieBean;

public class CrawlerAction extends HttpServlet implements Action{
	
 
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) {
		
		ActionForward forward = new ActionForward();
		Crawler crawler = new Crawler();
		HttpSession session = req.getSession();
		
		try {
			List<MovieBean> MovieList = crawler.CrawlerAction();
			session.setAttribute("MovieList", MovieList);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		forward.setPath("/index.jsp");
		forward.setRedirect(true);
		
		return forward;
	}

}
