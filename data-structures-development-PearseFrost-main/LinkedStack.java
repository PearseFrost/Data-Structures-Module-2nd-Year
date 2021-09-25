
public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>(); // Empty list

    public LinkedStack() {
    } //New stack relies on the initially empty list

    public int size() {//Returns size of our stack
        return list.size();
    }
    public boolean isEmpty() {//Checks if the list empty and returns true or false
        return list.isEmpty();
    }

    public void push(E element) {//Adds element to stack
        list.addFirst(element);
    }

    public E top() {//Returns the element on top of stack
        return list.first();
    }
    public E pop() {//Removes element on top of stac
        return list.removeFirst();
    }
}