/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview
 * 3.1: Implement 3 stacks using a single array */

public class ThreeOne { 
    public final int STACK_SIZE;

    private final Object[] values;

    //For indexes
    private int stack1, stack2, stack3;

    public ThreeOne() { 
        this.STACK_SIZE = 50;
        this.values = new Object[STACK_SIZE];

        this.stack1 = 0;
        this.stack2 = this.STACK_SIZE;
        this.stack3 = this.STACK_SIZE * 2;
    }

    public ThreeOne(final int size) { 
        this.STACK_SIZE = size;
        this.values = new Object[STACK_SIZE];

        this.stack1 = 0;
        this.stack2 = this.STACK_SIZE;
        this.stack3 = this.STACK_SIZE * 2;
    }

    public void push(final int stackNum, final Object value) {
        switch(stackNum) { 
            case 1: 
                if(stack1 < STACK_SIZE) { 
                    values[stack1] = value;
                    stack1++;
                }
                else { 
                    throw new UnsupportedOperationException();
                }
            break;

            case 2:
                if(stack2 < STACK_SIZE * 2) { 
                    values[stack2] = value;
                    stack2++;
                }
                else { 
                    throw new UnsupportedOperationException();
                }
            break;


