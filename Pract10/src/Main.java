import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Stack<NewClass> new_stack = new Stack<>();
        new_stack.push(new NewClass("1"));
        new_stack.push(new NewClass("2"));
        new_stack.push(new NewClass("3"));

        Stack<NewClass> new_stack_2 = (Stack<NewClass>) new_stack.clone();
        System.out.println("Stack #1:");
        for(int i = 0; i <= new_stack.getSize()+1;i++){
            System.out.println(new_stack.pop().str);
        }
        System.out.println("Stack #2:");
        for(int i = 0; i <= new_stack_2.getSize()+1;i++){
            System.out.println(new_stack_2.pop().str);
        }

        Stack2<NewClass> stack = new Stack2<>();
        System.out.println("Введите пять строк:");
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < 5;i++){
            stack.push(new NewClass(in.next()));
        }
        for(int i = 0; i < 5;i++){
            System.out.println(stack.pop().str);
        }
    }
}