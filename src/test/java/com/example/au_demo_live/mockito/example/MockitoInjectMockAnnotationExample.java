package com.example.au_demo_live.mockito.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoInjectMockAnnotationExample {

    @Mock
    List<String> mockList;

    @InjectMocks
    Fruits mockFruits;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test(){
        when(mockList.get(0)).thenReturn("Apple");
        when(mockList.size()).thenReturn(1);

        assertEquals("Apple",mockList.get(0));
        assertEquals(1,mockList.size());

        assertEquals("Apple",mockFruits.getNames().get(0));
        assertEquals(1,mockFruits.getNames().size());
    }
}

class Fruits{
    private List<String> names;

    public List<String> getNames(){
        return names;
    }

    public void setNames(List<String> name){
        this.names=name;
    }
}



