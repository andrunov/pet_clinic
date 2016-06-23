package ru.andrunov.clinic.executors;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.commands.*;
import ru.andrunov.clinic.enums.EditCommands;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * class responsible for edit
 * client-class parameters
 */
public class EditExecutor {
    private Client client;
    private InputOutput console;
    private Map<EditCommands,Command> commandMap;

    public EditExecutor(Client client, InputOutput console) {
        this.client = client;
        this.console = console;
    }

    /**
     * initialize commandMap
     */
    {
        this.commandMap = new HashMap<EditCommands, Command>();
        this.commandMap.put(EditCommands.NAME, new CorrectClientName());
        this.commandMap.put(EditCommands.ADDRESS, new CorrectAddress());
        this.commandMap.put(EditCommands.PHONE, new CorrectPhoneNumber());
        this.commandMap.put(EditCommands.EXIT, new Exit());
    }

    /**
     * turns till user choose EXIT
     */
    public void runCommandCycle() {
        EditCommands editCommands = null;
        while (editCommands != EditCommands.EXIT)
        {
            console.print(EditCommands.showOperations());
            try {
                editCommands = EditCommands.getCommandByOrdinal(console.readInt());
                executeOperation(editCommands);
            } catch (OperationException e) {
                console.println(e.getMessage());
            }
        }
    }

    /**
     * execute operation by input enum
     */
    public void executeOperation(EditCommands command) throws OperationException{
        this.commandMap.get(command).execute(client,console);


    }

}
