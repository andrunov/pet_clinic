package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Console;

/**
 * show list of all clients in clinic
 */
public class ShowAllClients implements Command {
    /**
     *
     * @param clinic - clinic whose clients to show
     * @param console - console for input - output
     */
    public void execute(Object clinic, Console console) {
        Clinic ourClinic = (Clinic)clinic;
        if (ourClinic.noClients()){
            console.println("Not clients in base yet");
        }
        else {
            for (Client client : ourClinic.getAllOwners()) {
                console.println(client);
            }
        }
    }
}
