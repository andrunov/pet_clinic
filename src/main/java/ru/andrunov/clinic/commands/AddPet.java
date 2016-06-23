package ru.andrunov.clinic.commands;

import ru.andrunov.clinic.Client;
import ru.andrunov.clinic.Pet;
import ru.andrunov.clinic.enums.Animal;
import ru.andrunov.clinic.enums.Sex;
import ru.andrunov.clinic.exceptions.OperationException;
import ru.andrunov.clinic.autotest.InputOutput;

/**
 * add new pet to client
 */
public class AddPet implements Command {
    /**
     *
     * @param client - client to whom pet to add
     * @param console - console object
     * @throws OperationException
     */
    public void execute(Object client, InputOutput console) throws OperationException {
        Client clientToAddPet = (Client)client;

        Animal animal = getAnimalType(console);
        Sex sex = getAnimalSex(console);

        console.println("Put pet's nickname:");
        String nickName = console.read();

        console.println("Put pet's age");
        int age = console.readInt();

        clientToAddPet.addPet(new Pet(animal, nickName, clientToAddPet, age, sex));
    }

    /**
     * gets animal's type
     * @param console - console object
     * @return Animal object
     */
    private Animal getAnimalType(InputOutput console){
        Animal result = null;
        console.print("Chose animal's type: ");
        console.println(Animal.showAllValues());
        while (result == null){
            try {
                result = Animal.getAnimalByOrdinal(console.readInt());
            }
            catch (Exception e){
                console.println("Nonexistent animal. Please try again");
            }
        }
        return result;
    }

    /**
     * gets animal's sex
     * @param console - console object
     * @return sex object
     */
    private Sex getAnimalSex(InputOutput console){
        Sex result = null;
        console.print("Chose animal's sex: ");
        console.println(Sex.showAllValues());
        while (result == null){
            try {
                result = Sex.getSexByOrdinal(console.readInt());
            }
            catch (Exception e){
                console.println("Nonexistent sex. Please try again");
            }
        }
        return result;
    }
}
