package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.executors.EditExecutor;

/**
 * offers edit command menu
 */
public class EditClient implements Command {
    /**
     *
     * @param client - client which to edit
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object client, Console console) throws OperationException {
        new EditExecutor((Client)client,console).runCommandCycle();
    }
}
