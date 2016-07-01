package ru.andrunov.clinic;

import org.junit.Assert;
import org.junit.Test;
import ru.andrunov.clinic.autotest.ConsoleEmulator;
import ru.andrunov.clinic.enums.ClinicCommands;
import ru.andrunov.clinic.executors.ClinicExecutor;


/**
 * Created by Admin on 01.07.2016.
 */
public class SyncClinicRunnerTest {

    @Test
    public void testMain() throws Exception {

        /**
         * this is common object for all threads
         */
        Clinic ourClinic = new Clinic();

        /**
         * add client N1
         */
        String[] userInput1 = new String[]{
                "5","Иванов Иван Иваныч","ул.Центральная, д.8 кв.15","8-958-25-45",
                "6"};
        ConsoleEmulator consoleEmulator1 = new ConsoleEmulator(userInput1);
        ClinicExecutor user1 = new ClinicExecutor(ourClinic,consoleEmulator1);

        /**
         * add client N2,3
         */
        String[] userInput2 = new String[]{
                "5","Сидоров А. В.","ул.Западная, д.5 кв.14","8-222-33-45",
                "5","Новикова Г. И.","ул.Заречная, д.8 кв.18","8-111-23-46",
                "6"};
        ConsoleEmulator consoleEmulator2 = new ConsoleEmulator(userInput2);
        ClinicExecutor user2 = new ClinicExecutor(ourClinic,consoleEmulator2);

        /**
         * correct client N3
         */
        String[] userInput3 = new String[]{
                "4","3","4","1","Фёдоров Б. Г.","2","8-555-55-55","3","ул.Северная, д.1 кв.11","4","6","6"};

//        String[] userInput3 = new String[]{
//                "1",
//                "6"};
        ConsoleEmulator consoleEmulator3 = new ConsoleEmulator(userInput3);
        ClinicExecutor user3 = new ClinicExecutor(ourClinic,consoleEmulator3);

        /**
         * get corrected client N3
         */
        String[] userInput4 = new String[]{
                "2","Фё","6"};
        ConsoleEmulator consoleEmulator4 = new ConsoleEmulator(userInput4);
        ClinicExecutor user4 = new ClinicExecutor(ourClinic,consoleEmulator4);

        user1.run();
        user2.run();
        Thread.sleep(10);
        user3.run();
        Thread.sleep(10);
        user4.run();
        Assert.assertEquals(getExpectedResult(),consoleEmulator4.getResult());
//        show result for example
        System.out.println(consoleEmulator4.getResult());

    }

    private String getExpectedResult(){
        StringBuilder result = new StringBuilder();
        result.append(ClinicCommands.showOperations());
        result.append("2");
        result.append(System.lineSeparator());
        result.append("Insert name or name's part");
        result.append(System.lineSeparator());
        result.append("Фё");
        result.append(System.lineSeparator());
        result.append("found: 1");
        result.append(System.lineSeparator());
        result.append("id: 3 Фёдоров Б. Г.; address: ул.Северная, д.1 кв.11; phone: 8-555-55-55");
        result.append(System.lineSeparator());
        result.append(ClinicCommands.showOperations());
        result.append("6");
        result.append(System.lineSeparator());
        result.append("Good bye");
        return result.toString();
    }
}