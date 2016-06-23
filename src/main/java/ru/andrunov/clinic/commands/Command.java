package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

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
    public void execute(Object object, InputOutput console) throws OperationException;
}
