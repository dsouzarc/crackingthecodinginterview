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
        //newestItems.add(toAdd);

        while(this.oldestItems.getSize() != 0) {
            this.newestItems.add(this.oldestItems.pop());
        }

        this.newestItems.add(toAdd);

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

        System.out.println("Dequeueing");
        while(obj.size() != 0) { 
            System.out.println(obj.pop().toString());
        }
    }
}
