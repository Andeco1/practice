import java.util.ArrayList;

public class Stack<T> implements Cloneable{
    private ArrayList<T> list;
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int getSize(){
        return list.size();
    }
    public T peek(){
        return list.getLast();
    }
    public T pop(){
        return  list.removeLast();
    }
    public void push(T obj){
        list.addLast(obj);
    }

    public Stack() {
        list = new ArrayList<>();
    }
    public Stack(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    protected Object clone() {
        Stack<T> stack_clone;
        stack_clone = new Stack<T>();
        for(int i =0; i<this.getSize();i++){
            stack_clone.list.add(i, this.list.get(i));
        }
        return stack_clone;
    }
}

