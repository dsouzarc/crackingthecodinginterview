/** 
 * Written by Ryan D'souza
 * Represents a binary search tree */

public class CustomBinarySearchTree { 
    private final Node root;
    private int size, leftSize, rightSize;

    /** Represents each node in the tree */
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

    /** Default constructor */
    public CustomBinarySearchTree() { 
        this.root = new Node();
        this.size = 0;
        this.leftSize = 0;
        this.rightSize = 0;
    }
    
    /** Returns true if it contains the element */
    public boolean contains(final Object key) { 
        boolean toContinue = true;
        Node currentNode = this.root;

        while(toContinue) { 

            //Value of comparing this key with the current node's key
            final int compareToValue = key.toString().compareTo(currentNode.key.toString());

            //If they are the same, it's a match
            if(compareToValue == 0) { 
                return true;
            }

            //Smaller, left side
            else if(compareToValue < 0) { 

                //If there are no smaller elements, it's not there
                if(currentNode.leftChild == null) { 
                    return false;
                }

                //If there are, keep on searching
                else {
                    currentNode = currentNode.leftChild;
                }
            }

            //Bigger, right side
            else { 

                //If no bigger elements, it's not there
                if(currentNode.rightChild == null) { 
                    return false;
                }

                //If there are, keep on searching
                else { 
                    currentNode = currentNode.rightChild;
                }
            }
        }

        //It's not there
        return false;
    }

    /** Add value to the tree */
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

            //Compares the key to this node's key
            final int compareToValue = key.toString().compareTo(currentNode.key.toString());

            //Same key, just replace the value
            if(compareToValue == 0) { 
                currentNode.value = value;
                return;
            }

            //Smaller than this value, left side of tree
            else if(compareToValue < 0) { 

                //If there is no smaller child, add it
                if(currentNode.leftChild == null) { 
                    currentNode.leftChild = new Node(key, value);
                    this.size++;
                    this.leftSize++;
                    System.out.println(key + "\t" + this.leftSize);
                    return;
                }

                //Keep on going until we find a smaller child
                else { 
                    currentNode = currentNode.leftChild;
                }
            }

            //Greater, right side
            else { 

                //If no bigger child, add it
                if(currentNode.rightChild == null) { 
                    currentNode.rightChild = new Node(key, value);
                    this.size++;
                    this.rightSize++;
                    return;
                }

                //Keep on going until we find a larger element
                else { 
                    currentNode = currentNode.rightChild;
                }
            }
        }
    }

    /** Size/height of tree */
    public int getSize() { 

        //If each side is the same height
        if(this.leftSize == this.rightSize) { 
            return this.leftSize;
        }

        //Return the taller side's size
        return this.leftSize < this.rightSize ? this.rightSize : this.leftSize;
    }

    public int getNumElements() { 
        return this.size;
    }

    public Object getLargestElement() { 
        Node toLargest = this.root;

        while(toLargest.rightChild != null) { 
            toLargest = toLargest.rightChild;
        }

        return toLargest.value;
    }

    public Object getSmallestElement() { 
        Node toSmallest = this.root;

        while(toSmallest.leftChild != null) {
            toSmallest = toSmallest.leftChild;
        }

        return toSmallest.value;
    }

    //Go to bottom of left, print value, go up a level, print right value
    //Essentially printing all values in numeric order
    public void printInOrder() { 
        printInOrder(this.root);
        System.out.println();
    }

    private static void printInOrder(final Node node) { 
        if(node == null) { 
            return;
        }

        //Check and print left child
        printInOrder(node.leftChild);
        System.out.print(node.value + "\t");
        printInOrder(node.rightChild);
    }

    //Value at the given node is printed first, then left, then right
    public void printPreOrder() { 
        printPreOrder(this.root);
        System.out.println();
    }

    private static void printPreOrder(final Node node) { 
        if(node == null) { 
            return;
        }

        System.out.print(node.value + "\t");
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
    }

    //Left, then right, then value
    public void printPostOrder() { 
        printPostOrder(this.root);
        System.out.println();
    }

    private static void printPostOrder(final Node node) { 
        if(node == null) { 
            return;
        }
        printPreOrder(node.leftChild);
        printPreOrder(node.rightChild);
        System.out.print(node.value + "\t");
    }

    //Depth first search 
    public static void depthFirstPrint() { 
        depthFirstPrint(this.root);
    }

    private static void depthFirstPrint(final Node node) { 
        if(node == null) { 
            return;
        }
    }

    //Breadth first search
    public static void breadthFirstSearch() { 
        breadthFirstPrint(this.root);
    }

    private static void breadthFirstPrint(final Node node) { 
        if(node == null) { 
            return;
        }
    }


    public static void main(String[] ryan) { 
        final CustomBinarySearchTree tree = new CustomBinarySearchTree();

        for(String r : ryan) { 
            tree.add(r, r);
        }

        for(String r : ryan) { 
            System.out.println("Tree contains: " + r + "\t" + tree.contains(r));
        }

        System.out.println("Tree contains: NOTAREALELEMENT: " + "\t" + tree.contains("NOT A REAL ELEMENT"));

        System.out.println("TREE SIZE: " + tree.getNumElements());

        System.out.println("Smallest: " + tree.getSmallestElement());
        System.out.println("Largest: " + tree.getLargestElement());
        System.out.println("In Order from bottom of tree: \n");
        tree.printInOrder();
    }
}
