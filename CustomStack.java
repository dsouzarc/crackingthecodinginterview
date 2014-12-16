/** 
 * Written by Ryan D'souza
 * Custom Stack data structure written for Cracking the Coding Interview Practice */

public class CustomStack { 
    private int size;
    private Node item;

    public CustomStack() { 
        this.size = 0;
        this.item = new Node();
    }

    public void add(final Object object) { 
        size++;
        if(this.item == null) { 
            this.item = new Node(object);
        }
        if(this.item.value == null) { 
            this.item.value = object;
        }
        else { 
            final Node newestItem = new Node(object);
            this.item.next = newestItem;
            newestItem.previous = this.item;
            this.item = this.item.next;
        }
    }

    public Object pop() { 
        if(this.size == 0 || this.item == null) { 
            return null;
        }

        this.size--;

        final Object toReturn = this.item.value;
        this.item = this.item.previous;

        return toReturn;
    }

    public Object peek() { 
        if(this.size == 0 || this.item == null) { 
            return null;
        }

        return this.item.value;
    }

    public int getSize() { 
        return this.size;
    }

    public void removeAll() { 
        this.size = 0;
        this.item = null;
    }

    public static void main(String[] ryan) { 
        final CustomStack names = new CustomStack();

        for(String r : ryan) { 
            names.add(r);
        }

        Object val = names.pop();

        while(val != null) {
            System.out.println(val.toString());
            val = names.pop();
        }
    }
}

