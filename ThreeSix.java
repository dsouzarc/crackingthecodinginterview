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
        final CustomStack temp = new CustomStack();
        final int size = theStack.getSize();

        for(int i = 0; i < size; i++) { 
            Integer largestVal = Integer.MIN_VALUE;

            while(theStack.getSize() != 0) {
                final Integer val = (Integer) theStack.pop();

                if(val > largestVal) { 
                    largestVal = val;
                }
                else { 
                    temp.add(val);
                }
            }

            while(temp.getSize() != 0) { 
                theStack.add(temp.pop());
            }
            theStack.add(largestVal);
        }
        
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

        System.out.println("\nAfter sorting\n");
        while(!obj.isEmpty()) { 
            System.out.prntln(theObj.pop());
        }
    }
}
