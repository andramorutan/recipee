package ro.andramorutan.blog.service;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import ro.andramorutan.blog.model.Recipe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class PdfService
{
  @Autowired
  private RecipeService recipeService;
  private static final String JSXML_PATH = "/Users/andra.lapusan/Documents/personale/blog/src/main/resources/%s.pdf";

  public String exportReport(Integer id) throws FileNotFoundException, JRException
  {
    Recipe recipe = recipeService.getRecipe(id);

    File file = ResourceUtils.getFile("classpath:pdf/pdf.jrxml");
    JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
    jasperReport.setProperty("net.sf.jasperreports.default.pdf.encoding", "Cp1252");

    Map<String, Object> parameters = new HashMap<>();
    parameters.put("name", recipe.getName());
    parameters.put("recipe_from", recipe.getRecipeFrom());
    parameters.put("ingredients", recipe.getIngredients());
    parameters.put("instructions", recipe.getInstructions());
    parameters.put("notes", recipe.getNotes());

    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());

    String path = String.format(JSXML_PATH, recipe.getName().replace(' ', '_')) ;
    JasperExportManager.exportReportToPdfFile(jasperPrint, path);
    return path;
  }

}
