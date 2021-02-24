package stack;

public class StackOfIntegers {
    private int[] elements;
    private int size;

    public StackOfIntegers() {
        this.elements = new int[16];
        this.size = 0;
    }

    public StackOfIntegers(int capacity) {
        this.elements = new int[capacity];
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.size == 0)
            return true;
        return false;
    }

    public boolean isFull()
    {
        if (this.size == this.elements.length)
            return true;
        return false;
    }

    public int peak()
    {
        return this.elements[size-1];
    }

    public void push(int value)
    {
        this.elements[size] = value;
        this.size++;
    }

    public int pop()
    {
        this.size--;
        return this.elements[size];
    }

    public int getSize() {
        return size;
    }
}
