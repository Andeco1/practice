public class Raf extends Coffee{
    public Raf() {
    }
    public static Coffee makeCoffee(){
        CoffeeMachine start = new CoffeeMachine();
        start.Load(new Latte());
        start.addMilk(0);
        start.addCoffee(50);
        start.addSyrop(0);
        return start.server();
    }
}
