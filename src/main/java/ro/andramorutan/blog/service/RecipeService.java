package ro.andramorutan.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ro.andramorutan.blog.model.Category;
import ro.andramorutan.blog.model.Recipe;
import ro.andramorutan.blog.repository.RecipeRepository;
import ro.andramorutan.blog.web.model.RecipeForm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe createRecipe(RecipeForm form) {
        Recipe recipe = new Recipe();
        populateRecipe(form, recipe);
        return recipeRepository.save(recipe);
    }

    private void populateRecipe(RecipeForm form, Recipe recipe) {
        recipe.setName(form.getName());
        recipe.setRecipeFrom(form.getFrom());
        recipe.setIngredients(getCapitalizedLines(form.getIngredients()));
        recipe.setInstructions(getCapitalizedLines(form.getInstructions()));
        recipe.setNotes(getCapitalizedLines(form.getNotes()));
        recipe.setPdfUrl(form.getPdfUrl());
        recipe.setHashtags(form.getHashTags());
        recipe.setCategory(Category.valueOf(form.getCategory()));
    }

    private List<String> getCapitalizedLines(String formField) {
        List<String> result = null;
        if (formField != null) {
            String[] split = formField.trim().split("\n");
            result = Arrays.stream(split).map(s -> StringUtils.capitalize(s.toLowerCase())).collect(Collectors.toList());
        }

        return result;
    }

    public Recipe getRecipe(Integer id) {
        return recipeRepository.findById(id).get();
    }

    public List<Recipe> recipeList() {
        return (List<Recipe>) recipeRepository.findAll();
    }

    public Recipe updateRecipe(RecipeForm recipeForm, Integer id) {
        Recipe recipe = recipeRepository.findById(id).get();
        populateRecipe(recipeForm, recipe);
        return recipeRepository.save(recipe);
    }

    public void delete(Integer id) {
        recipeRepository.deleteById(id);
    }
}
