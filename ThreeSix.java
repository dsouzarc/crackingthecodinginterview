import java.util.Random;

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

    public void sort() { 
    }


    public static void main(String[] ryan) { 
        final Random generator = new Random();
        final ThreeSix obj = new ThreeSix();

        for(int i = 0; i < 10; i++) { 
            final int number = generator.nextInt(100);
            obj.push(i);
            System.out.println("Adding: " + number);
        }
        obj.sort();
    }
}
