package ru.andrunov.clinic.autotest;

/**
 * emulate user input and program output
 * test use only
 */
public class ConsoleEmulator implements InputOutput {

    private String answers[];       //users answers
    private StringBuilder out;      //keeps program output to console
    private int index;              //answers[index]

    /**
     * constructor
     * @param answers - user answers
     */
    public ConsoleEmulator(String[] answers) {
        this.answers = answers;
        this.out = new StringBuilder();
        this.index = 0;
    }

    /**
     * emulate user input
     * @return - result String of user one step input
     */
    public String read() {
        this.out.append(this.answers[this.index]);
        this.out.append(System.lineSeparator());
        return this.answers[this.index++];
    }

    /**
     * emulate user input
     * @return - result int of user one step input
     */
    public int readInt() {
        this.out.append(this.answers[this.index]);
        this.out.append(System.lineSeparator());
        return Integer.parseInt(this.answers[this.index++]);
    }

    /**
     * emulate program output
     * @param object - object to output
     */
    public void print(Object object) {
        this.out.append(object);
    }

    /**
     * emulate program output with line separator
     * @param object - object to output
     */
    public void println(Object object) {
        this.out.append(object);
        this.out.append(System.lineSeparator());

    }

    /**
     * emulate program output with format and line separator
     * @param format String format
     * @param objects - objects to output
     */
    public void printf(String format, Object... objects) {
        this.out.append(String.format(format,objects));
        this.out.append(System.lineSeparator());

    }

    /**
     * out toString result of emulation
     * @return - result of emulation
     */
    public String getResult(){
       return this.out.toString();
    }
}
