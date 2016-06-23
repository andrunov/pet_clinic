package ru.andrunov.clinic.executors;

import ru.andrunov.clinic.*;
import ru.andrunov.clinic.commands.*;
import ru.andrunov.clinic.enums.ClientCommands;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

import java.util.HashMap;
import java.util.Map;

/**
 * class responsible for interactive
 * communication of Client-class
 */
public class ClientExecutor {

    /**
     * keeps link to client object to execute
     */
    private Client client;
    private InputOutput console;
    private Clinic clinic;
    private Map<ClientCommands,Command> commandMap;

    /**
     * constructor
     * @param client client to execute command with
     * @param console console class
     */
    public ClientExecutor(Clinic clinic, Client client, InputOutput console) {
        this.client = client;
        this.console = console;
        this.clinic = clinic;
    }

    /**
     * initialize commandMap;
     */
    {
        this.commandMap = new HashMap<ClientCommands, Command>();
        this.commandMap.put(ClientCommands.ADD_PET,new AddPet());
        this.commandMap.put(ClientCommands.CHANGE_PET_NAME,new ChangePet());
        this.commandMap.put(ClientCommands.REMOVE_PET,new RemovePet());
        this.commandMap.put(ClientCommands.EDIT,new EditClient());
        this.commandMap.put(ClientCommands.REMOVE,new RemoveClient(this.clinic));
        this.commandMap.put(ClientCommands.EXIT,new Exit());
    }

    /**
     * turns till user choose EXIT
     */
    public void runCommandCycle() {
        ClientCommands clientCommands = null;
        while ((clientCommands != ClientCommands.EXIT) && (clientCommands != ClientCommands.REMOVE))
        {
            console.print(ClientCommands.showOperations());
            try {
                clientCommands = ClientCommands.getCommandByOrdinal(console.readInt());
                executeOperation(clientCommands);
            } catch (OperationException e) {
                console.println(e.getMessage());
            }
        }
    }

    /**
     * execute operation by input enum
     */
    public void executeOperation(ClientCommands command) throws OperationException{
        this.commandMap.get(command).execute(this.client,this.console);

    }

}
