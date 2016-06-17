package ru.andrunov.clinic.enums;

import ru.andrunov.clinic.exceptions.OperationException;

/**
 * enumeration for commands for navigation
 * threw the owners list
 * value DEFAULT uses instead of null
 */
public enum ClinicCommands {
    SHOW_ALL, FIND, FIND_PET, INFO , ADD, EXIT;

    /**
     * put out list of available commands
     */
    public static String showOperations(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|--Choose operation number:------|");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  1: show all clients           |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  2: find client                |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  3: find pet;                  |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  4: client info and edit       |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  5: add new client             |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  6: exit                       |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|--------------------------------|");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    /**
     * returns value by delivered number
     * ordinal = number - 1
     * if there is not such ordinal throws OperationException
     * @param number - number for enum to find. Begin from 1
     * @return
     */
    public static ClinicCommands getCommandByOrdinal(int number) throws OperationException{
        if (number <= 0){
            throw new OperationException("Incorrect operation number");
        }
        ClinicCommands result = null;
        for (ClinicCommands operation : ClinicCommands.values()){
            if (operation.ordinal() == (number-1)){
                result = operation;
                break;
            }
        }
        if (result == null) {
            throw new OperationException("Incorrect operation number");
        }
        return result;
    }

}
