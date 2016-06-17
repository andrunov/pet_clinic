package ru.andrunov.clinic;

import java.util.ArrayList;

/**
 * Clinic's client describing class
 * DEFAULT uses instead of null
 */
public class Client {
    private static int COUNT = 0; // counter
    public static final Client DEFAULT = new Client("","",""); // use instead of null
    public Console console; // console for input - output
    private final int id; // identifier. Use for comfortable navigation in clients list
    private String address; //clients address
    private String phoneNumber; //clients phone number
    private String name; //clients name
    private ArrayList<Pet> pets; //clients pets

    /**
     * constructor
     * @param name - clients name
     * @param address - clients address
     * @param phoneNumber - clients phone number
     * @pets - clients pets
     */
    public Client(String name, String address, String phoneNumber) {
        this.address = address;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.id = COUNT++;
        this.console = new Console();
        this.pets = new ArrayList<Pet>();
    }


    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pet> getPets() {
        return pets;
    }

    /**
     * get users pet by nickName
     * @param nickName - pets string nickname
     * @return list of found pets
     */
    public Pet getPet(String nickName){
        Pet result = Pet.DEFAULT;
        for (Pet pet : pets){
            if (pet.getNickName().equals(nickName)){
                result = pet;
                break;
            }
        }
        return result;
    }

    /**
     * get users pet by id
     * @param id - pets id
     * @return pets found or default pet
     */
    public Pet getPet(int id){
        Pet result = Pet.DEFAULT;
        for (Pet pet : pets){
            if (pet.getId() == id){
                result = pet;
                break;
            }
        }
        return result;
    }



    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    /**
     * add new pet previously check that
     * it is already exists
     * @param pet - pet to add
     */
    public void addPet(Pet pet){
        if (pets.contains(pet)){
            console.println("This owner already has such pet");
        }
        else {
            pets.add(pet);
            console.println("Pet successfully added");
            console.println(pet.showDetailInfo());
        }
    }

    /**
     * remove pet from client list
     * @param pet - pet to remove
     */
    public void removePet(Pet pet){
            pets.remove(pets.indexOf(pet));
    }

    /**
     * clients parameters to string
     * @return id + name + phone number + address
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("id: "); stringBuilder.append(this.id);
        stringBuilder.append(" ");
        stringBuilder.append(this.name);
        stringBuilder.append("; phone: ");
        stringBuilder.append(this.phoneNumber);
        stringBuilder.append("; address: ");
        stringBuilder.append(this.address);
        return  stringBuilder.toString();
    }

    /**
     * method takes toString-method result
     * and adding into some details
     * @return toString result + clients pets list
     */
    public String showDetailInfo(){
        StringBuilder stringBuilder = new StringBuilder(this.toString());
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("pets :");
        stringBuilder.append(System.lineSeparator());
        if (pets.size() == 0){
            stringBuilder.append("   no pets");
        }
        else {
            for (Pet pet : pets) {
                stringBuilder.append("   ");
                stringBuilder.append(pet);
                stringBuilder.append(System.lineSeparator());
            }
        }

        return  stringBuilder.toString();
    }
}
