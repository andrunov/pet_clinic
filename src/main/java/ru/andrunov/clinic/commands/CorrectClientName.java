package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

/**
 * set new client's name
 */
public class CorrectClientName implements Command {
    /**
     *
     * @param client - client whose name to change
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object client, InputOutput console) throws OperationException {
        console.println("Insert new client's name");
        String newName = console.read();
        ((Client)client).setName(newName);
        console.println("name successfully changed");
        console.println((Client)client);
    }
}
