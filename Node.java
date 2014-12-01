/** 
 * Written by Ryan D'souza
 * Represents a single node */

public class Node implements Comparable<Node> { 
    public Object value;

    //For single linkedlist
    public Node next;

    //For doubley linkedlist
    public Node previous;

    public Node() { 
    }

    public Node (Object value) { 
        this.value = value;
    }

    public Node (Object value, Node next) { 
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(final Object other) { 
        if(!(other instanceof Node)) { 
            return false;
        }
        final Node otherNode = (Node) other;
        return otherNode.value.toString().equals(this.value.toString());
    }

    @Override
    public String toString() { 
        return this.value.toString() + " NEXT: " + next;
    }

    @Override
    public int compareTo(final Node other) { 
        return this.value.toString().compareTo(other.value.toString());
    }
}
