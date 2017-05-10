package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * The TokenCountAnalyzer class creates a unique list of tokens(words) as well
 * as a count of how many times each unique word was used in the processed file
 * and outputs the list to a text file.
 *
 * @author Tony Alvarz
 *
 */
public class TokenCountAnalyzer implements Analyzer {

    private Properties properties;
    private Map<String, Integer> tokenCounts;


    /**
     * Returns the TokenCounts
     * @return TokenCounts
     *
     **/
    public Map getTokenCounts() {
        return tokenCounts;
    }


    /**
     * Constructor for TokenCountAnalyzer which sets the tokenCounts instance
     * variable to a TreeMap, ensuring a unique list of key values
     **/
    public TokenCountAnalyzer() {
        tokenCounts = new TreeMap<String, Integer>();
    }


    /**
     * Loads the properties file into the properties instance variable
     * @param properties properties file values as a Properties object
     **/
    public TokenCountAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * Loops through all unique tokens and outputs them one at a time.
     * @param out Where we are outputing the individual tokens
     */
    private void outPutIndividualTokens(PrintWriter out) {
        for (Map.Entry <String, Integer> entry : tokenCounts.entrySet()) {

            out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }


    /**
     * Adds a single NEW unique token to the unique token list and IF this token
     * is already on our unique list we will increment the count by 1
     * @param token a single token(word)
     */
    public void processToken(String token) {

        if (!tokenCounts.containsKey(token)) {
            tokenCounts.put(token, 1);
        } else {
            int count = tokenCounts.get(token);
            tokenCounts.put(token, count + 1);
        }
    }


    /**
     * Writes a new file to disc containing the unique list of tokens and a count
     * for how many times that token(word) was used in the processed file.
     * During the file creation exception handling is managed here.  The output
     * file name and destination are pulled from the properties instance variable
     * and mapped here.
     * @param inputFilePath file path of the file which was input as part of the main
     * command line argument.
     *
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.token.count");

        // System.out.println("BigWordAnalyzer.writeOutputFile method hit." + outputFilePath);    /*TEMPORARY TEST */
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            outPutIndividualTokens(out);
            // System.out.println("TokenCountAnalyzer.outPutIndividualTokens(out)hit");
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
