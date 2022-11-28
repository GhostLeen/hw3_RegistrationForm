package testData;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomData {
    static Random random = new Random();

    public static String randomMonth() {
        String[] month = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        return month[random.nextInt(month.length)];
    }

    public static String randomGender() {
        String[] gender = {"Male", "Female", "Other"};
        return gender[random.nextInt(gender.length)];
    }

    public static String randomSubject() {
        String[] subject = {"Maths", "Accounting", "Arts", "Biology", "Economics"};
        return subject[random.nextInt(subject.length)];
    }

    public static String randomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        return hobbies[random.nextInt(hobbies.length)];
    }

    public static String randomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana"};
        return state[random.nextInt(state.length)];
    }

    public static String randomCity(String key) {
        Map<String, String[]> cityByState = new HashMap<>();
        cityByState.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        cityByState.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        cityByState.put("Haryana", new String[]{"Karnal", "Panipat"});

        String[] arrCityByState = cityByState.get(key);
        return arrCityByState[random.nextInt(arrCityByState.length)];
    }
}
