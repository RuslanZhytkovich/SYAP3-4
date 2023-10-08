package com.lab3.lab3;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorHandler implements ErrorController
{
    @RequestMapping("/error")
    public String handleError()
    {
        return "error";

    }


}