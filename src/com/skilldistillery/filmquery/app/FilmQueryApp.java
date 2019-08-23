package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.test();
		app.launch();
	}

	private void test() throws SQLException {
		Film film = db.findFilmById(1);
		System.out.println(film);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		String choice = "";
		LOOP: while (true) {
			System.out.println("1. Search film by ID");
			System.out.println("2. Search film by keyword");
			System.out.println("3. Exit");
			choice = input.next();

			switch (choice) {
			case "1":
			case "2":
			case "3":
				break LOOP;
			default: System.out.println("Not a valid option");
			}

		}

	}

}
