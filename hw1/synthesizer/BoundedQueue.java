package synthesizer;
import java.util.Iterator;
public interface BoundedQueue<T> extends Iterable<T> {
    public int capacity();     // return size of the buffer
    public int fillCount();    // return number of items currently in the buffer
    public void enqueue(T x);  // add item x to the end
    public T dequeue();        // delete and return item from the front
    public T peek();           // return (but do not delete) item

    default boolean isEmpty(){
        //default 使得所有的子类无法更改函数的表达形式
        return fillCount() == 0;
    }      // is the buffer empty (fillCount equals zero)?

    default boolean isFull(){
        return fillCount() == capacity();
    }        // is the buffer full (fillCount is same as capacity)?
    Iterator<T> iterator();
    }
