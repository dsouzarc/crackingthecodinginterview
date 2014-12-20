/** 
 * Written by Ryan D'souza
 * Represents a binary search tree */

public class CustomBinarySearchTree { 
    private final Node head;
    private int size;

    public CustomBinarySearchTree() { 
        this.head = new Node();
        this.size = 0;
    }

    public void add(final Object value, final Object key) { 
        if(this.head.value == null) {
            this.head.value = value;
            this.head.key = key;
        }
        else { 
            boolean toContinue = true;

            Node currentNode = this.head;

            while(toContinue) { 
                final int compareStatus = currentNode.key.toString().compareTo(key.toString());

                //Element is already there
                if(compareStatus == 0) { 

                    //Replace its value
                    currentNode.value = value;
                    toContinue = false;
                }

                //It's less than
                else if(compareStatus < 0) { 
                    
                    //If there are no smaller values
                    if(currentNode.leftChild == null) { 
                        currentNode.leftChild = new Node(key, value);
                        this.size++;
                        toContinue = false;
                    }

                    //Otherwise, keep on going
                    else { 
                        currentNode = currentNode.leftChild;
                    }
                }

                //It's greater than
                else {

                    //If there are no greater values
                    if(currentNode.rightChild == null) { 
                        currentNode.rightChild = new Node(key, value);
                        this.size++;
                        toContinue = false;
                    }

                    //Keep on going
                    else { 
                        currentNode = currentNode.rightChild;
                    }
                }
            }
        }
    }

    public boolean contains(final Object key) { 
        Node currentNode = this.head;
        boolean toContinue = true;

        while(toContinue) {
            final int compareTo = currentNode.key.toString().compareTo(key.toString());

            if(compareTo == 0) { 
                return true;
            }
            else if(compareTo < 0) { 
                if(currentNode.leftChild == null) { 
                    return false;
                }
                else { 
                    currentNode = currentNode.leftChild;
                }
            }
            else { 
                if(currentNode.rightChild == null) { 
                    return false;
                }
                else { 
                    currentNode = currentNode.rightChild;
                }
            }

            if(currentNode = null || currentNode.key == null || (currentNode.leftChild == null && currentNode.rightChild == null)) { 
                toContinue = false;
                return;
            }
        }
    }

    /** A different type of node */
    public static class Node { 
        public Node leftChild, rightChild;
        public Object value, key;
        private int size;

        public Node() { 
            this.leftChild = null;
            this.rightChild = null;
            this.size = 1;
            this.value = null;
            this.key = null;
        }

        public Node(final Object key, final Object value) { 
            this();
            this.value = value;
            this.key = key;
        }

        public Node(final Object key, final Object value, final int size) { 
            this(value, key);
            this.size = size + 1;
        }

        /*public int getSize() { 
            if(leftChild == null && rightChild == null) { 
                return 0;
            }
            else if(leftChild == null) { 
                return rightChild.getSize();
            }
            else if(rightChild == null) { 
                return leftChild.getSize();
            }
            else {
                return leftChild.getSize() + rightChild.getSize();
            }
        }*/
    }
}


