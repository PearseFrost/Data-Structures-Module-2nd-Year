public class LinkedDequeue {
    //Instance variables for Dequeue
    private Node tail;
    private Node head;
    private int size;

    //Nested Node class
    public class Node {
        private Object item;
        private Node next;
    }

    //Constructor for linked dequeue
    public LinkedDequeue() {
        tail = null;
        head = null;
        size = 0;
    }
    //Method to add to the back of the list
    public void tailAdd(Object o) {
        Node n1 = new Node();
        n1.item = o;
        n1.next = null;
        if (tail == null) {
            head = n1;
            tail = n1;
        } else {
            tail.next = n1;
            tail = n1;
        }
        size++;
    }
    //Checks to see what item is at the end of the list and returns it
    public Object tailPeek() {
        return tail.item;
    }
    //Removes the object at the back of the list and returns it
    public Object tailRemove() {
        Node n1 = head;
        Node n2 = tail;
        if (isEmpty()) {
            return null;
        } else if (head == tail) {
            head = null;
            tail = null;
            size--;
            return n2.item;
        } else {
            while (n1.next != n2) {
                n1 = n1.next;
                tail = n1;
                tail.next = null;
                size--;
                return n2.item;
            }
        }
    }

    //Method adds an object to the front of the list
    public void headAdd(Object o) {
        Node n1 = new Node();
        n1.item = o;
        n1.next = head;

        if (head == null) {
            head = n1;
            tail = n1;
        } else {
            head = n1;
        }
        size++;
    }

    //Returns object at front of queue
    public Object headPeek() {
        return head.item;
    }
    //Removes object at front of the list
    public Object headRemove() {
        if (isEmpty()) return null;
        else {
            Object n1Item = head.item;
            head = head.next;
            if (head == null) {
                tail = null;
                size--;
            }
            return n1Item;
        }
    }
    //Checks to see if list is empty
    public boolean isEmpty() {
        return (size == 0);
    }
    //Returns size of list
    public int size() {
        return size;
    }
    //ToString
    public String toString() {
        StringBuilder dequeueOut = new StringBuilder();
        String newline = System.getProperty("line.separator");
        Node currentNode = head;
        do {
            dequeueOut.append(currentNode.item + newline);
            currentNode = currentNode.next;
        } while (currentNode.next != null);
        return dequeueOut.toString();
    }
}