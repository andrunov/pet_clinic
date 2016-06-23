package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

/**
 * do nothing
 * use instead of null
 */
public class Exit implements Command {
    public void execute(Object clinic, InputOutput console) throws OperationException {
    }
}
