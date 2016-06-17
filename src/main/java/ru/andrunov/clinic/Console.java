package ru.andrunov.clinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * class for input - output
 */
public class Console {
    /**
     * use for input
     */
    private BufferedReader reader;

    /**
     * constructor
     */
    public Console() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * put out String in console
     * @param object - object to put toString in console
     */
    public void print(Object object){
        System.out.print(object.toString());
    }

    /**
     * put out String in console with line separator
     * @param object - object to put toString in console
     */
    public void println(Object object){
        System.out.println(object.toString());
    }

    /**
     * read String from console
     * @return String object read from console
     */
    public String read(){
        String result = null;
        try {
            result = reader.readLine();
        }
        catch (IOException e){}
        return result;
    }

    /**
     * read int from console
     * @return int read from console
     */
    public int readInt(){
        int result = 0;
        try {
            result = Integer.parseInt(read());
        }
        catch (Exception e){
            println("input value is not a number");
        }

        return result;
    }

}