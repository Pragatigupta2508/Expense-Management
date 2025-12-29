package com.example.expense.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.expense.model.Expense;
import com.example.expense.service.ExpenseService;

@Controller
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
    public String listExpenses(Model model) {
        model.addAttribute("expenses", service.getAll());
        return "expenses";
    }

    @PostMapping("/expenses")
    public String addExpense(@RequestParam double amount,
                             @RequestParam String description) {

        Expense e = new Expense();
        e.setAmount(amount);
        e.setDescription(description);
        service.save(e);

        return "redirect:/expenses";
    }

    @GetMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/expenses";
    }
}
