public class ArrayDeque<T> {
    private T[] items = (T []) new Object[3];
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
    private int alast(){
        if(last==items.length-1){
            return 0;
        }else{
            return last+1;
        }
    }
    private int mlast(){
        if(last==0){
            return items.length-1;
        }else{
            return last -1;
        }
    }
    public void addLast(T item){
        this.resize();
        items[last] =  item;
        last = this.alast();
        size++;
    }
    public T removeLast(){
        if(size==0){
            return null;
        }
        last = this.mlast();
        T x = items[last];
        items[last] = null;
        size--;
        return x;
    }
    public void addFirst(T item){
        this.resize();
        items[first] = item;
        first = this.ffirst();
        size++;
    }
    public T removeFirst(){
        if(size==0){
            return null;
        }
        int i=this.mfirst();
        T x = items[i];
        items[i] = null;
        first = i;
        size--;
        return x;
    }

    private void resize(){
        if(size>=items.length){
            int ffirst = this.mfirst();
            int llast = this.mlast();
            T[] pp = (T []) new Object[items.length*2];
            if(ffirst>=llast){
                System.arraycopy(items,ffirst,pp,0,size-ffirst);
                System.arraycopy(items,0,pp,size-ffirst,llast+1);
            }else{
                System.arraycopy(items,0,pp,0,size);
            }
            first=pp.length-1;
            last = size;
            items=pp;
        } else if (size/ items.length<=0.25 && size>=5) {
            T[] pp = (T []) new Object[size];
            int ffirst = this.mfirst();
            int llast = this.mlast();
            if(ffirst>=llast){
                System.arraycopy(items,ffirst,pp,0,items.length-ffirst);
                System.arraycopy(items,0,pp,items.length-ffirst,llast+1);
            }else{
                System.arraycopy(items,0,pp,0,size);
            }
            first=pp.length-1;
            last = size;
            items=pp;
        }
    }
    private int ffirst(){
        if(this.first == 0){
            return this.items.length - 1;
        }else{
            return this.first -1;
        }

    }
    private int mfirst(){
        if(this.first == items.length-1){
            return 0;
        }else{
            return this.first+1;
        }
    }
    private int mfirstr(int ff){
        if(ff == items.length -1){
            return 0;
        }else{
            return ff + 1;
        }

    }
    public void printDeque(){
        int k=this.mfirst();
        int llast =this.mlast();
        if(k >=llast){
            for(int i = k;i<=this.items.length-1;i++){
                System.out.print(this.items[i]+" ");
            }
            for(int j = 0;j<=llast;j++){
                System.out.print(this.items[j]+" ");
            }
        }else{
            int l=this.mfirst();
            int m=this.mlast();
            for(int i = l;i<=m;i++){
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
            int x = this.mfirst();
            for(int k=0;k<index;k++){
                x = mfirstr(x);
            }
            return items[x];
        }
    }
}