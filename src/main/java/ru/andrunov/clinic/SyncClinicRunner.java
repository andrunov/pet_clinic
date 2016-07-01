package ru.andrunov.clinic;

import ru.andrunov.clinic.executors.ClinicExecutor;

/**
 * class with main method
 * no difference with ClinicRunner class
 * only tests is different
 */
public class SyncClinicRunner {
    public static void main(String[] args) {
        ClinicExecutor clinicExecutor = new ClinicExecutor(new Clinic(),new Console());
        clinicExecutor.run();
    }
}
