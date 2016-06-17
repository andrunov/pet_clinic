package ru.andrunov.clinic;

import ru.andrunov.clinic.enums.Animal;
import ru.andrunov.clinic.enums.Sex;

/**
 * client's pet describing class
 * DEFAULT uses instead of null
 */
public class Pet {
    private static int COUNT = 0; //counter
    public static final Pet DEFAULT = new Pet(Animal.CAT,"", Client.DEFAULT,0, Sex.MALE); // use instead of null
    private final int id; //identifier. Use for comfortable navigation in pets list
    private Animal animal; //animal type
    private String nickName; //pets nickname
    private Client client; //pets owner
    private int age; //pets age
    private Sex sex; // pets sex

    /**
     * constructor
     * @param animal - animals type
     * @param nickName - pets nickname
     * @param client - pets owner
     * @param age - pets age
     * @param sex - pets sex
     */
    public Pet(Animal animal, String nickName, Client client, int age, Sex sex) {
        this.animal = animal;
        this.nickName = nickName;
        this.client = client;
        this.age = age;
        this.sex = sex;
        this.id = COUNT++;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    /**
     * pets parameters to string
     * @return id + animal + nickName + sex + age
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: ");
        stringBuilder.append(this.id);
        stringBuilder.append(", ");
        stringBuilder.append(this.animal);
        stringBuilder.append(" ");
        stringBuilder.append(this.nickName);
        stringBuilder.append(", sex - ");
        stringBuilder.append(this.sex);
        stringBuilder.append(", age(years) - ");
        stringBuilder.append(this.age);
        return stringBuilder.toString();
    }

    /**
     * method takes toString-method result
     * and adding into some details
     * @return toString result + pets owner name and id
     */
    public String showDetailInfo(){
        StringBuilder stringBuilder = new StringBuilder(this.toString());
        stringBuilder.append("; client: ");
        stringBuilder.append(this.client.getName());
        stringBuilder.append(" (id - ");
        stringBuilder.append(this.client.getId());
        stringBuilder.append(")");

        return stringBuilder.toString();
    }

}
