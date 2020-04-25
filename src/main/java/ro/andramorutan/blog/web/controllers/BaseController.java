package ro.andramorutan.blog.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import ro.andramorutan.blog.model.Category;
import ro.andramorutan.blog.service.RecipeService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BaseController {

    @Autowired
    protected RecipeService recipeService;

    @ModelAttribute
    public void addRecipiesToModel(Model model) {
        List<String> collect = Arrays.stream(Category.values()).map(Enum::name).collect(Collectors.toList());
        model.addAttribute("categories", collect);
    }
}
