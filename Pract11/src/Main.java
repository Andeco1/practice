public class Main {
    public static void main(String[] args) {
        StackOnQueue<Integer> stack = new StackOnQueue<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Верхний элемент: "+ stack.top());
        for(int i = 0; i<3; i++){
            System.out.println(stack.pop());
        }
    }
}