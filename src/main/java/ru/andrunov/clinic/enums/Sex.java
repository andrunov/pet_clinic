package ru.andrunov.clinic.enums;

import ru.andrunov.clinic.exceptions.OperationException;

/**
 * enumeration of sex types
 */
public enum Sex {
    MALE, FEMALE;

    /**
     * create String with accounts of all enum toString values
     * @return
     */
    public static String showAllValues(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Sex sex : Sex.values()){
            stringBuilder.append(sex.ordinal()+1);
            stringBuilder.append(" - ");
            stringBuilder.append(sex);
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    /**
     * returns value by delivered number
     * ordinal = number - 1
     * if there is not such sex throws OperationException
     * @param number - number for enum to find. Begin from 1
     * @return
     */
    public static Sex getSexByOrdinal(int number) throws OperationException {
        if (number <= 0){
            throw new OperationException("Incorrect operation number");
        }
        Sex result = null;
        for (Sex sex : Sex.values()){
            if (sex.ordinal() == (number-1)){
                result = sex;
                break;
            }
        }
        if (result == null) {
            throw new OperationException("Incorrect sex number");
        }
        return result;
    }
}
