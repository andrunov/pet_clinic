package ru.andrunov.clinic.generics;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 26.06.2016.
 */
public class LinkedArrayTest {
    private LinkedArray<String> linkedArray = new LinkedArray<String>();
    {
        linkedArray.add("À");
        linkedArray.add("Á");
        linkedArray.add("Â");
        linkedArray.add("Ã");
        linkedArray.add("Ä");
    }


    @Test
    public void testClear() throws Exception {
        linkedArray.clear();
        Assert.assertEquals(true, linkedArray.size()==0);
    }

    @Test
    public void testGet() throws Exception {
        Assert.assertEquals("Ã",linkedArray.get(3));
    }

    @Test
    public void testSet() throws Exception {
        linkedArray.set(2,"U");
        Assert.assertEquals("U",linkedArray.get(2));
    }

    @Test
    public void testAdd() throws Exception {
        linkedArray.add("t");
        Assert.assertEquals("t",linkedArray.get(linkedArray.size()-1));
    }

    @Test
    public void testAdd1() throws Exception {
        linkedArray.add(2,"k");
        Assert.assertEquals("k",linkedArray.get(2));
    }

    @Test
    public void testRemove() throws Exception {
        Assert.assertEquals("Â",linkedArray.get(2));
        linkedArray.remove(2);
        Assert.assertEquals("Ã",linkedArray.get(2));
    }


    @Test
    public void testIterator() throws Exception {
        String string = new String("ÀÁÂÃÄ");
        StringBuilder result = new StringBuilder();
        for (String s : linkedArray){
            result.append(s);
        }
        Assert.assertEquals(string,result.toString());
    }

    @Test
    public void testRemove1() throws Exception {
        Assert.assertEquals("Â",linkedArray.get(2));
        linkedArray.remove("Â");
        Assert.assertEquals("Ã",linkedArray.get(2));
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertEquals(true,linkedArray.contains("Ä"));

    }

    @Test
    public void testIndexOf() throws Exception {
        Assert.assertEquals(4,linkedArray.indexOf("Ä"));

    }
}