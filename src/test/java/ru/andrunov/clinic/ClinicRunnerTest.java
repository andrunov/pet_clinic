package ru.andrunov.clinic;

import org.junit.Assert;
import org.junit.Test;
import ru.andrunov.clinic.commands.CommonCommands;
import ru.andrunov.clinic.enums.ClientCommands;
import ru.andrunov.clinic.enums.ClinicCommands;
import ru.andrunov.clinic.executors.ClinicExecutor;
import ru.andrunov.clinic.autotest.ConsoleEmulator;

/**
 * tests threw all classes and methods
 */
public class ClinicRunnerTest {

    /**
     * user input
     */
    private String[] userInput = new String[]{
            "1",                                                                    //step1
            "2","Иванов",                                                           //step2
            "2","5",                                                                //step3
            "3","Бобик",                                                            //step4
            "4","Иванов",                                                           //step5
            "4","5",                                                                //step6
            "5","Иванов Иван Иваныч","ул.Центральная, д.8 кв.15","8-958-25-45",     //step7
            "5","Сидоров А. В.","ул.Западная, д.5 кв.14","8-222-33-45",             //step8
            "5","Новикова Г. И.","ул.Заречная, д.8 кв.18","8-111-23-46",            //step9
            "4","2",                                                                //step10
            "6",                                                                    //step11
            "6"};                                                                   //step12

    /**
     * userInput[index]
     */
    private int index = 0;

    /**
     * expected output of program
     */
    private StringBuilder programOutput = new StringBuilder();

    /**
     * counts added clients
     */
    private int counter = 1;

    /**
     * use in methods to show
     * client and pet info
     */
    private CommonCommands commonCommands = new CommonCommands();

    @Test
    public void testMain() throws Exception {
        ConsoleEmulator console = new ConsoleEmulator(userInput);
        Clinic clinic = new Clinic();
        ClinicExecutor clinicExecutor = new ClinicExecutor(clinic,console);
        clinicExecutor.run();
        buildProgramOutput();
        Assert.assertEquals(programOutput.toString(),console.getResult());

        //just for example show dialog program with user
        System.out.println(console.getResult());
    }

    /**
     * builds expected output of program
     */
    private void buildProgramOutput(){
        //step1 : 1 ShowAllClients
        getExpectShowAllClients(false);

        //step2 : FindClients [2, Иванов] - by name
        getExpectedFindClients(false);

        //step3 : FindClients [2, 5] - by ID
        getExpectedFindClients(false);

        //step4 : FindPet [2, 5]
        getExpectedFindPets(false);

        //step5 : InfoClient [4, Иванов] - by name
        getExpectedInfoClient(false,false,0,0);

        //step6 : InfoClient [4, 5] - by ID
        getExpectedInfoClient(false,false,0,0);

        //step7 : AddClient [5,Иванов Иван Иваныч,ул.Центральная, д.8 кв.15,8-958-25-45,]
        getExpectedAddClient();

        //step8 : AddClient [5,Сидоров А. В.,ул.Западная, д.5 кв.14,8-222-33-45]
        getExpectedAddClient();

        //step9 : AddClient [5,Новикова Г. И.,ул.Заречная, д.8 кв.18,8-111-23-46]
        getExpectedAddClient();

        //step10 : InfoClient [5, 2]
        getExpectedInfoClient(true,false,16,2);

        //step11 : Exit client menu
        getExpectedClientExit();

        //step12 : 6 Exit
        getExpectedExit();

    }

    /**
     * build expected result of ShowAllClients method
     * @param isNotEmpty - there are some clients in base
     */
    private void getExpectShowAllClients(Boolean isNotEmpty){
        programOutput.append(ClinicCommands.showOperations());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        if (isNotEmpty) {

        }
        else {
            programOutput.append("No clients in base yet");
            programOutput.append(System.lineSeparator());
        }
    }

    /**
     * build expected result of FindClients
     * @param isNotEmpty - there are some clients found
     */
    private void getExpectedFindClients(Boolean isNotEmpty){
        programOutput.append(ClinicCommands.showOperations());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("Insert name or name's part");
        programOutput.append(System.lineSeparator());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        if (isNotEmpty) {
        }
        else {
            programOutput.append("found: 0");
        }
        programOutput.append(System.lineSeparator());
    }

    /**
     * build expected result of FindPets
     * @param isNotEmpty - there are some pets found
     */
    private void getExpectedFindPets(Boolean isNotEmpty){
        programOutput.append(ClinicCommands.showOperations());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("Insert nickname or it's part");
        programOutput.append(System.lineSeparator());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        if (isNotEmpty) {
        }
        else {
            programOutput.append("found: 0");
        }
        programOutput.append(System.lineSeparator());
    }

    /**
     * build expected result of InfoClient method
     * @param isClientExist - client exist
     * @param hasPets - client has pets
     * @param beginIndex - index from client info begins in userInput[]
     */
    private void getExpectedInfoClient(Boolean isClientExist,Boolean hasPets,int beginIndex, int clientIndex){
        programOutput.append(ClinicCommands.showOperations());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("Input id or client's name");
        programOutput.append(System.lineSeparator());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        if (isClientExist){
            programOutput.append(String.format("id: %d ",clientIndex));
            programOutput.append(userInput[beginIndex]);
            programOutput.append("; address: ");
            programOutput.append(userInput[beginIndex+1]);
            programOutput.append("; phone: ");
            programOutput.append(userInput[beginIndex+2]);
            programOutput.append(System.lineSeparator());
            programOutput.append("pets :");
            programOutput.append(System.lineSeparator());
            programOutput.append("   no pets");
            programOutput.append(System.lineSeparator());
        }
        else {
            programOutput.append("there is not such client in base");
            programOutput.append(System.lineSeparator());
        }

    }

    /**
     * build expected result of AddClient method
     */
    private void getExpectedAddClient(){
        programOutput.append(ClinicCommands.showOperations());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("Insert client's name");
        programOutput.append(System.lineSeparator());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("Insert address");
        programOutput.append(System.lineSeparator());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("Insert phone number");
        programOutput.append(System.lineSeparator());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("client was successfully added");
        programOutput.append(System.lineSeparator());
        programOutput.append(String.format("id: %d ",counter++)).append(userInput[index-3]).append("; address: ").append(userInput[index-2]).append("; phone: ").append(userInput[index-1]);
        programOutput.append(System.lineSeparator());
    }

    /**
     * build expected result of Exit
     */
    private void getExpectedExit(){
        programOutput.append(ClinicCommands.showOperations());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
        programOutput.append("Good bye");
        programOutput.append(System.lineSeparator());

    }

    /**
     * build expected result of client-menu (ClientExecutor) Exit
     */
    private void getExpectedClientExit(){
        programOutput.append(ClientCommands.showOperations());
        programOutput.append(userInput[index++]);
        programOutput.append(System.lineSeparator());
    }

}