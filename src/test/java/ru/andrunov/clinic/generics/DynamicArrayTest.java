package ru.andrunov.clinic.generics;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Admin on 26.06.2016.
 */
public class DynamicArrayTest {
    private DynamicArray<String> dynamicArray = new DynamicArray<String>();
    {
        dynamicArray.add("À");
        dynamicArray.add("Á");
        dynamicArray.add("Â");
        dynamicArray.add("Ã");
        dynamicArray.add("Ä");
    }


    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(5,dynamicArray.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        Assert.assertEquals(false,dynamicArray.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertEquals(true,dynamicArray.contains("Á"));
    }

    @Test
    public void testIndexOf() throws Exception {
        Assert.assertEquals(1,dynamicArray.indexOf("Á"));
    }

    @Test
    public void testGet() throws Exception {
        Assert.assertEquals("Ã",dynamicArray.get(3));
    }

    @Test
    public void testSet() throws Exception {
        dynamicArray.set(2,"U");
        Assert.assertEquals("U",dynamicArray.get(2));
    }

    @Test
    public void testAdd() throws Exception {
        dynamicArray.add("t");
        Assert.assertEquals("t",dynamicArray.get(dynamicArray.size()-1));
    }

    @Test
    public void testRemove() throws Exception {
        Assert.assertEquals("Â",dynamicArray.get(2));
        dynamicArray.remove(2);
        Assert.assertEquals("Ã",dynamicArray.get(2));
    }

    @Test
    public void testRemove1() throws Exception {
        Assert.assertEquals("Â",dynamicArray.get(2));
        dynamicArray.remove("Â");
        Assert.assertEquals("Ã",dynamicArray.get(2));
    }

    @Test
    public void testClear() throws Exception {
        dynamicArray.clear();
        Assert.assertEquals(true,dynamicArray.isEmpty());
    }

    @Test
    public void testIterator() throws Exception {
        String string = new String("ÀÁÂÃÄ");
        StringBuilder result = new StringBuilder();
        for (String s : dynamicArray){
            result.append(s);
        }
        Assert.assertEquals(string,result.toString());
    }
}