/** 
 * Written by Ryan D'souza
 * Cracking the Coding Interview 3.7
 * Animal shelter holds only dogs and cats on a FIFO basis
 * People can either adopt animal that was there the longest or choose whether to adopt either a cat or a dog that was there the longest
 * Can use several data structures */

public class ThreeSeven { 
    private final CustomQueue dogQ, catQ;
    private int totalDog, totalCat;

    public ThreeSeven() { 
        this.dogQ = new CustomQueue();
        this.catQ = new CustomQueue();
        this.totalDog = 0;
        this.totalCat = 0;
    }

    public void enqueue(final Animal animal) { 
        if(animal instanceof Dog) { 
            this.dogQ.add((Dog) animal);
            this.totalDog++;
        }
        else if(animal instanceof Cat) {
            this.catQ.add((Cat) animal);
            this.totalCat++;
        }
    }

    public void enqueue() { 
        final double prob = Math.random();

        //Add a new dog
        if(prob <= 0.5) { 
            enqueue(new Dog(String.valueOf(totalDog + 1)));
        }
        else { 
            enqueue(new Cat(String.valueOf(totalCat + 1)));
        }
    }

    public Animal dequeueAny() { 
        //If the dog was in there longer than the cat (indicated by a smaller timestamp, return the dog
        if(((Dog) dogQ.peek()).time <= ((Cat) catQ.peek()).time) { 
            return dequeueDog();
        }
        else { 
            return dequeueCat();
        }
    }

    public Dog dequeueDog() { 
        this.totalDog--;
        return (Dog) dogQ.dequeue();
    }

    public Cat dequeueCat() { 
        this.totalCat--;
        return (Cat) dogQ.dequeue();
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
        public Cat(final String name) { 
            super(name);
        }
    }
}
