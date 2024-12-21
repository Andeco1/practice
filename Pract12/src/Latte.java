public class Latte extends Coffee {
    public Latte() {
    }
    public static Coffee makeCoffee(){
        CoffeeMachine start = new CoffeeMachine();
        start.Load(new Latte());
        start.addMilk(50);
        start.addCoffee(50);
        start.addSyrop(10);
        return start.server();
    }
}
