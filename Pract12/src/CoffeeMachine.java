public class CoffeeMachine {
    private Coffee coffee;
    public void Load(Coffee coffee){
        this.coffee = coffee;
    }
    public CoffeeMachine addMilk(Integer ml){
        coffee.setMilk(ml);
        return this;
    }
    public CoffeeMachine addCoffee(Integer ml){
        coffee.setCoffee(ml);
        return this;
    }
    public CoffeeMachine addSyrop(Integer ml){
        coffee.setSyrop(ml);
        return this;
    }
    public Coffee server(){
        return coffee;
    }

}
