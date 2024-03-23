package delivery.utils;


import org.apache.commons.lang3.RandomStringUtils;
import java.util.Random;

public class RandomDataGenerator {

    public static String  generateName (){
        return RandomStringUtils.randomAlphabetic(12);
    }

    public static String generatePhoneNumber(){
        return  RandomStringUtils.randomNumeric(10);
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
}