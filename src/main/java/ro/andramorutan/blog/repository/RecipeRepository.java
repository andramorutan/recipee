package ro.andramorutan.blog.repository;

import ro.andramorutan.blog.model.Recipe;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Integer>
{}
