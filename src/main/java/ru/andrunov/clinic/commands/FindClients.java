package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;

import java.util.ArrayList;

/**
 * finds clients by name or any part of it
 */
public class FindClients implements Command {
    /**
     *
     * @param clinic - clinic where clients to find
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object clinic, Console console) throws OperationException {
        console.println("Insert name or name's part");
        String name = console.read();
        ArrayList<Client> clients = ((Clinic)clinic).findOwners(name);
        console.println("found: " + clients.size());
        for (Client client : clients){
            console.println(client);
        }
    }
}
