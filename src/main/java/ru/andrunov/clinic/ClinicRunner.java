package ru.andrunov.clinic;

import ru.andrunov.clinic.executors.ClinicExecutor;

/**
 * class with main method
 */
public class ClinicRunner {
    public static void main(String[] args) {
        Console console = new Console();
        Clinic clinic = new Clinic(console);
        ClinicExecutor clinicExecutor = new ClinicExecutor(clinic,console);
        clinicExecutor.runCommandCycle();
        console.println("Good bye");
    }
}
