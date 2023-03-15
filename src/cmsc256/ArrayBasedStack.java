package cmsc256;

import java.util.Arrays;

public class ArrayBasedStack<T> implements StackInterface<T> {
    private T[] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayBasedStack(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Array initial size error.");
        clear();
    }

    private void expandArray() {
        data = Arrays.copyOf(data, INITIAL_CAPACITY + 1);
    }

    private boolean isArrayFull() {
        return topOfStack >= data.length - 1;
    }

    public ArrayBasedStack() {
        this(5);
    }

    @Override
    public void push(T newEntry) {
        if (isArrayFull()) expandArray();
        data[++topOfStack] = newEntry;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T temp = data[topOfStack];
        data[topOfStack--] = null;
        return temp;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new cmsc256.EmptyStackException();
        return data[topOfStack];
    }

    @Override
    public boolean isEmpty() {
        return topOfStack < 0;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[INITIAL_CAPACITY];
        data = tempStack;
        topOfStack = -1;
    }
}
