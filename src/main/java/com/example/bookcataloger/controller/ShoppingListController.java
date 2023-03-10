package com.example.bookcataloger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingListController {
    @RequestMapping("/")
    public String index() {
        return "list";
    }

    @GetMapping("/add")
    public String add() {
        return "add-book";
    }

    @GetMapping("/update")
    public String edit() {
        return "change";
    }
}