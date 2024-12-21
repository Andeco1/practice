public class Main {
    public static void main(String[] args) {
        TV newTV = new TV("1");

        Command turnOn = new TurnOnDevice(newTV);
        Command turnOff = new TurnOffDevice(newTV);

        RemoteControl TVRemoteControl = new RemoteControl(turnOn,turnOff);
        TVRemoteControl.turnOn();
        TVRemoteControl.turnOff();
    }
}