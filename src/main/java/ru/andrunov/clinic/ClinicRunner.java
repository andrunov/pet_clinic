package ru.andrunov.clinic;

import ru.andrunov.clinic.executors.ClinicExecutor;

/**
 * class with main method
 */
public class ClinicRunner {
    public static void main(String[] args) {
        ClinicExecutor clinicExecutor = new ClinicExecutor(new Clinic(),new Console());
        clinicExecutor.run();
    }
}
