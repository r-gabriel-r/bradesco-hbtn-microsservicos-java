package com.example.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
       RequestBuilder request = get("/calculator/welcome");
       MvcResult result = mvc.perform(request).andReturn();
       assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
    	RequestBuilder request = get("/calculator/addNumbers?number1=5&number2=10");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("15.0", result.getResponse().getContentAsString());
    }
    
    @Test
    void subNumbers() throws Exception {
    	RequestBuilder request = get("/calculator/subNumbers?number1=5&number2=10");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("-5.0", result.getResponse().getContentAsString());
    }
    
    @Test
    void divideNumbers() throws Exception {
    	RequestBuilder request = get("/calculator/divideNumbers?number1=500&number2=10");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("50.0", result.getResponse().getContentAsString());
    }
    
    @Test
    void factorial() throws Exception {
    	RequestBuilder request = get("/calculator/factorial?factorial=6");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("720", result.getResponse().getContentAsString());
    }
    
    @Test
    void calculeDayBetweenDate() throws Exception {
    	RequestBuilder request = get("/calculator/calculeDayBetweenDate?localDate1=2025-12-05&localDate2=2025-12-17");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("12", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
    	RequestBuilder request = get("/calculator/integerToBinary?number1=128");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("10000000", result.getResponse().getContentAsString());
    }
    
    @Test
    void integerToHexadecimal() throws Exception {
    	RequestBuilder request = get("/calculator/integerToHexadecimal?number1=170");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("aa", result.getResponse().getContentAsString());
    }
    
}