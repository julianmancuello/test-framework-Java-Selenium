package common;

import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static final String ALPHANUMERIC_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    public static int generateRandomPositiveInteger(int bound) {
        return random.nextInt(bound) + 1;
    }

    public static String generateRandomAlphanumericString(int minLength, int maxLength) {
        if (minLength < 1) {
            throw new IllegalArgumentException("The minimum length must be at least 1");
        }
        int length = generateRandomNumberBetween(minLength, maxLength);
        StringBuilder randomString = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(ALPHANUMERIC_CHARACTERS.length());
            randomString.append(ALPHANUMERIC_CHARACTERS.charAt(index));
        }
        return randomString.toString();
    }

    public static int generateRandomNumberBetween(int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Limits are not valid");
        }
        return random.nextInt(lowerBound, upperBound + 1);
    }

    public static List<Integer> generateRandomListOfNumbers(int sizeList, int lowerBound, int upperBound, boolean uniqueValues) {
        List<Integer> resultList = new ArrayList<>();

        if (uniqueValues) {
            if (upperBound - lowerBound + 1 < sizeList) {
                throw new IllegalArgumentException("The range is insufficient to generate a list without repeated values.");
            }
            Set<Integer> uniqueValuesSet = new HashSet<>();
            while (uniqueValuesSet.size() < sizeList) {
                uniqueValuesSet.add(generateRandomNumberBetween(lowerBound, upperBound));
            }
            resultList.addAll(uniqueValuesSet);
        } else {
            for (int i = 0; i < sizeList; i++) {
                resultList.add(generateRandomNumberBetween(lowerBound, upperBound));
            }
        }
        return resultList;
    }

    public static List<Integer> generateRandomListOfIndexes(int numberOfIndexes, int upperBoundExcluded, boolean uniqueIndexes) {
        return generateRandomListOfNumbers(numberOfIndexes, 0, upperBoundExcluded - 1, uniqueIndexes);
    }

    public static String extractPrice(String text) {
        Pattern pattern = Pattern.compile("(\\$\\s*[\\d.]+)");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new IllegalArgumentException("No price found in the input text.");
    }

    public static double parsePrice(String priceInString) {
        try {
            String extractedPrice = extractPrice(priceInString);
            return Double.parseDouble(extractedPrice.replace("$", "").trim());
        } catch (IllegalArgumentException e) {
            return Double.parseDouble(priceInString.trim());
        }
    }

    public static boolean isEachElementInListPresentInPage(List<WebElement> webElements, List<?> valuesStored, Function<WebElement, ?> valueExtractor) {
        if (webElements.size() == valuesStored.size()) {
            for (int i = 0; i < webElements.size(); i++) {
                Object extractedValue = valueExtractor.apply(webElements.get(i));
                if (!extractedValue.equals(valuesStored.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean isEachStringInListPresentInPage(List<WebElement> webElements, List<String> stringsStored) {
        return isEachElementInListPresentInPage(webElements, stringsStored, WebElement::getText);
    }

    public static boolean isEachDoubleInListPresentInPage(List<WebElement> webElements, List<Double> doublesStored) {
        return isEachElementInListPresentInPage(webElements, doublesStored, element -> parsePrice(element.getText()));
    }

    public static boolean isListSizeEqualToExpectedNumber(List<WebElement> listOfWebElements, int expectedNumber){
        return isNumberEqualToNumber(listOfWebElements.size(), expectedNumber);
    }

    public static boolean isEachWebElementDisplayed(List<WebElement> webElements) {
        for (WebElement element : webElements) {
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Number> T sumListOfNumbers(List<T> listOfNumbers) {
        if (listOfNumbers.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be empty.");
        }

        double sum = roundTo2Digits(listOfNumbers.stream().mapToDouble(Number::doubleValue).sum());

        if (listOfNumbers.get(0) instanceof Integer) {
            return (T) Integer.valueOf((int) sum);
        } else if (listOfNumbers.get(0) instanceof Double) {
            return (T) Double.valueOf(sum);
        } else if (listOfNumbers.get(0) instanceof Float) {
            return (T) Float.valueOf((float) sum);
        } else if (listOfNumbers.get(0) instanceof Long) {
            return (T) Long.valueOf((long) sum);
        } else {
            throw new UnsupportedOperationException("Type not supported: " + listOfNumbers.get(0).getClass());
        }
    }

    public static <T extends Number> double calculateTaxes(T amount, double taxRate) {
        return roundTo2Digits((amount.doubleValue() * taxRate));
    }

    public static <T extends Number> double calculateTotalWithTaxes(T subtotal, double taxRate) {
        double subtotalDouble = roundTo2Digits(subtotal.doubleValue());
        double taxDouble = roundTo2Digits(subtotalDouble * taxRate);
        return roundTo2Digits(subtotalDouble + taxDouble);
    }

    public static <T extends Number, U extends Number> boolean isNumberEqualToNumber(T firstNumber, U secondNumber) {
        return firstNumber.equals(secondNumber);
    }

    public static <T extends Number> double roundTo2Digits(T number) {
        return (double) Math.round(number.doubleValue() * 100) / 100;
    }

    public static boolean isCalculationMatchingNumberInPage(double calculatedNumber, double numberInPage, String calculatedItem) {
        if (isNumberEqualToNumber(calculatedNumber, numberInPage)) {
            System.out.println("The " + calculatedItem + " displayed matches the calculated " + calculatedItem + ".");
            return true;
        }
        System.out.println("The " + calculatedItem + " displayed " + numberInPage + " does not match the calculated " + calculatedItem + " " + calculatedNumber);
        return false;
    }

    public static String extractLocatorFromWebElement(WebElement webElement) {
        Pattern pattern = Pattern.compile("-> (.*?)]");
        Matcher matcher = pattern.matcher(webElement.toString());
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "The locator could not be extracted.";
    }
}