public class ArrayDeque<T> {
    private T[] items = (T []) new Object[100];
    private int size;
    private int first;
    private int last;
    public ArrayDeque(){
        size = 0;
        first = 0;
        last = 1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return this.size;
    }
    public void addLast(T item){
        this.resize();
        items[last] =  item;
        last = last+1;
        size++;
    }
    public T removeLast(){
        last = last - 1;
        T x = items[last];
        items[last] = null;
        size--;
        return x;
    }
    public void addFirst(T item){
        items[first] = item;
        this.ffirst();
        size++;
    }
    public T removeFirst(){
        this.mfirst();
        T x = items[first];
        items[first] = null;
        size--;
        return x;
    }

    public void resize(){
        if(size>=items.length){
            T[] pp = (T []) new Object[items.length*2];
            if(this.first>this.last){
                System.arraycopy(items,first,pp,0,size-first);
                System.arraycopy(items,0,pp,size-first,last+1);
            }else{
                System.arraycopy(items,0,pp,0,size);
            }
            first=pp.length;
            last = size;
            items=pp;
        }
    }
    public void ffirst(){
        if(this.first == 0){
            this.first = this.items.length - 1;
        }else{
            this.first = this.first -1;
        }

    }
    public void mfirst(){
        if(this.first == items.length-1){
            this.first = 0;
        }else{
            this.first = this.first + 1;
        }
    }
    public void printDeque(){
        if(this.first > this.last){
            this.mfirst();
            for(int i = this.first;i<=this.items.length-1;i++){
                System.out.print(this.items[i]+" ");
            }
            for(int j = 0;j<=last-1;j++){
                System.out.print(this.items[j]+" ");
            }
        }else{
            this.mfirst();
            for(int i = this.first;i<=last-1;i++){
                System.out.print(this.items[i]+" ");
            }
        }
        this.ffirst();
        System.out.println(" ");
    }
    public T get(int index){
        if(index>size){
            return null;
        }else{
            T[] pp = (T []) new Object[this.items.length*2];
            if(this.first>this.last){
                this.mfirst();
                System.arraycopy(items,first,pp,0,items.length-first);
                System.arraycopy(items,0,pp,items.length-first,last+1);
            }else{
                System.arraycopy(items,0,pp,0,size);
            }
            return pp[index];
        }
    }

    public static void main(String[] args) {
        ArrayDeque s1 = new ArrayDeque();
        s1.addFirst(10);
        s1.addFirst(200);
        s1.addLast(20);
        s1.addLast(30);
        s1.printDeque();
        System.out.println(s1.first);
        System.out.println(s1.last);
        System.out.println(s1.get(0));
        s1.removeLast();
        System.out.println(s1.items[1]);
        System.out.println(s1.size());

    }


}