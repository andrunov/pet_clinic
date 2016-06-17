package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;

/**
 * creates new client
 */
public class AddClient implements Command {
    /**
     *
     * @param clinic clinic where client to add
     * @param console - console for input - output
     */
    public void execute(Object clinic, Console console) {
        console.println("Insert client's name");
        String name = console.read();
        console.println("Insert address");
        String address = console.read();
        console.println("Insert phone number");
        String phoneNumber = console.read();
        Client client = new Client(name,address,phoneNumber);
        try {
            ((Clinic)clinic).addNewOwner(client);
            console.println(client);
        }catch (OperationException e){
            console.println(e.getMessage());
        }

    }
}