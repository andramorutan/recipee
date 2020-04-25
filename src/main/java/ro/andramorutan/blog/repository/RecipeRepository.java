package ro.andramorutan.blog.repository;

import org.springframework.data.repository.CrudRepository;
import ro.andramorutan.blog.model.Category;
import ro.andramorutan.blog.model.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

    List<Recipe> findRecipesByCategory(Category category);
}
