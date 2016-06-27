package ru.andrunov.clinic.enums;

import org.junit.Test;
import ru.andrunov.clinic.exceptions.OperationException;

import static org.junit.Assert.*;

/**
 * Created by Admin on 27.06.2016.
 */
public class EditCommandsTest {

    @Test(expected = OperationException.class)
    public void testGetCommandByOrdinal() throws Exception {
        EditCommands.getCommandByOrdinal(-1);
        EditCommands.getCommandByOrdinal(11);

    }
}