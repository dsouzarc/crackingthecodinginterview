/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview Prep.
 * Represents a queue data structure (FIFO) */

public class CustomQueue {
    private Node firstItem, lastItem;
    private int size;

    public CustomQueue() { 
        this.size = 0;
    }

    public void add(final Object value) { 
        if(this.firstItem == null || this.firstItem.value == null || this.size == 0) { 
            this.firstItem = new Node(value);
            this.lastItem = new Node();
            this.firstItem.next = this.lastItem;
        }

        else { 
            final Node newestVal = new Node(value);
            this.lastItem.next = newestVal;
            this.lastItem = this.lastItem.next;
            System.out.println("HERE " + this.lastItem.value + " " + this.firstItem.value + this.firstItem.next == null ? "nul" : this.firstItem.next.value);
        }

        this.size++;
    }

    public Object dequeue() { 
        if(this.size == 0) {
            return null;
        }

        this.size--;
        final Object value = this.firstItem.value;
        this.firstItem = this.firstItem.next;

        return value;
    }

    public int getSize() { 
        return this.size;
    }

    public static void main(String[] ryan) { 
        final CustomQueue vals = new CustomQueue();

        for(String r : ryan) { 
            vals.add(r);
        }

        System.out.println("Size: " + vals.getSize());

        Object first = vals.dequeue();

        while(first != null) { 
            System.out.println(first.toString());
            first = vals.dequeue();
        }
    }
}
