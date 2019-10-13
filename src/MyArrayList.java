public class MyArrayList{
    private int []a;
    private int size;

    public MyArrayList() {
        a=new int[2];
        size=0;
    }
    //AddLength是用来扩容的，如果不想扩容，直接在定义数组时，定义一个容量够用的数组
    public void AddLength(){
        if(size<a.length){
            return ;
        }
        int newsize=a.length*2;
        int []newa=new int [newsize];
        for(int i=0;i<size;i++){
            newa[i]=a[i];
        }
        a=newa;
    }
    //插入的话，分为头插(pushFront)，尾插(pushBack)，任意位置插入(insert)
    //
    //如果你是扩容的话,在插入操作中，必须判断容量是否够用；
    public void pushFront(int element){
        AddLength();
        for(int i=size;i>0;i--){
            a[i]=a[i-1];
        }
        a[0]=element;
        size++;
    }

    //尾插
    public void pushBack(int element){
        AddLength();
        a[size++]=element;
    }
    //任意位置插入
    public void insert(int index,int element){
        AddLength();
        for(int i=size;i>index;i--){
            a[i]=a[i-1];
        }
        a[index]=element;
        size++;
    }
    //打印方法
    public void Myprint(){
        for(int i=0;i<size;i++){
            System.out.print(a[i]+" ");
        }
    }
    //删除
    //头删
    public void popFront(){
        for(int i=0;i<size-1;i++){
            a[i]=a[i+1];
        }
        size--;
    }
    //尾删
    public void popBack(){
        size--;
    }
    //任意位置删除
    public void pop(int index){
        if(index<0||index>size-1){
            return;
        }
        for(int i=index;i<size-1;i++){
            a[i]=a[i+1];
        }
        size--;
    }
    //改
    public void correct(int index,int element){
        a[index]=element;
    }
    //查找
    public int  Search(int index){
        return a[index];
    }
    public static void main(String[] args) {
        MyArrayList p=new MyArrayList();
        p.pushBack(1);
        p.pushBack(2);
        p.pushBack(3);
        p.pushBack(4);
        p.pushBack(5);
        p.pushBack(6);
        p.pushFront(0);
        p.insert(2,11);
        p.popFront();
        p.popBack();
        p.pop(5);
        p.correct(1,4);
        p.Myprint();

        System.out.println();
        System.out.println(p.size);
        System.out.println("下标为1的值为"+p.Search(1));
    }
}
