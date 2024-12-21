public class CoffeeShop {
    private static CoffeeShop coffeeShop;
    private CoffeeShop() {

    }
    public static CoffeeShop OpenCoffeeShop(){
        if(coffeeShop == null){
            coffeeShop = new CoffeeShop();
        }
        return coffeeShop;
    }
}
