/** 
 * Written by Ryan D'souza
 * Represents a binary search tree */

public class CustomBinarySearchTree { 
    private final Node root;
    private int size;

    public static class Node { 
        public Object key, value;
        public Node leftChild, rightChild;

        public Node() { 
            this.key = null;
            this.value = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public Node(final Object key, final Object value) { 
            this();
            this.key = key;
            this.value = value;
        }
    }

    public CustomBinarySearchTree() { 
        this.root = new Node();
        this.size = 0;
    }

    public void add(final Object key, final Object value) { 

        //If it's the first element
        if(this.root.key == null) { 
            this.root.key = key;
            this.root.value = value;
            this.size++;
            return;
        }

        boolean toContinue = true;
        Node currentNode = this.root;
        
        while(toContinue) { 
            final int compareToValue = key.toString().compareTo(currentNode.key.toString());

            //The same, just replace
            if(compareToValue == 0) { 
                currentNode.value = value;
                return;
            }
            //Less than, left side
            else if(compareToValue < 0) { 
                //If there is no smaller child, add it
                if(currentNode.leftChild == null) { 
                    System.out.println(key.toString() + " null less than");
                    currentNode.leftChild = new Node(key, value);
                    return;
                }
                else { 
                    System.out.println(key.toString() + " smaller ");
                    currentNode = currentNode.leftChild;
                }
            }
            //Greater, right side
            else { 
                //If no bigger child, add it
                if(currentNode.rightChild == null) { 
                    currentNode.rightChild = new Node(key, value);
                    System.out.println(key.toString() + " null greater than");
                    return;
                }
                else { 
                    System.out.println(key.toString() + " greater");
                    currentNode = currentNode.rightChild;
                }
            }
        }
    }

    public static void main(String[] ryan) { 
        final CustomBinarySearchTree tree = new CustomBinarySearchTree();

        for(String r : ryan) { 
            tree.add(r, r);
        }
    }
}
