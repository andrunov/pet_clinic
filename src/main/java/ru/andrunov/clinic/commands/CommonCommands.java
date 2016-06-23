package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Pet;
import ru.andrunov.clinic.autotest.InputOutput;

/**
 * some methods using
 * in several commands
 */
public class CommonCommands {
    /**
     * gets user's pet by nickname or id
     */
    public Pet getPet(Client client, String value){
        Pet result;
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
    public Client getClient(Clinic clinic, String value){
        Client result;
        try {
            result = clinic.getClient(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            result = clinic.getClient(value);
        }
        return result;
    }
}
