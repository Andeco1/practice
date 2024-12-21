public class Main {
    public static void main(String[] args) {
        Square square = new Square(new GreenColor());
        square.draw();
        square.color.changeColor();
    }
}