package ro.andramorutan.blog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import ro.andramorutan.blog.service.RecipeService;

@Controller
public class BaseController {

    @Autowired
    protected RecipeService recipeService;

    @ModelAttribute
    public void addRecipiesToModel(Model model) {
        model.addAttribute("recipes", recipeService.recipeList());
    }
}
