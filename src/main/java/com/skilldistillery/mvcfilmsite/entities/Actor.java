package com.skilldistillery.mvcfilmsite.entities;


import java.util.List;
import java.util.Objects;

public class Actor {
	private int actorId;
	private String firstName;
	private String lastName;
	private List<Film> films; 


	
	public Actor() {
		super();
	}


	public Actor(int actorId, String firstName, String lastName, List<Film> films) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.films = films;
	}



	public List<Film> getFilms() {
		return films;
	}
	
	
	public void setFilms(List<Film> films) {
		this.films = films;
	}


	
	public int getActorId() {
		return actorId;
	}

	
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Override
	public int hashCode() {
		return Objects.hash(actorId, films, firstName, lastName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return actorId == other.actorId && Objects.equals(films, other.films)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
	}


	@Override
	public String toString() {
		return "Actor [actorId=" + actorId + ", firstName=" + firstName + ", lastName=" + lastName + ", films=" + films
				+ "]";
	}
	
}
