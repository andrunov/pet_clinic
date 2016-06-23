package ru.andrunov.clinic;

import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

import java.util.ArrayList;

/**
 * class includes clinic-clients list
 * and methods of some actions with this list
 */
public class Clinic {
    /**
     * clinic-clients(clients) list
     */
    private ArrayList<Client> clients;
    /**
     * - console object for input - output
     */
    private InputOutput console;

    /**
     * constructor
     * @param console - console for input - output
     */
    public Clinic(InputOutput console) {
        this.clients = new ArrayList<Client>();
        this.console = console;
    }


    public ArrayList<Client> getAllClients() {
        return clients;
    }

    /**
     * put new client into list
     * throws OperationException
     * if such client already exist
     *
     * @param client - client to add
     */
    public void addNewClient(Client client) throws OperationException{
        if (clients.contains(client)) {
            StringBuilder message = new StringBuilder("client wits such parameters already exists: ");
            message.append(System.lineSeparator());
            Client existClient = clients.get(clients.indexOf(client));
            message.append(existClient);
            throw new OperationException(message.toString());
        } else {
            clients.add(client);
            this.console.println("client was successfully added");
        }
    }

    /**
     * finds clients by given name or any part of it
     *
     * @param substring - name or any part of it
     * @return list of found clients
     */
    public ArrayList<Client> findClients(String substring) {
        ArrayList<Client> result = new ArrayList();
        for (Client client : clients) {
            if (client.getName().contains(substring)) {
                result.add(client);
            }
        }
        return result;
    }

    /**
     * finds pets by given nicknames or any part of it
     *
     * @param substring - nicknames or any part of it
     * @return list of found pets
     */
    public ArrayList<Pet> findPets(String substring) {
        ArrayList<Pet> result = new ArrayList();
        for (Client client : clients) {
            for (Pet pet : client.getPets()) {
                if (pet.getNickName().contains(substring)) {
                    result.add(pet);
                }
            }
        }
        return result;
    }

    /**
     * returns client by given id
     *
     * @param id - clients id
     * @return clients fit to send id or DEFAULT if
     * there is not such client
     */
    public Client getClient(int id) {
        Client result = Client.DEFAULT;
        for (Client client : clients) {
            if (client.getId() == id) {
                result = client;
                break;
            }
        }
        return result;
    }

    /**
     * returns client by given name
     * @param name - string name of client
     * @return clients fit to send name or DEFAULT if
     * there is not such client
     */
    public Client getClient(String name) {
        Client result = Client.DEFAULT;
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                result = client;
                break;
            }
        }
        return result;
    }

    /**
     * returns true if no clients in list
     * @return true = no clients, false = there are some clients
     */
    public boolean noClients() {
        return clients.size() == 0;
    }

    /**
     * remove client from list
     * @param client - client to remove
     */
    public void removeOwner(Client client) {
        clients.remove(client);
    }
}


