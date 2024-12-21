public abstract class Coffee implements Cloneable {
    private String barista;
    private Integer milk;
    private Integer coffee;
    private Integer syrop;
    public void setBarista(String barista) {
        this.barista = barista;
    }

    public String getBarista() {
        return barista;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "barista='" + barista + '\'' + ", type="+this.getClass()+
                ", milk=" + milk +
                ", coffee=" + coffee +
                ", syrop=" + syrop +
                '}';
    }

    public Integer getMilk() {
        return milk;
    }

    public void setMilk(Integer milk) {
        this.milk = milk;
    }

    public Integer getCoffee() {
        return coffee;
    }

    public void setCoffee(Integer coffee) {
        this.coffee = coffee;
    }

    public Integer getSyrop() {
        return syrop;
    }

    public void setSyrop(Integer syrop) {
        this.syrop = syrop;
    }

    @Override
    public Coffee clone() {
        try {
            Coffee clone = (Coffee) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
