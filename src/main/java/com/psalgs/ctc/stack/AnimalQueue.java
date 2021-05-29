/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psalgs.ctc.stack;

import java.util.LinkedList;

/**
 *
 * @author djoshi
 */
abstract class Animal {
    private int order;
    private String name;

    Animal(String name) {
        this.name = name;
    }

    void setOrder(int order) {
        this.order = order;
    }

    int getOrder() {
        return order;
    }

    boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}

class Dog extends Animal {
    String name;
    
    Dog(String n) {
        super(n);
        this.name = n;
    }

    @Override
    public String toString() {
        return "Dog{" + name + '}';
    }    
}

class Cat extends Animal {
    String name;
    
    Cat(String n) {
        super(n);
        this.name = n;
    }

    @Override
    public String toString() {
        return "Cat{" + name + '}';
    }
}

public class AnimalQueue {

    private int order = 0;
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();

    void enqueue(Animal a) {
        a.setOrder(order);
        order++;

        if (a instanceof Dog) {
            dogs.addLast((Dog) a);
        } else if (a instanceof Cat) {
            cats.addLast((Cat) a);
        }
    }

    Animal dequeue() {
        if (dogs.size() == 0) {
            return dequeueCats();
        } else if (cats.size() == 0) {
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    Dog dequeueDogs() {
        return dogs.poll();
    }

    Cat dequeueCats() {
        return cats.poll();
    }

    @Override
    public String toString() {
        return "AnimalQueue{" + "order=" + order + ", dogs=" + dogs + ", cats=" + cats + '}';
    }

    public static void main(String args[]) {
        Dog d1 = new Dog("d-1");
        Dog d2 = new Dog("d-2");
        Dog d3 = new Dog("d-3");
        
        Cat c1 = new Cat("c-1");
        Cat c2 = new Cat("c-2");
        
        AnimalQueue queue = new AnimalQueue();
        queue.enqueue(d1);
        queue.enqueue(c1);
        queue.enqueue(d2);
        queue.enqueue(c2);
        queue.enqueue(d3);
        
        System.out.println(queue);
        
        queue.dequeue();
        queue.dequeue();
        
        System.out.println(queue);
        
        queue.dequeue();
        queue.dequeue();
    }
}
