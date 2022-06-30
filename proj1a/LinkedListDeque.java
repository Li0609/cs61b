public class LinkedListDeque<T> {
   public class IntNode{
        public IntNode prev;
        public T item;
        public IntNode next;
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
    public void removeFirst(){
        IntNode p =sentinel.next.next;
        p.prev = sentinel;
        sentinel.next = p;
        size--;
    }
    public void removeLast(){
        IntNode p = sentinel.prev.prev;
        p.next = sentinel;
        sentinel.prev = p;
        size--;
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
    public int size(){
       return size;
    }
    public static void main(String[] args){
        LinkedListDeque s1  = new LinkedListDeque();
    }
}