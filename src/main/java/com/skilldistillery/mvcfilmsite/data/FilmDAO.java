package com.skilldistillery.mvcfilmsite.data;


import java.util.List;

import com.skilldistillery.mvcfilmsite.entities.Actor;
import com.skilldistillery.mvcfilmsite.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId);

//	public Actor findActorById(int actorId);

//	public List<Actor> findActorsByFilmId(int filmId);

	public List<Film> findFilmByKeyword(String keyword);

//	public String findLanguage(int filmId);

//	public Film createFilm(Film film);
	
//	public boolean deleteActor(Actor actor);
	
	public boolean deleteFilm(int filmId);
	

	public Film addFilm(Film film);
	
	public boolean updateFilm(Film film); 
}
