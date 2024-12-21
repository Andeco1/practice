public class Ivan implements Barista{
    @Override
    public Coffee makeNewCoffee(String type) {
        CoffeeMaker newCoffee = new CoffeeMaker();
        Coffee order = newCoffee.makeNewCoffee(type);
        order.setBarista("Ivan");
        return order;
    }
}
