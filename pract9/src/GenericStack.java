public class GenericStack<E> {
    private E[] elements;
    private int size = 0;


    public GenericStack() {
        elements = (E[]) new Object[10];
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        return elements[size - 1];
    }

    public void push(E o) {
        if (size == elements.length) {
            E[] newElements = (E[]) new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        elements[size++] = o;
    }

    public E pop() {
        E topElement = elements[--size];
        elements[size] = null;
        return topElement;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("стек: [");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
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
