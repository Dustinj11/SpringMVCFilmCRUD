package com.skilldistillery.mvcfilmsite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@RequestMapping(path = "addFilm.do", method = RequestMethod.POST)
	public ModelAndView updateFilm(String filmTitle, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int filmLength, double replacementCost, String rating,
			String specialFeatures, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		film.setFilmTitle(filmTitle);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguageId(languageId);
		film.setRentalDuration(rentalDuration);
		film.setRentalRate(rentalRate);
		film.setFilmLength(filmLength);
		film.setReplacementCost(replacementCost);
		film.setRating(rating);
		film.setSpecialFeatures(specialFeatures);
		filmDao.addFilm(film);
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmAdded.do");
		return mv;
	}

	@RequestMapping("filmAdded.do")
	public ModelAndView filmAdded() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/newFilm.jsp");
		return mv;
	}

	@RequestMapping(path = "deleteFilm.do", params = "filmId", method = RequestMethod.GET)
	public ModelAndView deleteFilm(int filmId) {
		
		ModelAndView mv = new ModelAndView();

		boolean f = filmDao.deleteFilm(filmId);

		mv.addObject("film", f);

		mv.setViewName("WEB-INF/deleteFilm.jsp");

		return mv;

	}
	@RequestMapping(path = "editFilm.do", method = RequestMethod.POST)
	public ModelAndView editFilm(String filmTitle, String description, int releaseYear, int languageId,
			int rentalDuration, double rentalRate, int filmLength, double replacementCost, String rating,
			String specialFeatures, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film film = new Film();
		film.setFilmTitle(filmTitle);
		film.setDescription(description);
		film.setReleaseYear(releaseYear);
		film.setLanguageId(languageId);
		film.setRentalDuration(rentalDuration);
		film.setRentalRate(rentalRate);
		film.setFilmLength(filmLength);
		film.setReplacementCost(replacementCost);
		film.setRating(rating);
		film.setSpecialFeatures(specialFeatures);
		filmDao.updateFilm(film);
		redir.addFlashAttribute("film", film);
		mv.setViewName("redirect:filmEdited.do");
		return mv;
	}

	@RequestMapping("filmEdited.do")
	public ModelAndView filmEdited() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/editFilm.jsp");
		return mv;
	}

}
