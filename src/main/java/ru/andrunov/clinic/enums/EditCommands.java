package ru.andrunov.clinic.enums;

import ru.andrunov.clinic.exceptions.OperationException;

/**
 * enumeration for Client-class-commands
 * value DEFAULT uses instead of null
 */
public enum EditCommands {
    NAME, PHONE, ADDRESS, EXIT;

    /**
     * put out list of available commands
     */
    public static String showOperations(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("|--Choose operation number:------|");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  1: edit name                  |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  2: edit phone                 |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  3: edit address               |");
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("|  4: back to client menu        |");
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
    public static EditCommands getCommandByOrdinal(int number) throws OperationException {
        if (number <= 0){
            throw new OperationException("Incorrect operation number");
        }
        EditCommands result = null;
        for (EditCommands operation : EditCommands.values()){
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
