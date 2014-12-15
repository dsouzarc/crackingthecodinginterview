/** 
 * Written by Ryan D'souza
 * 3.3 Cracking the Coding Interview
 * A Stack of Stacks where a new stack is added after a certain # of elements have been added */

public class ThreeThree { 
    //Max size of a stack
    private static final int MAX_SIZE = 5;

    //A stack to hold all stacks
    private final CustomStack masterStack;

    //Current stack
    private CustomStack stack;

    public ThreeThree() { 
        this.masterStack = new CustomStack();
        this.stack = new CustomStack();

        this.masterStack.add(this.stack);
    }

    public void add(final Object item) { 
        if(this.stack.getSize() == MAX_SIZE) { 
            stack = new CustomStack();
            stack.add(item);
            masterStack.add(stack);
        }

        else { 
            this.stack.add(item);
        }
    }

    public Object pop() { 
        if(this.stack.getSize() == 0) { 
            this.masterStack.pop();
            this.stack = (CustomStack) this.masterStack.peek();
            return this.stack.pop();
        }
        else { 
            return this.stack.pop();
        }
    }
}
