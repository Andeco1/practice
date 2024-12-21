public abstract class Device {
    public String name;

    public Device(String name) {
        this.name = name;
    }

    public void turnOn(){
        System.out.println("Включён "+getClass()+" "+name);
    }
    public void turnOff(){
        System.out.println("Выключён "+getClass()+" "+name);
    }
}
