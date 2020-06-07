package com.shashi.userservice.Controller;

import com.shashi.userservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author akshaygupta01
 */
@Controller
@RequestMapping(value = "/storefront")
public class UserStorefrontController
{
    @Autowired
    private UserRepository repository;

    @GetMapping("/usersDashboard")
    public String usersDashboard()
    {
        ModelAndView model = new ModelAndView("user");
        model.addObject("users",repository.findAll());
        return "user";
    }
}
