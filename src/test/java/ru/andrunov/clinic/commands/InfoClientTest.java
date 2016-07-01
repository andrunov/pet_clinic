package ru.andrunov.clinic.commands;

import org.junit.Test;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.autotest.ConsoleEmulator;
import ru.andrunov.clinic.autotest.InputOutput;
import ru.andrunov.clinic.exceptions.OperationException;

import static org.junit.Assert.*;

/**
 * Created by Admin on 27.06.2016.
 */
public class InfoClientTest {

    @Test(expected = OperationException.class )
    public void testExecute() throws Exception {
        String[] userInput = new String[]{"Васин"};
        InputOutput console = new ConsoleEmulator(userInput);
        Clinic clinic = new Clinic();
        InfoClient infoClient = new InfoClient(clinic);
        infoClient.execute(clinic,console);
    }
}