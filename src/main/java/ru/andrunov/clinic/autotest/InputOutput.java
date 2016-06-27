package ru.andrunov.clinic.autotest;

/**
 * abstraction to set methods
 * of Console and ConsoleEmulator
 */
public interface InputOutput {
    String read();                                  //return some String
    int readInt();                                  //return some int
    void print(Object object);                      //put out object
    void println(Object object);                    //put out object with line separator
    void printf(String format,Object... objects);   //put out object with formatting
}
