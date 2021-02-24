package stack;

public class StackOfChars {

    private char[] elements;
    private int size;

    public StackOfChars() {
        this.size = 0;
        this.elements = new char[16];
    }

    public StackOfChars(int capacity) {
        this.size = 0;
        this.elements = new char[capacity];
    }
    public boolean isEmpty(){
        if (this.size==0)
            return true;
        return false;
    }
    public boolean isFull(){
        if (this.elements.length == this.size)
            return true;
        return false;
    }
    public char peak(){
        return this.elements[this.size-1];
    }
    public void push(char c){
        this.elements[size] = c;
        this.size++;
    }
    public char pop(){
        this.size--;
        return this.elements[this.size];
    }

    public int getSize() {
        return size;
    }
}
