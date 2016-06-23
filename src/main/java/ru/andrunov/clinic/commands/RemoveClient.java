package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

/**
 * remove client from all-clients list
 */
public class RemoveClient implements Command {
    /**
     * refers to clinic object
     */
    private Clinic clinic;

    /**
     * constructor
     * @param clinic - the clinic object
     */
    public RemoveClient(Clinic clinic) {
        this.clinic = clinic;
    }

    /**
     * @param client  - client to remove
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object client, InputOutput console) throws OperationException {
        this.clinic.removeOwner((Client)client);
        console.println("client was successfully removed from base");
    }
}
