package ro.andramorutan.blog.web.controllers;

import net.sf.jasperreports.engine.JRException;
import ro.andramorutan.blog.service.PdfService;
import ro.andramorutan.blog.service.RecipeService;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController
{
  @Autowired
  private RecipeService recipeService;

  @Autowired
  private PdfService pdfService;

  @GetMapping("/")
  public String home(Model model)
  {
    model.addAttribute("recipes", recipeService.recipeList());
    return "home";
  }

  @GetMapping("/generate/{id}")
  public String generate(@PathVariable Integer id) throws FileNotFoundException, JRException
  {
    System.out.println(pdfService.exportReport(id));
    return "home";
  }


}
