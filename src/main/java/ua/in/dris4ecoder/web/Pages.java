package ua.in.dris4ecoder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alex Korneyko on 12.10.2016 11:19.
 */
@Controller
public class Pages {

    @RequestMapping(value = "/adminPage")
    public ModelAndView adminPageController() {

        return new ModelAndView("adminPage");
    }

    @RequestMapping(value = "/userPage")
    public ModelAndView userPageController() {

        return new ModelAndView("userPage");
    }
}
