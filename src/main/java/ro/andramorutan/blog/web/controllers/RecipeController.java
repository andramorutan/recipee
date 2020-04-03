package ro.andramorutan.blog.web.controllers;

import ro.andramorutan.blog.model.Recipe;
import ro.andramorutan.blog.service.RecipeService;
import ro.andramorutan.blog.web.model.RecipeForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/recipe")
public class RecipeController
{
  @Autowired
  private RecipeService recipeService;

  @GetMapping("/{id}")
  public String getRecipe(@PathVariable Integer id, Model model) {
    Recipe recipe = recipeService.getRecipe(id);
    model.addAttribute("recipe", recipe);
    return "recipe";
  }

  @GetMapping("/{id}/insta")
  public String getRecipeForInsta(@PathVariable Integer id, Model model) {
    Recipe recipe = recipeService.getRecipe(id);
    model.addAttribute("recipe", recipe);
    return "recipeInsta";
  }

  @GetMapping("/add")
  public String addRecipe(Model model)
  {
    model.addAttribute("recipe", new RecipeForm());
    return "addRecipe";
  }

  @PostMapping("/add")
  public String recipeSubmit(@ModelAttribute RecipeForm recipeForm)
  {
    Recipe recipe = recipeService.createRecipe(recipeForm);
    return String.format("redirect:/recipe/%s", recipe.getId());
  }

  @GetMapping("/edit/{id}")
  public String edit(@PathVariable Integer id, Model model)
  {
    model.addAttribute("recipe", new RecipeForm(recipeService.getRecipe(id)));
    model.addAttribute("id", id);
    return "addRecipe";
  }

  @PostMapping("/edit/{id}")
  public String submitEdit(@PathVariable Integer id, @ModelAttribute RecipeForm recipeForm)
  {
    Recipe recipe = recipeService.updateRecipe(recipeForm, id);
    return String.format("redirect:/recipe/%s", recipe.getId());
  }
}
