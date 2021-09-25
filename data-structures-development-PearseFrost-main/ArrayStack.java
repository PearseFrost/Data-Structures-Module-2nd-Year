import java.util.Stack;
import java.util.Arrays;

public class ArrayStack<E> implements Stack<E>
{
    private final static int CAPACITY = 1000;
    private E[] data;
    private int t=-1;

    public ArrayStack() {
        this(CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (E[])(new Object[capacity]);
    }

    @Override
    public void push(E element) {
        if (t==data.length) {
            expandCapacity();
        }
        data[t] = element;
        t++;
    }
private void expandCapacity() {
        data = Arrays.copyOf(data, data.length * 2);
        }

@Override
public E pop() {
    if (isEmpty()) {
        return null;
    } else {
        E retVal = data[t - 1];
        data[t] = null;
        t--;
        return retVal;
    }
}

@Override
public E peek() {
        if (isEmpty()) {
        return null;
        }
        return data[t-1];
        }

@Override
public boolean isEmpty() {
        return (t == -1);
        }

@Override
public int size() {
        return t+1;
        }
        }