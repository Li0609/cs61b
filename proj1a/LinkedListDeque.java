public class LinkedListDeque<T> {
   private class IntNode{
        private IntNode prev;
        private T item;
        private IntNode next;
        public IntNode(T iitem,IntNode ppre,IntNode nnext){
            item = iitem;
            prev = ppre;
            next = nnext;
        }
        public IntNode(IntNode ppre,IntNode nnext){
            prev = ppre;
            next = nnext;
        }
   }
   private IntNode sentinel;
   private int size;
   public LinkedListDeque(){
    sentinel = new IntNode(null,null);
    sentinel.prev = sentinel;
    sentinel.next = sentinel;
    size = 0;
   }
   public boolean isEmpty(){
    return size == 0;
   }
   public void addFirst(T item){
    IntNode newl = new IntNode(item,sentinel,sentinel.next);
    sentinel.next.prev = newl;
    sentinel.next = newl;
    size++;
    }
    public void addLast(T item){
        IntNode newl = new IntNode(item,sentinel.prev,sentinel);
        sentinel.prev.next = newl;
        sentinel.prev = newl;
        size++;
    }
    public T removeFirst(){
       if(size == 0){
           return null;
       }
        IntNode p =sentinel.next.next;
        IntNode x = sentinel.next;
        T y = x.item;
        p.prev = sentinel;
        sentinel.next = p;
        size--;
        return y;
    }
    public T removeLast(){
        if(size == 0){
            return null;
        }
        IntNode p = sentinel.prev.prev;
        IntNode x = sentinel.prev;
        T y = x.item;
        p.next = sentinel;
        sentinel.prev = p;
        size--;
        return y;
    } 
    public void printDeque(){
        IntNode p =sentinel.next;
        while(p.next != sentinel){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println(p.item);
    }
    public T get(int index){
        if(index>=size){
            return null;
        }else{
            IntNode p = sentinel;
            for(int i = 0;i<=index;i++){
                p = p.next;
            }
            return p.item;
        }
    }
    private T getRecursiveHelp(IntNode p,int index){
       if(index ==0){
           return p.item;
       }else{
           return getRecursiveHelp(p.next, index-1);
       }
    }
    public T getRecursive(int index){
       if(index>size){
           return null;
       }else{
           return getRecursiveHelp(sentinel.next,index);
       }
    }
    public int size(){
       return size;
    }
}