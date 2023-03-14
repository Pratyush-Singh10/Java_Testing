package com.example.au_demo_live;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTest {

    @Test
    @DisplayName("Given the index is negative, getElement() should throw RunTimeException should be throw")

    public void testGetElement_shouldThrowExceptionOnNegativeIndex(){
        final var list = new LinkedList<Integer>();
        assertThrows(RuntimeException.class, () -> list.getElement(-1));
    }

    @Test
    @DisplayName("Given Valid Index, getElement() should return the value")
    void testGetElement_shouldReturnElementOnValidIndex(){
        final var list=new LinkedList<Integer>();

        list.addElement(10);
        assertEquals(10,list.getElement(0));
    }

    @Test
    @DisplayName("If index is Greater than Size throw RunTime Exception")
    void testGetElement_shouldThrowExceptionOnIndexGreaterThanSize(){
        final var list=new LinkedList<Integer>();

        list.addElement(10);
        list.addElement(20);
        final var exception= assertThrows(RuntimeException.class, () -> list.getElement(2));
        assertEquals("Index greater than the size of the List", exception.getMessage());
    }

    @Test
    @DisplayName("Check if Length Increases or Not")
    void testAddElement_shouldThrowExceptionOnAddingElementByCheckingSize() {

        final var list=new LinkedList<Integer>();

        list.addElement(10);
        list.addElement(20);
        int curr=list.getLength();
        list.addElement(30);
        assertEquals(list.getLength(),curr+1);
    }
}
