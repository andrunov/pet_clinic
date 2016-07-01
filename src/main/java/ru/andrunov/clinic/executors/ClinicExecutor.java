package ru.andrunov.clinic.executors;

import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.commands.*;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.enums.ClinicCommands;
import ru.andrunov.clinic.autotest.InputOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * class responsible for interactive
 * communication program with user
 */
public class ClinicExecutor extends Thread {

    private Clinic clinic;
    private InputOutput console;
    private Map<ClinicCommands,Command> commandMap;

    /**
     * constructor
     * @param clinic clinic object
     * @param console console object
     */
    public ClinicExecutor(Clinic clinic, InputOutput console) {
        this.clinic = clinic;
        this.console = console;
    }

    /**
     * initialize commandMap
     */
    {
        this.commandMap = new HashMap<ClinicCommands, Command>();
        this.commandMap.put(ClinicCommands.SHOW_ALL, new ShowAllClients());
        this.commandMap.put(ClinicCommands.FIND, new FindClients());
        this.commandMap.put(ClinicCommands.FIND_PET, new FindPets());
        this.commandMap.put(ClinicCommands.INFO, new InfoClient(this.clinic));
        this.commandMap.put(ClinicCommands.ADD, new AddClient());
        this.commandMap.put(ClinicCommands.EXIT, new Exit());
    }


    /**
     * turns till user put EXIT-command
     */
    public void run(){
        ClinicCommands clinicCommand = null;
        while (clinicCommand!= ClinicCommands.EXIT){
            console.print(ClinicCommands.showOperations());
            try {
                clinicCommand = ClinicCommands.getCommandByOrdinal(this.console.readInt());
                executeOperation(clinicCommand);
            }catch (OperationException e){
                this.console.println(e.getMessage());
            }
        }
        console.print("Good bye");

    }

    /**
     * execute operation by input enum
     */
    public void executeOperation(ClinicCommands command) throws OperationException{
        synchronized (this.clinic) {
            this.commandMap.get(command).execute(this.clinic, this.console);
        }
    }

}
