public interface Deque<T> {
    public boolean isEmpty();
    public void addFirst(T item);
    public void addLast(T item);
    public T removeFirst();
    public T removeLast();
    public T get(int index);
    public void printDeque();
    public int size();
}
