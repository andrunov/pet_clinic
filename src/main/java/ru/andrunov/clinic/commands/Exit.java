package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;

/**
 * do nothing
 * use instead of null
 */
public class Exit implements Command {
    public void execute(Object clinic, Console console) throws OperationException {}
}
