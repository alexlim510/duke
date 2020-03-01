package commands;

import exception.DukeException;
import storage.Storage;
import task.Event;
import task.TaskList;
import ui.Ui;

public class AddEventCommand extends AddCommand {

    private String taskDescription;
    private String dateAndTime;

    public static final String COMMAND_WORD = "event";

    public AddEventCommand(String taskDescription, String dateAndTime) {
        this.taskDescription = taskDescription;
        this.dateAndTime = dateAndTime;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Event eventTask = new Event(this.taskDescription, this.dateAndTime);
        tasks.addTask(eventTask);
        storage.saveTasks(tasks);
        ui.printNewTask(tasks);
    }
}