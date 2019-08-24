package com.skilldistillery.filmquery.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) throws SQLException {
		FilmQueryApp app = new FilmQueryApp();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		String choice = "";
		Film film = null;
		List<Film> films = new ArrayList<>();

		LOOP: while (true) {
			System.out.println("1. Search film by ID");
			System.out.println("2. Search film by keyword");
			System.out.println("3. Exit");
			choice = input.next();

			switch (choice) {
			case "1":
				System.out.println("Enter the ID");
				int id = input.nextInt();
				film = new DatabaseAccessorObject().findFilmByFilmId(id);
				System.out.println(film);
				printActors(film);
				printLang(film);
				break;
			case "2":
				System.out.println("Enter the keyword");
				String keyword = input.next();
				films = new DatabaseAccessorObject().findFilmsByKeyword(keyword);
				if (films.size() == 0){
					System.out.println("\nNo films found\n");
				}
				for (Film f : films) {
					System.out.println(f);
					printActors(f);
					printLang(f);
				}
				break;
			case "3":
				break LOOP;
			default: 
				System.out.println("Not a valid option");
				continue LOOP;
			}

		}

	}
	
	public void printLang(Film film) {
		System.out.println("\tLanguage: " + new DatabaseAccessorObject().getLangById(film.getLanguage_id()) + "\n");
	}
	
	public void printActors(Film film) {
		System.out.println("\tActors: ");
		for (Actor actor : film.getActors()) {
			System.out.println(actor);
		}
	}
}
