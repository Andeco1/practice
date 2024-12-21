public class RemoteControl {
    private Command turnOnCommand;
    private Command turnOffCommand;

    public RemoteControl(Command turnOnCommand, Command turnOffCommand) {
        this.turnOnCommand = turnOnCommand;
        this.turnOffCommand = turnOffCommand;
    }

    public void turnOn(){
        turnOnCommand.execute();
    }

    public void turnOff(){
        turnOffCommand.execute();
    }
}
