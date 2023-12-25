package com.hasankzl.mongodbtutorial.controller;


import com.hasankzl.mongodbtutorial.model.Expense;
import com.hasankzl.mongodbtutorial.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }


    @PostMapping
    public ResponseEntity<Object> addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){

        expenseService.updateExpense(expense);

        return ResponseEntity.ok(expense);
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpense(){
       return ResponseEntity.ok(expenseService.getAllExpense());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name){
      return ResponseEntity.ok(expenseService.getExpenseByName(name)) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
