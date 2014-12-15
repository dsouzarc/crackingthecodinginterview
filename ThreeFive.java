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

    public ThreeFive() { 
        this.oldestItems = new CustomStack();
        this.newestItems = new CustomStack();
    }

    public void add(final Object toAdd) { 

        //Add all the items from the old stack to the new one, thereby reversing order
        while(this.oldestItems.getSize() != 0) {
            this.newestItems.add(this.oldestItems.pop());
        }

        //Add the newest item
        this.newestItems.add(toAdd);

        //Add items back to old stack, putting order in FIFO form
        while(this.newestItems.getSize() != 0) { 
            this.oldestItems.add(this.newestItems.pop());
        }
    }

    public Object pop() { 
        return this.oldestItems.pop();
    }

    public int size() { 
        return this.oldestItems.getSize() + this.newestItems.getSize();
    }

    public static void main(String[] ryan) { 
        final ThreeFive obj = new ThreeFive();

        for(String r : ryan) { 
            obj.add(r);
        }

        System.out.println("Dequeueing");
        while(obj.size() != 0) { 
            System.out.println(obj.pop().toString());
        }
    }
}
