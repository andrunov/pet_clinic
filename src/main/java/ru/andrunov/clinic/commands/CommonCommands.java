package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.Pet;

/**
 * some methods using
 * in several commands
 */
public class CommonCommands {
    /**
     * gets user's pet by nickname or id
     */
    public Pet getPet(Client client, Console console){
        Pet result;
        console.println("Insert pet's nickname or id");
        String value = console.read();
        try {
            result = client.getPet(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            result = client.getPet(value);
        }
        return result;
    }

    /**
     * gets client by name or id
     */
    public Client getClient(Clinic clinic, Console console){
        Client result;
        console.println("Input id or client's name");
        String value = console.read();
        try {
            result = clinic.getClient(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            result = clinic.getClient(value);
        }
        return result;
    }
}
