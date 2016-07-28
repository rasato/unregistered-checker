package ch72.net.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by asato on 2016/07/28.
 */
@Controller
@RequestMapping("unregistered-checker")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET)
    String menu() {
        return "top/menu";
    }

    @RequestMapping(value = "register", method = RequestMethod.GET)
    String register() {
        return "top/register";
    }

    @RequestMapping(value = "check", method = RequestMethod.GET)
    String check() {
        return "top/check";
    }

    @RequestMapping(value = "register", params = "goToMenu")
    String goToMenu() {
        return "redirect:/unregistered-checker";
    }

}
