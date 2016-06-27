package ru.andrunov.clinic.enums;

import org.junit.Test;
import ru.andrunov.clinic.exceptions.OperationException;

import static org.junit.Assert.*;

/**
 * Created by Admin on 27.06.2016.
 */
public class SexTest {

    @Test(expected = OperationException.class)
    public void testGetSexByOrdinal() throws Exception {
        Sex.getSexByOrdinal(-1);
        Sex.getSexByOrdinal(11);

    }
}