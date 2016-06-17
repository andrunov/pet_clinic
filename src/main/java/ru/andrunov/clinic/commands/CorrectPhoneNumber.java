package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;

/**
 * set new client's phone number
 */
public class CorrectPhoneNumber implements Command {
    /**
     *
     * @param client - client whose phone number to change
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object client, Console console) throws OperationException {
        console.println("Insert new client's phone");
        String newPhoneNumber = console.read();
        ((Client)client).setPhoneNumber(newPhoneNumber);
        console.println("phone number successfully changed");
        console.println((Client)client);
    }
}
