/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 3.7
 * Animal shelter holds only dogs and cats on a FIFO basis
 * People can either adopt animal that was there the longest or choose whether to adopt either a cat or a dog that was there the longest
 * Can use several data structures */

public class ThreeSeven { 
    private final CustomQueue dogQ, catQ;

    public ThreeSeven() { 
        this.dogQ = new CustomQueue();
        this.catQ = new CustomQueue();
    }


    private static abstract class Animal { 
        public final String name;
        public final long time;

        public Animal(final String name) { 
            this.name = name;
            this.time = System.currentTimeMillis();
        }
    }

    private static class Dog extends Animal { 
        public Dog(final String name) { 
            super(name);
        }
    }

    private static class Cat extends Animal { 
        public Dog(final String name) { 
            super(name);
        }
    }
