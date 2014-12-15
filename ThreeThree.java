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

        //Add this stack to our master stack
        this.masterStack.add(this.stack);
    }

    public void add(final Object item) { 

        //If current stack is at max height
        if(this.stack.getSize() == MAX_SIZE) {

            //Make a new stack and add the item to it
            stack = new CustomStack();
            stack.add(item);

            //Add it to the master stack
            masterStack.add(stack);
        }

        //If current stack is not at max height
        else { 
            this.stack.add(item);
        }
    }

    public Object pop() { 

        //If our stack has no more items
        if(this.stack.getSize() == 0) { 

            //Remove it from master stack
            this.masterStack.pop();

            //Get the next stack and return its value
            this.stack = (CustomStack) this.masterStack.peek();
            return this.stack.pop();
        }

        //If our stack has more values
        else { 
            return this.stack.pop();
        }
    }
}
