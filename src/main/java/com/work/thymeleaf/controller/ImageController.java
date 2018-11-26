package com.work.thymeleaf.controller;

import com.work.thymeleaf.form.ImageForm;
import com.work.thymeleaf.form.PersonForm;
import com.work.thymeleaf.model.Image;
import com.work.thymeleaf.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlVlShcherbakov on 26.11.2018.
 */
@Controller
public class ImageController {

    private static List<String> urls = new ArrayList<>();
    private int countOfImages = urls.size();

    @RequestMapping(value = {"/addByURL"}, method = RequestMethod.GET)
    public String showAddByURLPage(Model model){
        ImageForm imageForm = new ImageForm();
        model.addAttribute("imageForm", imageForm);
        return "addByURL";
    }

    @RequestMapping(value = {"/addByURL"}, method = RequestMethod.POST)
    public String savePerson(Model model,
                             @ModelAttribute("imageForm")
                                     ImageForm imageForm,
                             @RequestParam(value="action")
                                     String action) {

        if (action.equals("Create")) {

            int id = countOfImages;
            String url = imageForm.getUrl();

            if (url!=null && url.length()>0) {
                Image image = new Image(id, imageForm.getUrl());
                urls.add(imageForm.getUrl());
                return "redirect:/showImage";
            }
        }
        else {
            return "index";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }


}
