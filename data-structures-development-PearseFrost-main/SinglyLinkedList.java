import java.util.Iterator;
import java.util.List;

public class SinglyLinkedList<E> implements Cloneable, Iterable<E>,List<E> {
    public static class Node<E>{//Nested node class
    private E element;//Element for certain node initialized
    private Node<E> next;//Next node initialized

    private Node(E e,Node<E> n) {//Node contructor
        element = e;
        next = n;
    }
        public E getElement() {//Gets element stored in node
        return element;
        }
        public Node<E> getNext() {//Gets next node in list
        return next;
    }
    public void setNext(Node<E> n) {//Sets the next node to the inputted value
        next = n;
    }
    }


    // instance variables of the SinglyLinkedList
    private Node<E> tail = null;//tail node of the list
    private Node<E> head = null; //head node of the list

    private int size = 0; //number of nodes in the list

    public SinglyLinkedList() {//Constructor
    }
    public int size() {//Return how many nodes are in list
        return size;
    }

    public boolean isEmpty() {//Checks if list is empty
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {

    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {

    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        return null;
    }


    public E first() {//Returns first element without removing it
        if(isEmpty()){
            return null;
        }
        return head.getElement();
    }

    public E last() {//Returns first element without removing it
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {//Method to add element to the start of the list
        head = new Node<>(e, head); if (size == 0)
            tail = head; size++;
    }
    public void addLast(E e){//Mehtod to add element to the end of the list
    Node<E> newest = new Node<>(e, null); // node will eventually be the tail
if (isEmpty( )) head = newest;
else {
    tail.setNext(newest);
    tail = newest;
    size++;
}
}



    @SuppressWarnings({"unchecked"})
    public boolean equals(Object o) {
        if (o == null) return false;
    if (getClass() != o.getClass()) return false; SinglyLinkedList other = (SinglyLinkedList) o; if (size != other.size) return false;
    Node walkA = head;
    Node walkB = other.head;
    while (walkA != null) {
        if (!walkA.getElement().equals(walkB.getElement())) return false; 
        walkA = walkA.getNext();
        walkB = walkB.getNext();
}
return true;
    }

    @SuppressWarnings({"unchecked"})
    public SinglyLinkedList<E> clone() throws CloneNotSupportedException {
        // TODO
        return null;
    }


    public String toString() {
        String output = "";

        if (head != null) {
            Node n1 = head.getNext();
            while (n1 != null) {
                output += "[" + n1.getElement().toString() + "]";
                n1 = n1.getNext();
            }

        }
        return output;
    }


    private class SinglyLinkedListIterator<E> implements Iterator<E> {
        @Override
        public boolean hasNext() {
            // TODO
            return false;
        }

        @Override
        public E next() {
            // TODO
            return null;
        }
    }

    public Iterator<E> iterator() {
        return new SinglyLinkedListIterator<E>();
    }

    public static void main(String[] args) {
        //ArrayList<String> all;
        //LinkedList<String> ll;
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();

        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            sll.addFirst(s);
            sll.addLast(s);
        }
        System.out.println(sll.toString());

        for (String s : sll) {
            System.out.print(s + ", ");
        }
    }
}
