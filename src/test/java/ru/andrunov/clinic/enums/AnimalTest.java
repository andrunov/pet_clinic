package ru.andrunov.clinic.enums;

import org.junit.Test;
import ru.andrunov.clinic.exceptions.OperationException;

import static org.junit.Assert.*;

/**
 * Created by Admin on 27.06.2016.
 */
public class AnimalTest {

    @Test(expected = OperationException.class)
    public void testGetAnimalByOrdinal() throws Exception {
        Animal.getAnimalByOrdinal(-1);
        Animal.getAnimalByOrdinal(11);
    }
}