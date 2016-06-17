package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;

/**
 * interface for all command classes
 */
public interface Command {
    /**
     *
     * @param object - object to execute. It may be Client or Clinic objects
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object object, Console console) throws OperationException;
}
