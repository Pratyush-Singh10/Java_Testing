package com.example.au_demo_live;

public class LinkedList<T> {
    private Node<T> headNode;

    /*
    * 1. index =-1 ---> Exception should be thrown
    * 2. index less than the size --> element should be returned
    * 3. index greater than the size --> null || throw exception
     */

    public T getElement(int index){
        if(index<0){
            throw new RuntimeException("Index Cannot be Negative");
        }
        var iteratorNode=headNode;
        var currIndex=0;
        while (iteratorNode!=null) {
            if (currIndex == index) {
                return iteratorNode.getValue();
            }
            iteratorNode = iteratorNode.getNextNode();
            currIndex++;
        }

        throw new RuntimeException("Index greater than the size of the List");

    }

    public int addElement(T element)
    {
        final var tempNode = new Node<T>();

        if(element==null)
            throw new RuntimeException("Cannot add NULL Value");
        tempNode.setValue(element);

        if(headNode==null)
        {
            headNode=tempNode;

        }
        var iteratorNode=headNode;
        while(iteratorNode.getNextNode()!=null) {
            iteratorNode=iteratorNode.getNextNode();
        }
        iteratorNode.setNextNode(tempNode);

        int len=getLength();
        return len;
    }

    public int getLength()
    {
        Node tempNode=headNode;
        int length=0;
        while(tempNode!=null)
        {
            length+=1;
            tempNode=tempNode.getNextNode();
        }
        return length;
    }
}


class Node<T>{
    private T value;

    private Node<T> nextNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    public Node<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

}
