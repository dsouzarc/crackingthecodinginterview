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
    }

    public static void main(String[] ryan) { 
        final ThreeFive obj = new ThreeFive();

        for(String r : ryan) { 
            obj.add(r);
        }
    }
}
