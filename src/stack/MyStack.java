package stack;

import java.util.EmptyStackException;

public class MyStack {

    private int numberOfElements;
    private String[] container;

    public MyStack(int size){
        container = new String[size];

    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void push(String element) {
        if(numberOfElements >= container.length){
            throw new StackOverflowError("Stack is full");
        }
        container[numberOfElements] = element;
        numberOfElements++;

    }


    public String pop() {
        if (numberOfElements <= 0){
            throw new EmptyStackException();
        }
        String lastElement = peek();
        --numberOfElements;
        return lastElement;
    }

    public int count() {
        return numberOfElements;
    }

   public String peek() {
       return container[count() - 1];
   }




}
