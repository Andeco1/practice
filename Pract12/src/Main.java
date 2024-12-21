public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = CoffeeShop.OpenCoffeeShop();
        Barista barista;
        barista = new Ann();
        Coffee order = barista.makeNewCoffee("latte");
        System.out.println(order);
        Coffee newOrder = order.clone();
        newOrder.setMilk(100);
        System.out.println(newOrder.toString());
    }
}