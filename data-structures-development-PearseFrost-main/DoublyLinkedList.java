import java.util.Iterator;
import java.util.List;

public class DoublyLinkedList<E> {
    //---------------- nested Node class ----------------
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {//Gets element at node
            return element;
        }

        public Node<E> getPrev() {//Gets previous node
            return prev;
        }

        public Node<E> getNext() {//Gets next node
            return next;
        }

        public void setPrev(Node<E> p) {//Sets previous node
            prev = p;
        }

        public void setNext(Node<E> n) {//Sets next node
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the DoublyLinkedList
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;


    public DoublyLinkedList() {// Constructs a new empty list
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }


    public int size() {//Returns number of nodes in the list
        return size;
    }


    public boolean isEmpty() {// Returns true if the linked list is empty
        return size == 0;
    }


    public E first() {// Returns the first element of the list without removing it
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }


    public E last() { // Returns the last element of the list without removing it
        if (isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(E e) {//Adds element to front of the list
        addBetween(e, header, header.getNext());
    }

    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {//Places element in between two given nodes
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    public E removeFirst() {//Removes first element and returns it
        if (isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }

    public void addLast(E e) {//Adds element to the back of the list
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeLast() {//Removes last element in the list and returns it
        if (isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }

    private E remove(Node<E> node) {//Removes given node from list and returns the element in that node
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}



