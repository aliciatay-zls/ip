package duke.commands;

public class InvalidCommand extends Command {
    private String errorMessage;

    public InvalidCommand(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public void execute() {
        ui.printErrorMessage(errorMessage);
    }
}
