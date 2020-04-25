package ro.andramorutan.blog.repository;

import org.springframework.data.repository.CrudRepository;
import ro.andramorutan.blog.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
}
