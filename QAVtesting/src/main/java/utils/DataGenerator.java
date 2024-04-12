package utils;

import com.github.javafaker.Faker;

import java.util.Random;

public class DataGenerator {
    static Faker faker = new Faker();
    static Random random = new Random();
    public static String randomName = faker.name().fullName();
    public static String randomEmail = faker.internet().emailAddress();
    public static String randomPhoneNumber = faker.phoneNumber().cellPhone();
    public static String randomQuote = faker.shakespeare().hamletQuote();
    public static String fullname = randomName;
    public static String email = randomEmail;
    public static String phone = randomPhoneNumber;
    public static String quote = randomQuote;
    public static int randomGender = random.nextInt(3);
    public static int randomExP = random.nextInt(6);
    public static int randomSkill = random.nextInt(1,4);
    public static int randomQAtool = random.nextInt(4);


}
