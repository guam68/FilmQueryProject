package com.skilldistillery.filmquery.entities;

import java.util.List;

import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
//import com.skilldistillery.filmquery.database.DatabaseAccessorObject.*;

public class Film {
	private List<Actor> actors;
	private int id;
	private String title;
	private String description;
	private int releaseYear;
	private int language_id;
	private int rentalDuration;
	private double rentalRate;
	private double length;
	private double replacementCost;
	private String rating;
	private String special_features;
	
	
	
	public Film(int id, String title, String description, int releaseYear, int language_id, int rentalDuration,
			double rentalRate, double length, double replacementCost, String rating, String special_features, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.language_id = language_id;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.special_features = special_features;
		this.actors = new DatabaseAccessorObject().findActorsByFilmId(id);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
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
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
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
	public String getSpecial_features() {
		return special_features;
	}
	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
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
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film [actors=").append(actors).append(", id=").append(id).append(", title=").append(title)
				.append(", description=").append(description).append(", releaseYear=").append(releaseYear)
				.append(", language_id=").append(language_id).append(", rentalDuration=").append(rentalDuration)
				.append(", rentalRate=").append(rentalRate).append(", length=").append(length)
				.append(", replacementCost=").append(replacementCost).append(", rating=").append(rating)
				.append(", special_features=").append(special_features).append("]");
		return builder.toString();
	}
	
}
