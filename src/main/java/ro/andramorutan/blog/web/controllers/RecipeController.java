package ro.andramorutan.blog.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.andramorutan.blog.Constants;
import ro.andramorutan.blog.model.Recipe;
import ro.andramorutan.blog.web.model.RecipeForm;

@Controller
@RequestMapping(value = "/recipe")
public class RecipeController extends BaseController {

    @GetMapping("/{id}")
    public String getRecipe(@PathVariable Integer id, Model model) {
        Recipe recipe = recipeService.getRecipe(id);
        model.addAttribute(Constants.RECIPE, recipe);
        return Constants.RECIPE;
    }

    @GetMapping("/{id}/insta")
    public String getRecipeForInsta(@PathVariable Integer id, Model model) {
        Recipe recipe = recipeService.getRecipe(id);
        model.addAttribute(Constants.RECIPE, recipe);
        return "recipeInsta";
    }

    @GetMapping("/add")
    public String addRecipe(Model model) {
        model.addAttribute(Constants.RECIPE, new RecipeForm());
        return "addRecipe";
    }

    @PostMapping("/add")
    public String recipeSubmit(@ModelAttribute RecipeForm recipeForm) {
        Recipe recipe = recipeService.createRecipe(recipeForm);
        return String.format(Constants.RECIPE_URL, recipe.getId());
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute(Constants.RECIPE, new RecipeForm(recipeService.getRecipe(id)));
        model.addAttribute("id", id);
        return "addRecipe";
    }

    @PostMapping("/edit/{id}")
    public String submitEdit(@PathVariable Integer id, @ModelAttribute RecipeForm recipeForm) {
        Recipe recipe = recipeService.updateRecipe(recipeForm, id);
        return String.format(Constants.RECIPE_URL, recipe.getId());
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        recipeService.delete(id);
        return "redirect:/";
    }
}
