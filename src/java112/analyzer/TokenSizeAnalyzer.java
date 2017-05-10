package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * The TokenSizeAnalyzer class creates a unique list of tokens(words) as well
 * as a count of how many times each unique word was used in the processed file
 * and outputs the list to a text file.
 *
 * @author Tony Alvarz
 *
 */
public class TokenSizeAnalyzer implements Analyzer {

    private Map<Integer, Integer> tokenSizes;
    private Properties properties;
    private int maximumSize;


    /**
     * Constructor for TokenSizeAnalyzer.
     **/
    public TokenSizeAnalyzer() {
        tokenSizes = new TreeMap<Integer, Integer>();
    }


    /**
     * Loads the properties file into the properties instance variable
     * @param properties properties file values as a Properties object
     **/
    public TokenSizeAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * obtains the current value of the tokenSizes instance variable and returns it.
     *@return tokenSizes  Map of Integer representing the tokenSize and another
     * integer representing the count of times that token size was found.
     */
    public Map<Integer, Integer> getTokenSizes() {
        return tokenSizes;
    }


    /**
     * obtains the current value of the maximumSize variable and returns it.
     *
     * @return maximumSize a number representing the largest number of
     * occurences
     *
     */
    public int getMaximumSize() {
        return maximumSize;
    }


    /**
     *
     * Loops through all unique token sizes and outputs them one at a time.
     * @param out Where we are outputing the individual tokens
     */
    private void outPutIndividualTokenSizes(PrintWriter out) {
        for (Map.Entry <Integer, Integer> entry : tokenSizes.entrySet()) {

            out.println(entry.getKey() + "\t" + entry.getValue());
        }
        out.println("\n\n");
    }


    /**
     * Adds a single NEW unique token to the unique token list and IF this token
     * is already on our unique list we will increment the count by 1
     * @param token a single token(word)
     */
    public void processToken(String token) {

        if (!tokenSizes.containsKey(token.length())) {
            tokenSizes.put(token.length(), 1);
        } else {
            int count = tokenSizes.get(token.length());
            tokenSizes.put(token.length(), count + 1);
        }
    }


    /**
     * Sets the maximumSize instance variable
     *
     */
    public void setMaximumSize() {
        List<Integer> tokenSizeList = new ArrayList<Integer>(tokenSizes.values());

        Integer currentMax = 0;

        for (Integer value : tokenSizeList) {

            if (value > currentMax) {
                currentMax = value;
            }
        }
        maximumSize = currentMax;
        // System.out.println(maximumSize);
    }


    /**
     *Creates the overall output Chart representing occurences.  Also calls
     * the createGrphics method
     * @param out PrintWriter object for outputing the chart
     */
    public void createChart(PrintWriter out) {

        Integer legendSize = getMaximumSize() / 76;

        // System.out.println(legendSize);
        for (Map.Entry <Integer, Integer> entry : tokenSizes.entrySet()) {

            out.print(entry.getKey() + "\t" + "*");

            createGraphics(legendSize, entry, out);

            out.print("\n");
        }
    }

/**
* creates the  *  graphic on the chart after the first one.
*
@param legendSize value that each graphic (*) represents
@param entry the map containing word length and number of occurences
@param out PrintWriter object which contains the tokenSizeAnalyzer output.
*/
    public void createGraphics(Integer legendSize, Map.Entry <Integer, Integer> entry, PrintWriter out) {
        for (Integer graphic = 1; graphic < (entry.getValue() / legendSize); graphic++) {

            out.print("*");
        }
    }


    /**
     * Writes a new file to disc containing the unique list of token sizes and a
     count for how many times that token size was found in the processed file.
     * During the file creation exception handling is managed here.  The output
     * file name and destination are pulled from the properties instance variable
     * and mapped here.
     * @param inputFilePath file path of the file which was input as part of the main
     * command line argument.
     *
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.token.size");

        // System.out.println("BigWordAnalyzer.writeOutputFile method hit." + outputFilePath);    /*TEMPORARY TEST */
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            outPutIndividualTokenSizes(out);
            setMaximumSize();
            createChart(out);
            // System.out.println("TokenCountAnalyzer.outPutIndividualTokens(out)hit");
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
