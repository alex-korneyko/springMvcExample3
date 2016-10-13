package ua.in.dris4ecoder.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.in.dris4ecoder.Model.Services.UserRegistrationServiceImpl;
import ua.in.dris4ecoder.Model.buisnessObjects.CustomUser;
import ua.in.dris4ecoder.Model.buisnessObjects.CustomUserImpl;

import java.util.Map;

/**
 * Created by Alex Korneyko on 11.10.2016 18:06.
 */
@Controller()
public class MainController {

    UserRegistrationServiceImpl registrationService;

    @RequestMapping(value = "/")
    public ModelAndView indexController(@RequestParam(value = "error", required = false) String error) {

        ModelAndView view = new ModelAndView("index");
        if (error != null) {
            view.addObject("error", "Invalid username or password!");
        }

        return view;
    }

    @RequestMapping(value = "/customLoginPage", method = RequestMethod.GET)
    public ModelAndView loginController() {
        ModelAndView view = new ModelAndView("customLoginPage");

        return view;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationController() {

        ModelAndView view = new ModelAndView("registration");

        return view;
    }

    @RequestMapping(value = "/registrationResult", method = RequestMethod.POST)
    public ModelAndView registrationResultController(@RequestParam Map<String, String> requestValues) {

        ModelAndView view = new ModelAndView();

        if(!requestValues.get("password1").equals(requestValues.get("password2"))) {

            view.setViewName("registration");
            view.addObject("passwordsNotMatch", " ");
            return view;
        }

        CustomUser customUser = new CustomUserImpl(
                requestValues.get("name"),
                requestValues.get("surname"),
                requestValues.get("login"),
                requestValues.get("password1")
        );

        registrationService.registerUser(customUser);

        view.setViewName("registrationResult");

        return view;
    }

    public void setRegistrationService(UserRegistrationServiceImpl registrationService) {
        this.registrationService = registrationService;
    }
}
