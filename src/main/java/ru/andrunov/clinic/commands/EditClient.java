package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.executors.EditExecutor;
import ru.andrunov.clinic.autotest.InputOutput;

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
    public void execute(Object client, InputOutput console) throws OperationException {
        new EditExecutor((Client)client,console).runCommandCycle();
    }
}
