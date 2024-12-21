import java.util.LinkedList;
import java.util.Queue;

public class StackOnQueue<Integer> {
    private Queue<Integer> firstQueue;
    private Queue<Integer> secondQueue;

    public StackOnQueue() {
        this.firstQueue = new LinkedList<>();
        this.secondQueue = new LinkedList<>();
    }
    public void push(Integer obj){
        secondQueue.offer(obj);
        while (!firstQueue.isEmpty()) {
            secondQueue.add(firstQueue.poll());
        }
        Queue<Integer> temp = firstQueue;
        firstQueue = secondQueue;
        secondQueue = temp;
    }
    public int pop(){
        return (int) firstQueue.poll();
    }
    public int top(){
        return (int) firstQueue.peek();
    }
    public boolean empty(){
        return firstQueue.isEmpty();
    }
}
