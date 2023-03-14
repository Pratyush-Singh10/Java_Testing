package com.example.au_demo_live.controller;

import com.example.au_demo_live.Employee;
import com.example.au_demo_live.exception.EmployeeNotFound;
import com.example.au_demo_live.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class EmployeeControllerTest {

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private MockMvc mockMvc;

    List<Employee> createMockEmployees(){
        final var employees=new ArrayList<Employee>();
        employees.add(new Employee("1","John","1456"));
        employees.add(new Employee("2","Sam","1298"));
        employees.add(new Employee("3","Jacob","1532"));

        return employees;
    }

    @Test
    @DisplayName("/employees should return all employees")
    void testGetAllEmployees() throws Exception {
        final var expected=new ObjectMapper().writeValueAsString(createMockEmployees());
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    void testGetEmployee_shouldReturn404() throws Exception {
        when(employeeService.getEmployee(anyString())).thenThrow(new EmployeeNotFound());

        mockMvc.perform(get("/employee/123"))
                .andExpect(status().isNotFound());
    }
}
