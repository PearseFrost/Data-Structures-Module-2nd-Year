import javax.xml.soap.Node;

public class CircularlyLinkedList<E> {
    private Node<E> tail = null;
    private int size = 0;
    private static class Node<E> {//Netsted Node class
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {//Constructor for node class
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
    }
    public CircularlyLinkedList() {//Constructor

    }

    public int size() { //Size of list
        return size;
    }
    public boolean isEmpty() { //Checks if list empty
        return size == 0;
    }
    public E first() { // returns the first element without removing it
        if (isEmpty()) return null;
        return tail.getNext().getElement(); // the head is *after* the tail
    }
    public E last() {//returns last element without removing it
        if (isEmpty()) return null;
        return tail.getElement(); }

    public void rotate() {//Rotates first element to back of list
        if (tail != null) {
            tail = tail.getNext();
        }
    }
    public void addFirst(E e) {//Adds element to front of list
        if (size == 0) {
            tail = new Node<>(e, null); tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext()); tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e) {//Adds element to the end of the list
        addFirst(e);
        tail = tail.getNext();
    }
    public E removeFirst( ) {//Removes first element from list
        if (isEmpty( )) {
            return null;
        }
        Node<E> head = tail.getNext();

        if (head == tail) {
            tail = null;
        }
        else {
            tail.setNext(head.getNext( ));
        }
        size--;
        return head.getElement( );
    }
}

