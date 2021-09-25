public class LinkedQueue<E> implements Queue<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedQueue() { } // new queue relies on the initially empty list

    public int size() { //Returns the size of the queue
        return list.size();
    }

    public boolean isEmpty() {//Returns true is list is empty anf false otherwise
        return list.isEmpty();
    }

    public void enqueue(E element) {//Adds element to the rear of the queue
        list.addLast(element);
    }

    public E first() {//Returns element at the front of the queue
        return list.first();
    }

    public E dequeue() {//Removes the element at the front of the queue
        return list.removeFirst();
    }
 }
