package ru.andrunov.clinic;

import org.junit.Test;
import ru.andrunov.clinic.exceptions.OperationException;

import static org.junit.Assert.*;

/**
 * Created by Admin on 26.06.2016.
 */
public class ClinicTest {

    @Test(expected = OperationException.class)
    public void testAddNewClient() throws Exception {
        Clinic clinic = new Clinic(new Console());
        clinic.addNewClient(new Client("Иванов И.И.","ул.Чехова 7","8-865-88-56"));
        clinic.addNewClient(new Client("Иванов И.И.","ул.Чехова 7","8-865-88-56"));

    }
}