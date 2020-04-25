package ro.andramorutan.blog.web.controllers;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.andramorutan.blog.service.PdfService;

import java.io.FileNotFoundException;

import static ro.andramorutan.blog.Constants.RECIPE_URL;

@Controller
public class HomeController extends BaseController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/generate/{id}")
    public String generate(@PathVariable Integer id) throws FileNotFoundException, JRException {
        pdfService.exportReport(id);
        return String.format(RECIPE_URL, id);
    }

}
