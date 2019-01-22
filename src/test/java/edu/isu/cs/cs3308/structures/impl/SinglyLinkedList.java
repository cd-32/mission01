package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
/*
 * @author Chas Davis
 *
 * CS 3308
 * Mission 01
 * 1/21/2019
 * Dr. Griffith
 *
 * Help from https://www.geeksforgeeks.org/data-structures/linked-list/
 * */
public class SinglyLinkedList<E> implements List<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size = 0;

    //Returns the first node if it exists
    @Override
    public E first() {
        if (head != null){
            return head.getData();
        }
        else{
            return null;
        }
    }

    // Returns the last node if it exists
    @Override
    public E last() {
        if (tail != null){
            return tail.getData();
        }
        else{
            return null;
        }
    }

    /*
     * Removes the first node if it exists and
     * returns the removed node.
     * */
    @Override
    public E removeFirst() {
        if (head == null){
            return null;
        }
        else{
            E answer = head.getData();
            head = head.getNext();
            size = size - 1;
            return answer;
        }
    }

    /*
     * Removes the last node if it exists and
     * returns the removed node.
     * */
    @Override
    public E removeLast() {
        Node<E> tempNode = head;
        if (head == null || tail == null){
            return null;
        }
        else if (tempNode.getNext() == null){
            removeFirst();
        }
        while (tempNode.getNext().getNext() != null){
            if (tempNode.getNext().getNext() == null){
                tail = tempNode.getNext().getNext();
                tail.setNext(null);
                size = size -1;
            }
            tempNode = tempNode.getNext();
        }
        return tempNode.getNext().getData();
    }

    // Adds a node to the beginning of the list
    @Override
    public void addFirst(E item) {
        if (item == null) {
            return;
        }
        else if (head == null){
            Node<E> newNode = new Node<>(item);
            head = newNode;
            tail = newNode;
            size = size + 1;
        }
        else {
            Node<E> newNode = new Node<>(item);
            newNode.setNext(head);
            head = newNode;
            size = size + 1;
        }
    }

    // Adds a node to the end of the list
    @Override
    public void addLast(E item) {
        if (item == null){
            return;
        }
        else{

            if (head == null){
                addFirst(item);
            }
            else {
                Node<E> newNode = new Node<>(item);
                newNode.setNext(null);
                tail.setNext(newNode);
                tail = newNode;
                size = size + 1;
            }
        }
    }

    /*
     * Returns the node at the given index
     * if it exists
     * */
    @Override
    public E get(int index) {
        Node tempNode = head;
        int temp = 0;
        while (tempNode != null){
            if (temp == index){
                return (E) tempNode.getData();
            }
            temp++;
            tempNode = tempNode.getNext();
        }
        return null;
    }


    // Returns the size of the list if a list exists
    @Override
    public int size() {
        Node<E> temp = head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    /*
     * Checks to see if the list is empty,
     * if it is it will return true
     * and false if it contains nodes.
     * */
    @Override
    public boolean isEmpty() {
        if (head == null){
            return true;
        }
        else {
            return false;
        }
    }


    /*
     * Returns the index of the given node
     * of the list if it exists.
     * */
    public int indexOf(E item) {
        int index = 0;
        Node<E> current = head;

        while (current != null){
            if (current == item){
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    /*
     * Insets the given node into the list
     * at the given index.
     * */
    @Override
    public void insert(E item, int index) {
        if (index > size || index < 0){
            return;
        }
        else if (item == null){
            return;
        }
        else{
            Node<E> tempNode = new Node<>(item);
            Node<E> current = (Node<E>) get(index);

            if (index == 0){
                addFirst(item);
            }
            else if (index == (size - 1)){
                addLast(item);
            }
            else {
                tempNode.setNext(current.getNext());
                current.setNext(tempNode);
                size = size + 1;
            }
        }
    }

    /*
     * Removes the node at the given index
     * and returns the node that was removed.
     * */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++)
                current = current.getNext();

            Node<E> toRemove = current.getNext();
            current.setNext(toRemove.getNext());
            toRemove.setNext(null);
            size = size - 1;
            return toRemove.getData();
        }
    }

    // Prints the content of the list separated by new lines
    @Override
    public void printList(){
        if (head != null){
            Node<E> temp = head;
            while (temp != null) {
                System.out.print(temp.getData() + "\r\n");
                temp = temp.getNext();
            }
        }
        else return;
    }
}
