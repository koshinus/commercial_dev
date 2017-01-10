package ru.naumen.controllers;

import javax.inject.Inject;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.naumen.entities.Professor;
import ru.naumen.model.ProfessorDao;
import ru.naumen.model.StudentDao;

/**
 * @author aarkaev
 */
@Controller
public class HomeController {

    @Inject
    private StudentDao storage;

    @Inject
    private ProfessorDao pDAO;
    
    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("name", "Мир");
        model.addAttribute("allStudents", storage.findAll());
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String reg(Model model) {
        Professor p = new Professor();
        model.addAttribute("userForm", p);
        return "createPr";
    }

    @PostMapping("registration")
    public String regForm (@ModelAttribute("userForm")Professor professor){
        pDAO.save(professor);
        return "/login";
    }

}
