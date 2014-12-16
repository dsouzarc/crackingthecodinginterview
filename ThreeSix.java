/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 3.6
 * Sorts a stack in ascending order
 * Uses at most one additional stack to hold items
 * No other data structures can be used */

public class ThreeSix { 
    private final CustomStack theStack;

    public ThreeSix() { 
        this.theStack = new CustomStack();
    }

    public void push(final Object obj) { 
        this.theStack.add(obj);
    }

    public Object pop() { 
        return this.theStack.pop();
    }

    public Object peek() { 
        return this.theStack.peek();
    }

    public boolean isEmpty() { 
        return this.theStack.getSize() == 0;
    }
}
