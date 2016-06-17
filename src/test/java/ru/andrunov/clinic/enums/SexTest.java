package ru.andrunov.clinic.enums;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 09.06.2016.
 */
public class SexTest {

    @Test
    public void testShowAllValues() throws Exception {
        String string = Sex.showAllValues();
        Assert.assertEquals("MALE, FEMALE, ",string);

    }
}