package com.skilldistillery.mvcfilmsite.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.mvcfilmsite.entities.Actor;
import com.skilldistillery.mvcfilmsite.entities.Film;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String url = "jdbc:mysql://localhost:3306/"
			+ "sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";
	private String sqltext = "";

	public FilmDaoJdbcImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean deleteFilm(int filmId) {
		Film film = new Film();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);

			conn.setAutoCommit(false); // START TRANSACTION

			String sql = "DELETE FROM film WHERE id = ?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			int updateCount = stmt.executeUpdate();

			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;

	}

	public boolean updateFilm(Film film) {
		Connection conn = null;
		try {
			/*
			 * assume everything except the actor's id (PK) may have changed update the
			 * actor's fn, ln, and their current list of films in the database
			 */
			conn = DriverManager.getConnection(url, user, pass);

			conn.setAutoCommit(false); // START TRANSACTION

			String sql = "UPDATE film SET title=?, description=?, release_year=?, "
					+ "language_id=?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?,"
					+ " rating=?, special_features=? WHERE id=?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, film.getFilmTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getFilmLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());

//		System.out.println(stmt);

			int updateCount = stmt.executeUpdate();

			if (updateCount == 1) {
//		// Replace actor's film list
//
//		// remove the old
//		sql = "DELETE FROM film_actor WHERE film.id = ?";
//		stmt = conn.prepareStatement(sql);
//		stmt.setInt(1, film.getId());
//		updateCount = stmt.executeUpdate();
//
//		// insert the new
//		sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
//		stmt = conn.prepareStatement(sql);
//		
//		stmt.setInt(1, film.getId());
//		for (Actor actor: film.getCast()) {
//			stmt.setInt(2, actor.getActorId());
//			updateCount = stmt.executeUpdate();
//		}

				conn.commit();
				stmt.close();
				conn.close();// COMMIT TRANSACTION
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

	@Override
	public Film addFilm(Film film) {
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);

			conn.setAutoCommit(false);

			String sql = "INSERT INTO film " + " (title, description, release_year, language_id, rental_duration, "
					+ "rental_rate, length, replacement_cost, rating, special_features) "
					// TODO: Add the rest of the film properties
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getFilmTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getFilmLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());

			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					film.setId(rs.getInt(1));
				}
				rs.close();
			}
			conn.commit();
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			film = null;
		}

		return film;
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = new Film();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			sqltext = "SELECT * FROM film WHERE id = ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setInt(1, filmId);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setFilmTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setFilmLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				// film.setCast(findActorsByFilmId(filmId));
				// creates a Film object
				film.setCast(findActorsByFilmId(filmId));
				film.setCatagory(findCategoryByFilmId(rs.getInt("id")));
			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findFilmByKeyword(String filmKeyword) {
		Film film = null;
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			filmKeyword = "%" + filmKeyword + "%";
			sqltext = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setString(1, filmKeyword);
			s.setString(2, filmKeyword);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setFilmTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				 film.setLanguageId(rs.getInt("language_id"));
				 film.setRentalDuration(rs.getInt("rental_duration"));
				 film.setRentalRate(rs.getDouble("rental_rate"));
				 film.setFilmLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				 film.setSpecialFeatures(rs.getString("special_features"));
				film.setCast(findActorsByFilmId(rs.getInt("id")));
				
				film.setCatagory(findCategoryByFilmId(rs.getInt("id")));
				// creates a Film object
				
				films.add(film);

			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actorOne = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			sqltext = "SELECT a.id, a.first_name, a.last_name, film.id" + " FROM film_actor f"
					+ " JOIN actor a ON f.actor_id = a.id" + " JOIN film ON f.film_id = film.id" + " WHERE film.id = ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setInt(1, filmId);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				actorOne = new Actor();
				actorOne.setActorId(rs.getInt("id"));
				actorOne.setFirstName(rs.getString("first_name"));
				actorOne.setLastName(rs.getString("last_name"));
				actors.add(actorOne);

			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actors;
	}
	
	public String findCategoryByFilmId(int filmId) {
        String category = "";
        Connection conn = null;
        PreparedStatement  stmt = null;
        ResultSet rs =null;
        try {
            String sqltext = "SELECT f.id,  c.name FROM category c JOIN film_category fc ON c.id = fc.category_id JOIN film f ON fc.film_id = f.id WHERE f.id = ? ORDER BY f.title";
          
        	 conn= DriverManager.getConnection(url, user, pass);
         stmt = conn.prepareStatement(sqltext);
            stmt.setInt(1, filmId);
        		rs   = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("here");
                category = rs.getString("name");
            } else {
                category = "No category listed for selected film.";
            }

            return category;

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                } // Not needed, stmt.close() will close it; but good practice
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                System.err.println(sqle);
            }
        }
        return category;
    }
	
}

//	public boolean updateActor(Actor actor) {
//		Connection conn = null;
//		try {
//			/*
//			 * assume everything except the actor's id (PK) may have changed update the
//			 * actor's fn, ln, and their current list of films in the database
//			 */
//			conn = DriverManager.getConnection(url, user, pass);
//
//			conn.setAutoCommit(false); // START TRANSACTION
//
//			String sql = "UPDATE actor SET first_name=?, last_name=? WHERE id=?";
//
//			PreparedStatement stmt = conn.prepareStatement(sql);
//
//			stmt.setString(1, actor.getFirstName());
//			stmt.setString(2, actor.getLastName());
//			stmt.setInt(3, actor.getActorId());
////				System.out.println(stmt);
//
//			int updateCount = stmt.executeUpdate();
//
//			if (updateCount == 1) {
//				// Replace actor's film list
//
//				// remove the old
//				sql = "DELETE FROM film_actor WHERE actor_id = ?";
//				stmt = conn.prepareStatement(sql);
//				stmt.setInt(1, actor.getActorId());
//				updateCount = stmt.executeUpdate();
//
//				// insert the new
//				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
//				stmt = conn.prepareStatement(sql);
//
//				for (Film film : actor.getFilms()) {
//					stmt.setInt(1, film.getId());
//					stmt.setInt(2, actor.getActorId());
//					updateCount = stmt.executeUpdate();
//				}
//
//				conn.commit(); // COMMIT TRANSACTION
//			}
//		} catch (SQLException sqle) {
//			sqle.printStackTrace();
//			if (conn != null) {
//				try {
//					conn.rollback();
//				} // ROLLBACK TRANSACTION ON ERROR
//				catch (SQLException sqle2) {
//					System.err.println("Error trying to rollback");
//				}
//			}
//			return false;
//		}
//		return true;
//	}