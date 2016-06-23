package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.autotest.InputOutput;

/**
 * show list of all clients in clinic
 */
public class ShowAllClients implements Command {
    /**
     *
     * @param clinic - clinic whose clients to show
     * @param console - console for input - output
     */
    public void execute(Object clinic, InputOutput console) {
        Clinic ourClinic = (Clinic)clinic;
        if (ourClinic.noClients()){
            console.println("No clients in base yet");
        }
        else {
            for (Client client : ourClinic.getAllClients()) {
                console.println(client);
            }
        }
    }
}
