/** 
 * Written by Ryan D'souza
 * Represents a binary search tree */

public class CustomBinarySearchTree { 

    /** A different type of node */
    public static class Node { 
        public Node leftChild, rightChild;
        private int size;
        public Object value, key;

        public Node() { 
            this.leftChild = null;
            this.rightChild = null;
            this.size = 1;
            this.value = null;
            this.key = null;
        }

        public Node(final Object value, final Object key) { 
            this();
            this.value = value;
            this.key = key;
        }

        public Node(final Object value, final Object key, final int size) { 
            this(value, key);
            this.size = size + 1;
        }
    }
}


