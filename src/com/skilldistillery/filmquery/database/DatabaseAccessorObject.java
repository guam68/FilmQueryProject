package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		String sql = "SELECT * FROM actor join film_actor on actor.id = film_actor.actor_id where film_id = ?;";
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Actor actor = new Actor(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"));
				actors.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		}

		return actors;
	}

	public List<Film> findFilmsByKeyword(String keyword) {
		List<Film> films = new ArrayList<>();
		String sql = "SELECT * FROM film where lower(film.title) like ? or lower(film.description) like ?;";
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Film film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getDouble("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(rs.getInt("id")));
				films.add(film);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		}

		return films;
	}

	public Film findFilmByFilmId(int filmId) {
		Film film = null;
		String sql = "SELECT * FROM film where id = ?;";
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				film = new Film(rs.getInt("id"), rs.getString("title"), rs.getString("description"),
						rs.getInt("release_year"), rs.getInt("language_id"), rs.getInt("rental_duration"),
						rs.getDouble("rental_rate"), rs.getDouble("length"), rs.getDouble("replacement_cost"),
						rs.getString("rating"), rs.getString("special_features"), findActorsByFilmId(rs.getInt("id")));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		}

		return film;
	}
	
	public String getLangById(int langId) {
		String lang = null;
		String sql = "SELECT name FROM language where id = ?;";
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, langId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				lang = rs.getString("name");
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
		}

		return lang;
	}

}
