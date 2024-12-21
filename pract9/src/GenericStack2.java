import java.util.ArrayList;

public class GenericStack2<E> extends ArrayList<E> {

    public E peek() {
        return get(size() - 1);
    }

    public void push(E e) {
        add(e);
    }

    public E pop() {
        return remove(size() - 1);
    }
    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        GenericStack2<String> stack = new GenericStack2<>();
        java.util.Scanner scanner = new java.util.Scanner(System.in);


        System.out.println("Введите пять строк:");
        for (int i = 0; i < 5; i++) {
            String input = scanner.nextLine();
            stack.push(input);
        }

        System.out.println("Строки в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

