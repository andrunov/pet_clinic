package ru.andrunov.clinic.enums;

import ru.andrunov.clinic.exceptions.OperationException;

/**
 * enumeration of animal types
 */
public enum  Animal {
    CAT, DOG, BIRD, HORSE, COW, HAMSTER;

    /**
     * create String with accounts of all enum toString values
     * @return
     */
    public static String showAllValues(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Animal animal : Animal.values()){
            stringBuilder.append(animal.ordinal() + 1);
            stringBuilder.append(" - ");
            stringBuilder.append(animal);
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }

    /**
     * returns value by delivered number
     * ordinal = number - 1
     * if there is not such animal throws OperationException
     * @param number
     * @return
     */
    public static Animal getAnimalByOrdinal(int number) throws OperationException {
        if (number <= 0){
            throw new OperationException("Incorrect operation number");
        }
        Animal result = null;
        for (Animal animal : Animal.values()){
            if (animal.ordinal() == (number-1)){
                result = animal;
                break;
            }
        }
        if (result == null) {
            throw new OperationException("Incorrect sex number");
        }
        return result;
    }
}
