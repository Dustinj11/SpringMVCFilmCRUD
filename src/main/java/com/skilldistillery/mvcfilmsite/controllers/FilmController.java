package com.skilldistillery.mvcfilmsite.controllers;

import java.util.List;

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

//		return "index.html";

//	}

	@RequestMapping(path = "findFilmById.do", params = "id", method = RequestMethod.GET)
	public ModelAndView findFilmById(int id) {

		ModelAndView mv = new ModelAndView();

		Film f = filmDao.findFilmById(id);

		mv.addObject("film", f);

		mv.setViewName("WEB-INF/result.jsp");

		return mv;
	}

	@RequestMapping(path = "findFilmByKeyword.do", params = "keyWord", method = RequestMethod.GET)
	public ModelAndView findFilmByKeyWord(String keyWord) {

		ModelAndView mv = new ModelAndView();

		List<Film> films = filmDao.findFilmByKeyword(keyWord);

		mv.addObject("film", films);

		mv.setViewName("WEB-INF/keyword.jsp");

		return mv;
		
		
		
	}
	@RequestMapping(path = "addFilm.do", method= RequestMethod.POST)
	public ModelAndView updateFilm(Film film) {
		
		ModelAndView mv = new ModelAndView();
		
		Film f=	filmDao.addFilm(film);

		mv.addObject("film", f);

		mv.setViewName("WEB-INF/newFilm.jsp");

		return mv;
		
		
		
		
		
		 
		 
		
		
		
	}
}
