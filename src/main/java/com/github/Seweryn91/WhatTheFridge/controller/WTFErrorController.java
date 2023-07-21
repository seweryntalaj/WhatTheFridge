package com.github.Seweryn91.WhatTheFridge.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WTFErrorController implements ErrorController {

    public String getErrorPath() {
        return "/error";
    }

    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        String errorPage = "/error/error";
        return errorPage;
    }
}
