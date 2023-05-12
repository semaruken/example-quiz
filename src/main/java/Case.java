import java.util.ArrayList;
import java.util.List;

public class Case {

    public static String validateCardNumber(String cardNumber) {
        // Remove any spaces in the card number
        cardNumber = cardNumber.replace(" ", "");

        // Step 1: Double every second digit from right to left
        var doubledDigits = doubleEverySecondDigitFromRightToLeft(cardNumber);

        // Step 2: Add all single digit numbers from step 1
        var digitSum = singleDigitNumbersAddAll(doubledDigits);

        // Step 3: Add all digits in the single places
        // Step 4: Sum the results from steps 2 and 3
        digitSum = singlePlacesAddAllDigits(cardNumber,digitSum);

        // Step 5: Check if the result is divisible by 10
        if (digitSum % 10 == 0) {
            return "Valid";
        } else {
            return "Invalid";
        }
    }

    public static List<Integer> doubleEverySecondDigitFromRightToLeft(String cardNumber){
        List<Integer> doubledDigits = new ArrayList<>();
        for (int i = cardNumber.length() - 2; i >= 0; i -= 2) {
            int doubledDigit = Integer.parseInt(cardNumber.substring(i, i + 1)) * 2;
            if (doubledDigit > 9) {
                doubledDigit -= 9;
            }
            doubledDigits.add(doubledDigit);
        }
        return doubledDigits;
    }

    public static int singleDigitNumbersAddAll(List<Integer> doubledDigits){
        int digitSum = 0;
        for (int doubledDigit : doubledDigits) {
            digitSum += doubledDigit;
        }
        return digitSum;
    }

    public static int singlePlacesAddAllDigits(String cardNumber, int digitSum){
        for (int i = cardNumber.length() - 1; i >= 0; i -= 2) {
            digitSum += Integer.parseInt(cardNumber.substring(i, i + 1));
        }
        return digitSum;
    }


    public static void main(String[] args) {
        List<String> cardNumbers = new ArrayList<>();
        cardNumbers.add("4556 7375 8689 9855");
        cardNumbers.add("4024 0071 0902 2143");
        for (String cardNumber : cardNumbers){
            String result = validateCardNumber(cardNumber);
            System.out.println("Card Number:" + cardNumber+ "\nResult:" + result);

        }
    }

}
