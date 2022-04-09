package com.skilldistillery.mvcfilmsite.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvcfilmsite.data.FilmDAO;
import com.skilldistillery.mvcfilmsite.entities.Film;

@Controller
public class FilmController {
	
	
	@Autowired
	private FilmDAO filmDao;
	
	
	
	
//	@RequestMapping(path = {"/", "home.do"})
//	public String home() {
//		
//		return "WEB-INF/home.jsp";
//	}
	

	
	
	@RequestMapping(path = "findFilmById.do",
			params = "id",
			method = RequestMethod.GET
			)
	public ModelAndView findFilmById(int id) {
		
		ModelAndView mv = new ModelAndView(); 
		
		Film f = filmDao.findFilmById(id);
		
		mv.addObject("film", f);
		
		mv.setViewName("WEB-INF/result.jsp");
		
		return mv;
	}
//	@RequestMapping(path = "findFilmByKeyword.do",
//			params = "id",
//			method = RequestMethod.GET
//			)
//	public ModelAndView findFilmByKeyWord(String word) {
//		
//ModelAndView mv = new ModelAndView(); 
//		
//		Film f = filmDao.findFilmByKeyword(word);
//		
//		mv.addObject("film", f);
//		
//		mv.setViewName("result.jsp");
//		
//		return mv;
//	}

}
