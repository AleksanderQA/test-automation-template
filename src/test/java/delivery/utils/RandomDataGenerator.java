package delivery.utils;


import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class RandomDataGenerator {

    public static String  generateName (){
        return RandomStringUtils.randomAlphabetic(2,12);
    }

    public static String generatePhoneNumber(){
        return  RandomStringUtils.randomNumeric(6,10);
    }

    public static String generateComment(){
        return RandomStringUtils.randomAlphanumeric(20);
    }

    public static int generateCourierId(){
        return Integer.parseInt(RandomStringUtils.randomNumeric(2));
    }

    public static long generateOrderId(){
        return Long.parseLong(RandomStringUtils.randomNumeric(2));
    }

    public static String generateRandomOrderStatus() {
        String[] orderStatuses = {"OPEN", "ACCEPTED", "INPROGRESS", "DELIVERED"};
        int randomStatus = new Random().nextInt(orderStatuses.length);
        return orderStatuses[randomStatus];
    }
    public static String generateOrderUsername(){
        return RandomStringUtils.randomAlphabetic(2,12);
    }
    public static String generatePassword(){
        return RandomStringUtils.randomAlphanumeric(8,30);
    }
    public static String generateUsername(){
        return RandomStringUtils.randomAlphabetic(2,30);
    }
    public static String generateInvalidUsername() {
        return RandomStringUtils.randomAlphabetic(1);
    }
    public static String generateInvalidPassword() {
      return   RandomStringUtils.randomAlphanumeric(1, 7);
    }
    public static String generateInvalidPhoneNumber(){
        return  RandomStringUtils.randomNumeric(1,5);
    }
}