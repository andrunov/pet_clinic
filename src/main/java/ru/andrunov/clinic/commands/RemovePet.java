package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.Pet;
import ru.andrunov.clinic.exceptions.OperationException;

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
    public void execute(Object client, Console console) throws OperationException {
        Pet pet = this.commonCommands.getPet((Client)client,console);
        if (pet == Pet.DEFAULT){
            console.println("this client has not such pet");
        }
        else {
            ((Client)client).removePet(pet);
            console.println("pet successfully removed");
        }

    }
}
