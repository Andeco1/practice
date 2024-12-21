import java.util.ArrayList;

public class Stack2<T> extends ArrayList<T> implements Cloneable {
    public Stack2() {
        super();
    }
    public boolean isEmpty() {
        return super.isEmpty();
    }
    public int getSize(){
        return this.size();
    }
    public T peek(){
        return this.getLast();
    }
    public T pop(){
        return this.removeLast();
    }
    public void push(T obj){
        this.addLast(obj);
    }

    @Override
    public Stack2<T> clone() {
        Stack2<T> stack_clone;
        stack_clone = new Stack2<T>();
        for(int i =0; i<this.getSize();i++){
            stack_clone.push(this.get(i));
        }
        return stack_clone;
    }
}
