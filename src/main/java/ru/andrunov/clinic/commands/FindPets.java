package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Pet;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

import java.util.ArrayList;

/**
 *  finds pets by name or any part of it
 */
public class FindPets implements Command {
    /**
     *
     * @param clinic - clinic where pets to find
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object clinic, InputOutput console) throws OperationException {
        console.println("Insert nickname or it's part");
        String nickName = console.read();
        ArrayList<Pet> pets = ((Clinic)clinic).findPets(nickName);
        console.printf("found: %d", pets.size());
        for (Pet pet : pets){
            console.println(pet.showDetailInfo());
        }
    }
}
