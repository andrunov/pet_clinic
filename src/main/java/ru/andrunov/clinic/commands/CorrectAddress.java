package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;

/**
 * set new client's address
 */
public class CorrectAddress implements Command {
    /**
     *
     * @param client client whose address to change
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object client, Console console) throws OperationException {
        console.println("Insert new client's address");
        String newAddress = console.read();
        ((Client)client).setAddress(newAddress);
        console.println("address successfully changed");
        console.println((Client)client);
    }
}
