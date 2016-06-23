package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Pet;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

/**
 * remove pet from client's pet list
 */
public class RemovePet implements Command {
    /**
     * refers to commonCommands object
     */
    private CommonCommands commonCommands;

    /**
     * constructor
     */
    public RemovePet() {
        this.commonCommands = new CommonCommands();
    }

    /**
     *
     * @param client - client whose pet to delete
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object client, InputOutput console) throws OperationException {
        console.println("Insert pet's nickname or id");
        String value = console.read();
        Pet pet = this.commonCommands.getPet((Client)client,value);
        if (pet == Pet.DEFAULT){
            console.println("this client has not such pet");
        }
        else {
            ((Client)client).removePet(pet);
            console.println("pet successfully removed");
        }

    }
}
