package com.ninos.controller;

import com.ninos.dao.ExpenseDTO;
import com.ninos.service.ExpenseService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
