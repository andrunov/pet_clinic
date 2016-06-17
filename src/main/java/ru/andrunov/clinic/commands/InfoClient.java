package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Clinic;
import ru.andrunov.clinic.Console;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.executors.ClientExecutor;

/**
 * shows detail client's info by request
 * name or id and offers client's menu
 */
public class InfoClient implements Command{
    /**
     * refers to clinic object. Use in method to
     * delete client from clinic
     */
    private Clinic clinic;

    /**
     * refers to commonCommands object
     */
    private CommonCommands commonCommands;

    /**
     * constructor
     * @param clinic - clinic where client exist
     */
    public InfoClient(Clinic clinic) {
        this.commonCommands = new CommonCommands();
        this.clinic = clinic;
    }

    /**
     *
     * @param clinic - clinic where client exist
     * @param console - console for input - output
     * @throws OperationException
     */
    public void execute(Object clinic, Console console) throws OperationException {
        Client client = this.commonCommands.getClient((Clinic)clinic,console);
        if (client == Client.DEFAULT){
            throw new OperationException("there is not such client in base");
        }
        else {
            console.println(client.showDetailInfo());
        }
        new ClientExecutor(this.clinic,client,console).runCommandCycle();
    }
}
