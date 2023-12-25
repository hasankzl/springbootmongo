package com.hasankzl.mongodbtutorial.service;

import com.hasankzl.mongodbtutorial.model.Expense;
import com.hasankzl.mongodbtutorial.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    public void addExpense(Expense expense){
        expenseRepository.insert(expense);
    }
    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find expense by id %s",expense.getId())
                ));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(expense);
    }
    public List<Expense> getAllExpense(){
    return   expenseRepository.findAll();
    }
    public Expense getExpenseByName(String name){
     return   expenseRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find by given name %s",name)
                ));
    }
    public void deleteExpense(String id){
        expenseRepository.deleteById(id);
    }


}
