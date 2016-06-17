package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.Pet;
import ru.andrunov.clinic.exceptions.OperationException;

/**
 * gets client's pet
 * and change it's nickname
 */
public class ChangePet implements Command {
    /**
     * links to commonCommands object
     */
    private CommonCommands commonCommands;

    /**
     * constructor
     */
    public ChangePet() {
        this.commonCommands = new CommonCommands();
    }

    /**
     *
     * @param client - client whose pet to change name
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object client, Console console) throws OperationException {
        Pet pet = this.commonCommands.getPet((Client)client,console);
        if (pet == Pet.DEFAULT){
            console.println("this client has not such pet");
        }
        else {
            console.println("Put new pet's nickname");
            pet.setNickName(console.read());
            console.println("Nickname successfully changed");
            console.println(pet.showDetailInfo());
        }
    }




}
