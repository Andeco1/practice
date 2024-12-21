public class CoffeeMaker {
    public Coffee makeNewCoffee(String name){
        Coffee coffee = switch (name) {
            case "latte" -> Latte.makeCoffee();
            case "cappuccino" -> Cappuccino.makeCoffee();
            case "raf" -> Raf.makeCoffee();
            default -> Raf.makeCoffee();
        };
        return coffee;
    }
}
