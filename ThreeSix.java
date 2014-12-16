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
        final int numElements = theStack.getSize();

        boolean toContinue = true;
        int num = 0;

        while(toContinue) { 
            if(num == numElements) { 
                toContinue = false;
                return;
            }

            //Don't consider the largest elements
            for(int i = 0; i < num; i++) { 
                temp.add(theStack.pop());
            }

            //Find the largest number
            Integer largestNumber = Integer.MIN_VALUE;

            while(theStack.getSize() != 0) { 
                final Integer value = (Integer) theStack.pop();

                if(value > largestNumber) { 
                    largestNumber = value;
                }
                else { 
                    temp.add(value);
                }
            }

            //Begin adding the elements back
            for(int i = 0; i < numElements - num; i++) { 
                if(temp.peek() != null) { 
                    theStack.add(temp.pop());
                }
            }

            //Pause to add the next biggest element
            theStack.add(largestNumber);

            //Add the other numbers back
            while(temp.getSize() != 0) { 
                theStack.add(temp.pop());
            }

            num++;
        }
    }


    public static void main(String[] ryan) { 
        final Random generator = new Random();
        final ThreeSix obj = new ThreeSix();

        for(int i = 0; i < 10; i++) { 
            final int number = generator.nextInt(100);
            obj.push(number);
            System.out.println("Adding: " + number);
        }
        obj.sort();

        System.out.println("\nAfter sorting\n");
        while(!obj.isEmpty()) { 
            System.out.println(obj.pop());
        }
    }
}
