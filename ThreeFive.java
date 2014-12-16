/** 
 * Written by Ryan D'souza
 * 3.5 Cracking the Coding Interview
 * A queue created by using two stacks 
 *
 * Run Instructions: 
 * 1. javac ThreeFive.java CustomStack.java Node.java
 * 2. java ThreeFive name1 name2 name3 name4 name5
 *
 * OUTPUT:
 * name1 
 * name2
 * name3
 * name4
 * name5
 * */

public class ThreeFive { 
    private final CustomStack oldestItems, newestItems;
    private boolean needsRestructuring;

    public ThreeFive() { 
        this.oldestItems = new CustomStack();
        this.newestItems = new CustomStack();
        this.needsRestructuring = false;
    }

    public void add(final Object toAdd) { 

        //Add all the items from the old stack to the new one, thereby reversing order
        while(this.oldestItems.getSize() != 0) {
            this.newestItems.add(this.oldestItems.pop());
        }

        //Add the newest item
        this.newestItems.add(toAdd);

        //We need restructuring since we just added an item
        this.needsRestructuring = true;
    }

    private void restructure() { 

        //Add items back to old stack, putting order in FIFO form
        while(this.newestItems.getSize() != 0) { 
            this.oldestItems.add(this.newestItems.pop());
        }

        needsRestructuring = false;
    }

    public Object pop() { 
        if(needsRestructuring) { 
            restructure();
        }

        return this.oldestItems.pop();
    }

    public Object peek() { 
        if(needsRestructuring) { 
            restructure();
        }

        return this.oldestItems.peek();
    }

    public int size() { 
        return this.oldestItems.getSize() + this.newestItems.getSize();
    }

    public static void main(String[] ryan) { 
        final ThreeFive obj = new ThreeFive();

        for(String r : ryan) { 
            obj.add(r);
        }

        //For testing
        System.out.println("First element: " + obj.peek());

        //Add some more elements for testing
        for(int i = 0; i < 9; i++) { 
            obj.add("Test element #: " + i);
        }

        System.out.println("Dequeueing");
        while(obj.size() != 0) { 
            System.out.println(obj.pop().toString());
        }
    }
}
