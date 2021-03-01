package duke;

import static duke.common.Constants.BORDER;
import static duke.common.Constants.NEWLINE;

import java.util.Scanner;

public class Ui {
    /** Constants used for displaying messages */
    public static final String LOGO =
            "                                      ,::::," + "\n"
                    + "                          ,,,,:::::::':::::::" + "\n"
                    + "        ,::::.     ..:::~~           \\::::::" + "\n"
                    + "       ::::::::::~''      ':       __     ':." + "\n"
                    + "       ::::::/        __    .o.. : u ::     ':." + "\n"
                    + "         :::,       :: u :.' '. ' ':::'     '::    ,, .::,," + "\n"
                    + "          `::       ':::' /.  : .\\         .::   ::::::::::" + "\n"
                    + "          ::.               '':'            ::'  :::,'''.:::'" + "\n"
                    + "          `::                  :          ,::'  ,:::',,,':::'" + "\n"
                    + "           `::,                 .     ..:::.   ::::::::::::'" + "\n"
                    + "              ':::::,,,....     :..::::~    ``:::::::::::'" + "\n"
                    + "              :::::::::::::::::'~   .          ''::::::'" + "\n"
                    + "              ::::::::::::::::::.      .         `::::'" + "\n"
                    + "              ::::::::::::::::::::,     .          ::" + "\n"
                    + "               ::::::::::::::::::::      :         ::" + "\n"
                    + "                  ::::::::::::::::'      .       .::'" + "\n"
                    + "                  :: '::::::::::::'       .     .:':" + "\n"
                    + "                   ::    ~~::::''        . ,,,::::,,:::::" + "\n"
                    + "                   :::,,,,,,,,,,,....:::::::::::::::::::::" + "\n"
                    + "                  :::::::::::::::::   :::::::::::::::::::::" + "\n"
                    + "                 .:::::::::::::::::,,  :::::::::::::::::''" + "\n"
                    + "                .::::::::::::::::::::,   :::::::::::::'" + "\n"
                    + "                `:::::::::::::::::::::,'" + "\n";
    public static final String GREET_MESSAGE = BORDER
            + LOGO + NEWLINE
            + "Hello, I'm Panda!" + NEWLINE
            + "What would you like to do today?" + NEWLINE
            + "Tip: use \"help\" to view all valid commands" + NEWLINE
            + BORDER + NEWLINE;
    public static final String GOODBYE_MESSAGE = BORDER
            + "Alright! Goodbye :)" + NEWLINE
            + BORDER;
    public static final String HELP_PAGE = BORDER
            + "HELP PAGE" + NEWLINE
            + "Here are all the valid commands:" + NEWLINE + NEWLINE
            + "\thelp" + NEWLINE
            + "\t - displays all valid commands" + NEWLINE + NEWLINE
            +"\tbye" + NEWLINE
            + "\t- stops the task manager" + NEWLINE + NEWLINE
            + "\tlist" + NEWLINE
            + "\t- displays all tasks in the list" + NEWLINE + NEWLINE
            + "\ttodo     |    <task>" + NEWLINE
            + "\t- adds specified task to the list" + NEWLINE + NEWLINE
            + "\tdeadline |    <task>    | /by | <yyyy-mm-dd> | <HH:mm>" + NEWLINE
            + "\t- adds specified task with date and time to the list" + NEWLINE
            + "\t- example: add task with deadline \"2 Dec 2021, 6PM\":" + NEWLINE
            + "\t  deadline final essay /by 2021-12-02 18:00" + NEWLINE + NEWLINE
            + "\tevent    |    <task>    | /at | <details>" + NEWLINE
            + "\t- adds specified task with details to the list" + NEWLINE + NEWLINE
            + "\tfilter   | <yyyy-mm-dd>" + NEWLINE
            + "\t- displays any deadlines in the list that match specified date" + NEWLINE + NEWLINE
            + "\tdone     | <index>" + NEWLINE
            + "\t- marks existing task matching the specified index" + NEWLINE
            + "\t  as completed in the list" + NEWLINE  + NEWLINE
            + "\tdelete   | <index>" + NEWLINE
            + "\t- deletes existing task matching the specified index from the list" + NEWLINE + NEWLINE
            + "<> indicates an input field and | is a field separator." + NEWLINE
            + BORDER + NEWLINE;
    public static final String PRINT_FULL_LIST_STATEMENT
            = BORDER + "Here are the tasks in your list:" + NEWLINE;
    public static final String PRINT_TARGET_LIST_STATEMENT
            = BORDER + "Tasks matching this keyword:" + NEWLINE;

    /** Invalid command error messages */
    public static final String DEFAULT_INVALID_MESSAGE
            = "I'm sorry, I don't quite understand :( Could you try again?";
    public static final String MISSING_FIELDS_MESSAGE
            = "Panda thinks you missed some fields! Try again?";
    public static final String INVALID_INDEX_MESSAGE
            = "Squeal! Second field must be a number.";
    public static final String OUTSIDE_RANGE_INDEX_MESSAGE
            = "Squeal? There is no task in the list with index ";
    public static final String INVALID_TASK_MESSAGE
            = "Squeal... Are you sure that is a task?";
    public static final String FOUND_NO_RESULTS_MESSAGE
            = "Panda can't find tasks in your list with that keyword...";
    public static final String INVALID_DATE_FORMAT_MESSAGE
            = "Squeal, date format is invalid!" + NEWLINE
            + "Use \"help\" for more info.";
    public static final String FILTERED_NO_RESULTS_MESSAGE
            = "Hmm, Panda couldn't find tasks in your list with that date...";


    /** File storage error messages */
    public static final String LOADING_ERROR_MESSAGE
            = "Failed to load from disk, creating a new file!";
    public static final String SAVING_ERROR_MESSAGE
            = "Failed to save to disk.";


    /** Read in input */
    public String readCommand() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }


    /** Methods that display messages */
    public void printGreeting() {
        System.out.print(GREET_MESSAGE);
    }

    public void printGoodbye() {
        System.out.print(GOODBYE_MESSAGE);
    }

    public void printErrorMessage(String errorMessage) {
        String closeString = NEWLINE + BORDER + NEWLINE;
        if (errorMessage == null) {
            System.out.print(BORDER + DEFAULT_INVALID_MESSAGE + closeString);
            return;
        }
        System.out.print(BORDER + errorMessage + closeString);
    }

    public void printHelpPage() {
        System.out.print(HELP_PAGE);
    }


    /** Methods that print part of or full list */
    public void echo(TaskList tasks) {
        System.out.print(BORDER);
        System.out.print("New task added:" + NEWLINE);
        System.out.print("\t");
        tasks.getTaskAtIndex(tasks.getTasksCount() - 1).printTask();
        printNumberOfTasks(tasks.getTasksCount());
    }

    public void printDeadlinesWithTargetDate(TaskList tasks) {
        System.out.print("Deadlines on this day:" + NEWLINE);
        for (int i=0; i<tasks.getTasksCount(); i++) {
            tasks.getTaskAtIndex(i).printCondensedTask();
            System.out.print(NEWLINE);
        }
        System.out.print(BORDER + NEWLINE);
    }

    public void printNumberOfTasks(int tasksCount) {
        System.out.print(NEWLINE + "There ");
        System.out.print(tasksCount > 1 ? "are " : "is ");
        System.out.print(tasksCount);
        System.out.print(tasksCount > 1 ? " tasks" : " task");
        System.out.print(" in your list." + NEWLINE);
        System.out.print(BORDER + NEWLINE);
    }

    public void printList(TaskList tasks, String openingStatement) {
        System.out.print(openingStatement);
        for (int i=0; i<tasks.getTasksCount(); i++) {
            System.out.print("\t" + (i + 1) + ". ");
            tasks.getTaskAtIndex(i).printTask();
            System.out.print(NEWLINE);
        }
        System.out.print(BORDER + NEWLINE);
    }
}
