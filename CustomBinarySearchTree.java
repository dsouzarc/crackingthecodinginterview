/** 
 * Written by Ryan D'souza
 * Represents a binary search tree */

public class CustomBinarySearchTree { 
    private final Node root;

    public static class Node { 
        public Key key;
        public Value value;
        public Node leftChild, rightChild;
        public int size;

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

    public int size() { 
        return calcSize(root);
    }

    private int calcSize(final Node node) { 
        if(node == null) { 
            return 0;
        }
        return node.size;
    }

    public Value get(final Key key) { 
        return get(this.root, key);
    }

    private Value get(final Node node, final Key key) { 
        if(node == null || key == null) { 
            return null;
        }

        final int compareVal = key.compareTo(node.key);

        //If they are the same, match
        if(compareVal == 0) { 
            return node.value;
        }
        //If it's less than
        else if(compareVal < 0) { 
            return get(node.leftChild, key);
        }
        //If it's greater than
        else {
            return get(node.rightChild, key);
        }
    }

    public boolean contains(final Key key) { 
        return get(key) != null;
    }

    public void add(final Key key, final Value value) { 
        add(this.root, key, value);
    }

    private void add(final Node current, final Key key, final Value value) { 
        boolean toContinue = true;
        
        while(toContinue) { 
            final int compareTo = key.compareTo(current.key);

            //If the item already exists, replace it
            if(compareTo == 0) { 
                current.value = value;
            }
            //If its less than
            else if(compareTo < 0) { 
                //And there are no smaller values, add it
                if(current.leftChild == null) { 
                    current.leftChild = new Node(key, value);
                    toContinue = false;
                    return;
                }
                else { 
                    compareTo = current.leftChild;
                }
            }
            //Greater than
            else { 
                //And no larger values
                if(current.rightChild == null) { 
                    current.rightChild = new Node(key, value);
                    toContinue = false;
                    return;
                }
                else { 
                    compareTo = current.rightChild;
                }
            }
            current.size = 1 + size(current.leftChild) + size(current.rightChild);
        }
    }
}
