import java.math.BigDecimal;
import java.util.Stack;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

//TODO: create a "RATE" interface with a function getRate() that returns a BigDecimal.











 
//TODO: create a BigDecimalRate class that uses the Rate interface
//it should practice data encapsulation, set the rate variable of datatype BigDecimal, 
//and practice data encapsulation











 
//TODO: create a NumberRate class that uses the Rate interface
//it should practice data encapsulation, and the getRate function has already been created for you
//be sure your constructor sets the rate variable.

    public BigDecimal getRate() {
        return BigDecimal.valueOf(rate.doubleValue());
    }











 
// Class representing a currency path
class CurrencyPath {
    private Stack<String> path;
    private BigDecimal runningTotal;
    private Object[][] allRates;
    private String[] listOfCurrencies;

    public CurrencyPath(Object[][] allRates, String[] listOfCurrencies) {
        this.path = new Stack<>();
        this.runningTotal = BigDecimal.ONE;
        this.allRates = allRates;
        this.listOfCurrencies = listOfCurrencies;
    }

    // Find the optimal path based on given parameters
    public String[] findOptimal(int depth, String start) {
        recurse(depth, start);
        return path.toArray(new String[0]);
    }

    //TODO: create getter functions for path, listOfCurrencies, and allRates











 
    // Recursive function to find the optimal path
    private void recurse(int depth, String start) {
        if (depth == 0) {
            // Base case: reached the desired depth
            //TODO: push start to the path Stack variable and return











        }

        int startI = Arrays.asList(listOfCurrencies).indexOf(start);
        BigDecimal bestValue = BigDecimal.ZERO;
        String bestNextCurrency = "";

        for (int i = 0; i < listOfCurrencies.length; i++) {
            if (i != startI) {
                Rate forwardRate = createRate(allRates[startI][i]);
                Rate backwardRate = createRate(allRates[i][startI]);

                BigDecimal forwardValue = runningTotal.multiply(forwardRate.getRate());
                BigDecimal backwardValue = forwardValue.multiply(backwardRate.getRate());

                if (backwardValue.compareTo(bestValue) > 0) {
                    bestValue = backwardValue;
                    bestNextCurrency = listOfCurrencies[i];
                }
            }
        }

        //TODO: push start to path variable and set runningTotal to bestValue









        // Recursive call with updated values
        recurse(depth - 1, bestNextCurrency);
    }

    // Factory method to create a Rate based on the rateObject
    public Rate createRate(Object rateObject) {
        if (rateObject instanceof BigDecimal) {
            return new BigDecimalRate((BigDecimal) rateObject);
        } else if (rateObject instanceof Number) {
            return new NumberRate((Number) rateObject);
        } else {
            // Handle other cases if needed
            throw new IllegalArgumentException("Unsupported rate type");
        }
    }
}

// Main class for the project
public class Sprint2FinalProject {

    // Calculate and print the result based on the optimal path
    public static void calculateResult(CurrencyPath currencyPath, String start, int depth) {
        currencyPath.findOptimal(depth, start);
        System.out.println("Path: (from 1.00 of starting currency)");
        Stack<String> path = currencyPath.getPath();
        BigDecimal result = BigDecimal.ONE;

        String currentCurrency = start;
        while (!path.isEmpty()) {

            //create a variable called nextCurrency set it to top value on the path Stack. be sure to pop.












            int currentIndex = Arrays.asList(currencyPath.getListOfCurrencies()).indexOf(currentCurrency);
            int nextIndex = Arrays.asList(currencyPath.getListOfCurrencies()).indexOf(nextCurrency);

            Rate rate = currencyPath.createRate(currencyPath.getAllRates()[currentIndex][nextIndex]);
            BigDecimal rateValue = rate.getRate();

            System.out.println(currentCurrency + " -> " + nextCurrency + " : " + rateValue);
            result = result.multiply(rateValue);
            currentCurrency = nextCurrency;
        }

        // Connect the last currency back to the starting one
        int lastIndex = Arrays.asList(currencyPath.getListOfCurrencies()).indexOf(currentCurrency);
        int startIndex = Arrays.asList(currencyPath.getListOfCurrencies()).indexOf(start);

        Rate lastRate = currencyPath.createRate(currencyPath.getAllRates()[lastIndex][startIndex]);
        BigDecimal lastRateValue = lastRate.getRate();

        // System.out.println(currentCurrency + " -> " + start + " : " + lastRateValue);
        result = result.multiply(lastRateValue);
        result = result.setScale(4, BigDecimal.ROUND_HALF_UP);
        System.out.println("\nResult: " + result);
    }

    // Connect to the API and retrieve the initial data
    public static JSONObject connect(String apiAddress) {
        //TODO: make this function return a JSONObject, created from a String retrieved from the apiAddress











 
    }

    // Main method to run the project
    public static void main(String[] args) {

        // API Address
        String apiAddress = "https://open.er-api.com/v6/latest/USD";

        //TODO: connect() to the apiAddress above and get the rates info from that address as a JSONObject
        //store it in a variable called "rates"











        
        // Extract information from JSONObject rates variable
        String[] keys = new String[rates.keySet().size()];
        keys = rates.keySet().toArray(keys);

        Object[][] allRates = new Object[keys.length][keys.length];
        for (int i = 0; i < keys.length; i++) {
            String apiString = "https://open.er-api.com/v6/latest/" + keys[i];
            JSONObject response = connect(apiString).getJSONObject("rates");
            for (int j = 0; j < keys.length; j++) {
                allRates[i][j] = response.get(keys[j]);
            }
        }

        //TODO: set the String start and int depth values by user input
        //create an instance of CurrencyPath with allRates and keys
        //Run calculateResult with appropriate parameters.











 
    }
}
