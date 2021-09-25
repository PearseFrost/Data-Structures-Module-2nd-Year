import java.util.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private final static int CAPACITY=1000;//Sets capacity of queue
    private int sz;//size of stack ie number of elements in queue
    private int front=0;//Index of the front element of queue
    private E[] data;//Array used for storing elements

    public ArrayQueue(){//Default constructor
        this(CAPACITY);
    }
    public ArrayQueue(int capacity) {//Constructor with given capacity
        data = (E[]) new Object[capacity];
    }

    public int size(){//Returns number of elements in queue ie size of queue
        return sz;
    }
    public boolean isEmpty(){//Returns true if queue is empty and false otherwise
        return(sz==0);
    }
    public void enqueue(E element)throws IllegalStateException{//Inserts a given element
        //Into the back of the queue
        if(sz == data.length)throw new IllegalStateException("Queue full");
        int x=(front+sz)% data.length;
        data[x]=element;
        sz++;
    }
    public E first(){//Returns the first element in the queue
        if(isEmpty()){
            return null;
        }else{
            return data[front];
        }
    }

    public E dequeue(){//Removes and returns the element at the top of the queue
        if(isEmpty()){
            return null;
        }else {
            E ans=data[front];
            data[front]=null;
            front=(front+1)% data.length;
            sz--;
            return ans;
        }
    }
}
