package com.ninos.service;

import java.util.List;
import java.util.stream.Collectors;


import com.ninos.dao.ExpenseDTO;
import com.ninos.entity.Expense;
import com.ninos.repository.ExpenseRepository;

import com.ninos.util.DateTimeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> list = expenseRepository.findAll();
        List<ExpenseDTO> expenseList = list.stream().map(this::mapToDTO).collect(Collectors.toList());
        return expenseList;
    }


    private ExpenseDTO mapToDTO(Expense expense) {
        ExpenseDTO expenseDTO = modelMapper.map(expense, ExpenseDTO.class);
        expenseDTO.setDateString(DateTimeUtil.convertDateToString(expenseDTO.getDate()));
        return expenseDTO;
    }


//    private ExpenseDTO mapToDTO(Expense expense) {
//      ExpenseDTO expenseDTO = new ExpenseDTO();
//      expenseDTO.setId(expense.getId());
//      expenseDTO.setExpenseId(expense.getExpenseId());
//      expenseDTO.setName(expense.getName());
//      expenseDTO.setDescription(expense.getDescription());
//      expenseDTO.setAmount(expense.getAmount());
//      expenseDTO.setDate(expense.getDate());
//      return expenseDTO;
//    }


}

