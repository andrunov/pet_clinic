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
        linkedArray.add("�");
        linkedArray.add("�");
        linkedArray.add("�");
        linkedArray.add("�");
        linkedArray.add("�");
    }


    @Test
    public void testClear() throws Exception {
        linkedArray.clear();
        Assert.assertEquals(true, linkedArray.size()==0);
    }

    @Test
    public void testGet() throws Exception {
        Assert.assertEquals("�",linkedArray.get(3));
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
        Assert.assertEquals("�",linkedArray.get(2));
        linkedArray.remove(2);
        Assert.assertEquals("�",linkedArray.get(2));
    }


    @Test
    public void testIterator() throws Exception {
        String string = new String("�����");
        StringBuilder result = new StringBuilder();
        for (String s : linkedArray){
            result.append(s);
        }
        Assert.assertEquals(string,result.toString());
    }

    @Test
    public void testRemove1() throws Exception {
        Assert.assertEquals("�",linkedArray.get(2));
        linkedArray.remove("�");
        Assert.assertEquals("�",linkedArray.get(2));
    }

    @Test
    public void testContains() throws Exception {
        Assert.assertEquals(true,linkedArray.contains("�"));

    }

    @Test
    public void testIndexOf() throws Exception {
        Assert.assertEquals(4,linkedArray.indexOf("�"));

    }
}