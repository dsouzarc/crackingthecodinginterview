/** 
 * Written by Ryan D'souza
 * Represents a binary search tree */

public class CustomBinarySearchTree { 
    private final Node root;

    public static class Node { 
        public Key key;
        public Value value;
        public Node leftChild, rightChild;
        private int size;

        public Node() { 
            this.key = null;
            this.value = null;
            this.leftChild = null;
            this.rightChild = null;
            this.size = 0;
        }

        public Node(final Key key, final Value value) { 
            this();
            this.key = key;
            this.value = value;
        }

        public Node(final Key key, final Value value, final int size) { 
            this(key, value);
            this.size = size;
        }
    }


