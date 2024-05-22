import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Example exchange rates
        exchangeRates.put("USD_EUR", 0.92);
        exchangeRates.put("EUR_USD", 1.09);
        exchangeRates.put("USD_GBP", 0.77);
        exchangeRates.put("GBP_USD", 1.30);
        exchangeRates.put("EUR_GBP", 0.84);
        exchangeRates.put("GBP_EUR", 1.19);
        // Add more exchange rates as needed
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        String key = fromCurrency + "_" + toCurrency;
        if (!exchangeRates.containsKey(key)) {
            throw new IllegalArgumentException("Exchange rate for " + key + " not found.");
        }
        double rate = exchangeRates.get(key);
        return amount * rate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the currency you are converting from (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the currency you are converting to (e.g., EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        try {
            double convertedAmount = convert(fromCurrency, toCurrency, amount);
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
