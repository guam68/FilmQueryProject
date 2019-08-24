package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;

public interface DatabaseAccessor {
  public List<Actor> findActorsByFilmId(int filmId);
}
