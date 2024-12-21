public class Cappuccino extends Coffee{
    public Cappuccino() {
    }
    public static Coffee makeCoffee(){
        CoffeeMachine start = new CoffeeMachine();
        start.Load(new Latte());
        start.addMilk(10);
        start.addCoffee(50);
        start.addSyrop(5);
        return start.server();
    }
}
