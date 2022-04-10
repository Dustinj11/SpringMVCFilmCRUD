
package com.skilldistillery.mvcfilmsite.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String filmTitle;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int filmLength;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	private List<Actor> cast;

	public Film() {
		super();
	}

	public Film(int id, String filmTitle, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int filmLength, double replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.filmTitle = filmTitle;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.filmLength = filmLength;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;

	}

	public Film(int id, String filmTitle, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int filmLength, double replacementCost, String rating, String specialFeatures,
			List<Actor> cast) {
		super();
		this.id = id;
		this.filmTitle = filmTitle;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.filmLength = filmLength;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.cast = cast;
	}

	public List<Actor> getCast() {
		return cast;
	}

	public void setCast(List<Actor> cast) {
		this.cast = cast;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilmTitle() {
		return filmTitle;
	}

	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getFilmLength() {
		return filmLength;
	}

	public void setFilmLength(int filmLength) {
		this.filmLength = filmLength;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", filmTitle=" + filmTitle + ", description=" + description + ", releaseYear="
				+ releaseYear + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalRate="
				+ rentalRate + ", filmLength=" + filmLength + ", replacementCost=" + replacementCost + ", rating="
				+ rating + ", specialFeatures=" + specialFeatures + ", language=" + language + ", cast=" + cast + "]";
	}

}
