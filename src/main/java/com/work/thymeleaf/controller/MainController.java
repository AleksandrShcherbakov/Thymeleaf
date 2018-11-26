package com.work.thymeleaf.controller;

import com.work.thymeleaf.form.PersonForm;
import com.work.thymeleaf.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlVlShcherbakov on 21.11.2018.
 */

@Controller
public class MainController {

    private static List<String> urls = new ArrayList<>();
    private int countOfImages = urls.size();
    private static List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("aa","bb"));
    }

    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message", message);
        return "index";
    }

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String personList(Model model) {
        model.addAttribute("persons", persons);
        return "personList";
    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model){
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
        return "addPerson";
    }

    @RequestMapping(value = {"/addPerson"}, method = RequestMethod.POST)
    public String savePerson(Model model,
                             @ModelAttribute("personForm")
                                     PersonForm personForm,
                             @RequestParam(value="action")
                                         String action) {

        if (action.equals("Create")) {

            String firstName = personForm.getFirstName();
            String lastName = personForm.getLastName();

            if (firstName != null && firstName.length() > 0 && lastName != null && lastName.length() > 0) {
                Person newPerson = new Person(firstName, lastName);
                persons.add(newPerson);
                return "redirect:/personList";
            }
        }
        else {
            return "index";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }
}




