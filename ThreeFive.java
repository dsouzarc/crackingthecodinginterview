/** 
 * Written by Ryan D'souza
 * 3.5 Cracking the Coding Interview
 * A queue created by using two stacks */

public class ThreeFive { 
    private final CustomStack oldestItems, newestItems;

    public ThreeFive() { 
        this.oldestItems = new CustomStack();
        this.newestItems = new CustomStack();
    }

    public int size() { 
        return this.oldestItems.getSize() + this.newestItems.getSize();
    }

    public void add(final Object toAdd) { 
        //Add it to the newest stack
        newestItems.add(toAdd);

        //Add all the items from the old stack to the new stack
        while(this.oldestItems.getSize() != 0) { 
            this.newestItems.add(this.oldestItems.pop());
        }

        //Add everything back to the new stack so it's in queue order
        while(this.newestItems.getSize() != 0) { 
            this.oldestItems.add(this.newestItems.pop());
        }
    }

    public Object pop() { 
        return this.oldestItems.pop();
    }

    public static void main(String[] ryan) { 
        final ThreeFive obj = new ThreeFive();

        for(String r : ryan) { 
            obj.add(r);
        }
    }
}
