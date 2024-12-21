public class Ann implements Barista{
    @Override
    public Coffee makeNewCoffee(String type) {
        CoffeeMaker newCoffee = new CoffeeMaker();
        Coffee order = newCoffee.makeNewCoffee(type);
        order.setBarista("Ann");
        return order;
    }
}
