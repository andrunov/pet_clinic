package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

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
    public void execute(Object clinic, InputOutput console) throws OperationException {
        console.println("Insert name or name's part");
        String name = console.read();
        ArrayList<Client> clients = ((Clinic)clinic).findClients(name);
        console.printf("found: %d", clients.size());
        for (Client client : clients){
            console.println(client);
        }
    }
}
