package com.bsuir.analytics.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError (HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value())
                return "404";
            else if (statusCode == HttpStatus.BAD_REQUEST.value())
                return "400";
            else if (statusCode == HttpStatus.FORBIDDEN.value())
                return "403";
        }
        return "error";
    }

    @GetMapping("/400")
    public String badRequestErrorPage() {return "400";}

    @GetMapping("/404")
    public String pageNotFoundErrorPage() {return "404";}
}
