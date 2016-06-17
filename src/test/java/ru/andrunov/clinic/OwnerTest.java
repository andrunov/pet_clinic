package ru.andrunov.clinic;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Admin on 09.06.2016.
 */
public class OwnerTest {

    @Test
    public void testGetId() throws Exception {
        Assert.assertEquals(1, new Client("name", "address", "phone").getId());

    }

    @Test
    public void testGetAddress() throws Exception {
        Assert.assertEquals("address", new Client("name", "address", "phone").getAddress());

    }
}