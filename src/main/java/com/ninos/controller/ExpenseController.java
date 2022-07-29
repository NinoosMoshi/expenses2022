package com.ninos.controller;

import com.ninos.service.ExpenseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;


    @GetMapping("/all")
    public String showExpenseList(Model model) {
        model.addAttribute("expenses",expenseService.getAllExpenses());
        return "expenses-list";
    }
}
