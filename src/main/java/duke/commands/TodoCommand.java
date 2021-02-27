package duke.commands;

import static duke.common.Constants.TODO_TASK_TYPE;

import duke.TaskList;
import duke.tasks.Task;

public class TodoCommand extends Command {
    private String taskDescription;
    private String taskStatus;

    public TodoCommand(TaskList tasks, String taskDescription, String taskStatus) {
        super.tasks = tasks;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    @Override
    public void execute() {
        Task task = new Task(taskDescription);
        task.setStatus(taskStatus);
        task.setType(TODO_TASK_TYPE);
        tasks.addTaskToList(task);
        ui.echo(tasks);
    }
}