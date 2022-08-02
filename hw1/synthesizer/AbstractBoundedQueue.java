package synthesizer;
//作为一个abstract类，可以不用完全写继承的interface中的东西，而自动继承
//下面的class已经继承了BoundedQueue中isempty、isFull等method
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
    protected int fillCount;
    protected int capacity;
    @Override
    public int  capacity(){
        return capacity;
    }
    @Override
    public int fillCount(){
        return fillCount;
    }
}
