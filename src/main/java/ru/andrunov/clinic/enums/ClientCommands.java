package ru.andrunov.clinic.enums;

import ru.andrunov.clinic.exceptions.OperationException;

/**
 * enumeration for commands responsible
 * for communication with owner class
 * value DEFAULT uses instead of null
 */
public enum ClientCommands {
    ADD_PET, CHANGE_PET_NAME, REMOVE_PET, EDIT, REMOVE, EXIT;

    /**
     * put out list of available commands
     */
    public static String showOperations(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|--Choose operation number:------|");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  1: add pet                    |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  2: change pet's name          |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  3: remove pet                 |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  4: edit owner's parameters    |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  5: remove owner               |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  6: back to clinic menu        |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|--------------------------------|");
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    /**
     * returns value by delivered number
     * ordinal = number - 1
     * if there is not such ordinal throws OperationException
     * @param number
     * @return
     */
    public static ClientCommands getCommandByOrdinal(int number) throws OperationException {
        if (number <= 0){
            throw new OperationException("Incorrect operation number");
        }
        ClientCommands result = null;
        for (ClientCommands operation : ClientCommands.values()){
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
