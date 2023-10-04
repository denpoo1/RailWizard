package Graff;

public class Stack {
    /**This is a Java code for a Stack data structure.

    The Stack class has three private variables:

    "size" which is set to 200 and determines the maximum size of the stack
    "top" which is the index of the top element of the stack
    "array" which is an integer array that stores the elements of the stack
    The constructor initializes the stack by creating a new integer array of size "size" and setting the top index to -1.

    The class has four methods:

    "push" which adds an element to the top of the stack by incrementing the "top" index and setting the value of the element to the given value.
    "pop" which removes and returns the top element of the stack by decrementing the "top" index.
    "peek" which returns the value of the top element of the stack without removing it.
    "isEmpty" which returns a boolean value indicating if the stack is empty or not by checking if the "top" index is -1.*/
    private int size = 200;
    private int top;
    private int[] array;

    Stack() {
        array = new int[size];
        top = -1;
    }

    void push(int val) {
        array[++top] = val;
    }

    int pop() {
        return array[top--];
    }

    int peek() {
        return array[top];
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}
