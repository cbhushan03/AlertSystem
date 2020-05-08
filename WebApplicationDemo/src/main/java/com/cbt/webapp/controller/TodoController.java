package com.cbt.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cbt.webapp.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	@Autowired
    TodoService service;
	
	@GetMapping("/list-todos")
    public String showTodos(ModelMap model){
        String name = (String) model.get("name");
        model.put("todos", service.retrieveTodos(name));
        return "list-todo";
    }
}
