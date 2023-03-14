package com.example.au_demo_live.mockito.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MockitoMockAnnotationExample {

    @Mock
    List<String> mockList;

    //Mandatory to OpenMock while using MOCK Annotation
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test(){
        when(mockList.get(0)).thenReturn("");
        assertEquals("",mockList.get(0));
    }
}
