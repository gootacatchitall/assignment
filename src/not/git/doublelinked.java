/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package not.git;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class doublelinked<E> {

    private E element;
    private doublelinked<E> head;
    private doublelinked<E> tail;
    private doublelinked<E> next;
    private doublelinked<E> prev;
    private int size = 0;

    public doublelinked() {
        this.element = null;
        this.next = null;
        this.prev = null;
    }

    public doublelinked(E item) {
        this.element = item;
        this.next = null;
        this.prev = null;
    }

    public doublelinked(E item, doublelinked<E> nex) {
        this.element = item;
        this.next = nex;
        this.prev = null;

    }

    public doublelinked(E item, doublelinked<E> nex, doublelinked<E> pre) {
        this.element = item;
        this.next = nex;
        this.prev = pre;

    }

    public void addfirst(E e) {
        doublelinked<E> newnode = new doublelinked(e, head, null);  ////
        if (size == 0) {
            head = tail = newnode;
        } else {
            head.prev = newnode;
            head = newnode;
        }

        size++;
        System.out.println("adding: " + e);
    }

    public void addlast(E e) {
        doublelinked<E> newnode = new doublelinked(e, null, tail); /////
        if (size == 0) {
            head = tail = newnode;
        } else {
            tail.next = newnode;
            tail = newnode;
        }
        size++;
      //  System.out.println("adding: " + e);
    }

    public void add(int ind, E e) {
        if (size == 0) {
            addfirst(e);
        } else if (ind >= size) {
            addlast(e);
        } else {
            doublelinked<E> current = head;

            for (int i = 1; i < ind; i++) {
                current = current.next;
            }
            doublelinked<E> newnode = new doublelinked(e, current.next, current);
            current.next.prev = newnode;
            current.next = newnode;
            size++;
            System.out.println("adding: " + e);
        }

    }

    public void iteratefor() {
        System.out.println("iterating forward:");
        doublelinked<E> current = head;
        for (int i = 1; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println(current.element);
    }

    public void iteratebac() {
        System.out.println("iterating backward:");
        doublelinked<E> current = tail;
        for (int i = 1; i < size; i++) {
            System.out.print(current.element + " ");
            current = current.prev;
        }
        System.out.println(current.element);
    }

    public E deletefirst() {
        doublelinked<E> current = head;
        head = current.next;
        head.prev = null;
        size--;
        return current.element;
    }

    public E deletelast() {
        doublelinked<E> current = tail;
        tail = current.prev;
        tail.next = null;
        size--;
        return current.element;
    }

    public void delete(int ind) {
        doublelinked<E> current = head;
        for (int i = 0; i < ind; i++) {
            current = current.next;
        }
        System.out.println(current.element + " has been deleted");
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;
        size--;
    }

    public void clear() {
        doublelinked<E> current = head;
        for (int i = 0; i < size; i++) {
            current.prev = null;
        }
        current = current.next;
        System.out.println("successfully clear " + size + " nodes");
        size = 0;

    }

    public String getsize() {
        return "size of list=" + size;
    }
    
    public void showcontent(File e){
       try{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(e));
        while(true)
        {
           Scanner s=new Scanner(in.readUTF());
            System.out.println(s.next());
        }
    }catch(Exception ea)
    {
        System.out.println(ea.getMessage()+"kkk");
    }
       
}
}