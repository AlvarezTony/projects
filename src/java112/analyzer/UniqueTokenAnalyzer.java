package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 *
 * The UniqueTokenAnalyzer class creates a unique list of tokens(words) and
 * outputs the final list to a text file.
 *
 * @author Tony Alvarez
 */
public class UniqueTokenAnalyzer implements Analyzer {

    private Set<String> uniqueTokensList;
    private Properties properties;


    /**
     * Constructor for uniqueTokenAnalyzer which ensures only Unique tokens are
     * kept on the list (uniqueTokenList).
     */
    public UniqueTokenAnalyzer() {
        // System.out.println("uniqueTokenAnalyzer constructor hit.");    /* TEMPORARY TEST */
        uniqueTokensList = new TreeSet<String>();
    }


    /**
     * Loads the properties file into the properties instance variable
     * @param properties properties file values as a Properties object
     **/
    public UniqueTokenAnalyzer(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * Returns the complete list of unique tokens.
     *
     * @return uniqueTokensList a complete list of unique tokens processed
     */
    public Set<String> getUniqueTokensList() {

        // System.out.println("getUniqueTokensList method hit.");    /* TEMPORARY TEST */
        return uniqueTokensList;
    }


    /**
     * Loops through all unique tokens and outputs them one at a time.
     * @param out Where we are outputing the individual tokens
     */
    private void outPutIndividualTokens(PrintWriter out) {

        // System.out.println("uniqueTokenAnalyzer.outPutIndividualToken hit");    /*TEMPORARY TEST*/
        for (String name : uniqueTokensList) {
            out.println(name);
        }
    }


    /**
     * Adds a single token to the unique token list.
     * @param token a single token(word)
     */
    public void processToken(String token) {

        // System.out.println("UniqueTokenAnalyzer.processToken method hit. -- " + token);    /*TEMPORARY TEST */
        uniqueTokensList.add(token);
    }


    /**
     * Writes a new file to disc containing the unique list of tokens
     * During the file creation exception handling is managed here.  The output
     * file name and destination are pulled from the properties instance variable
     * and mapped here.
     * @param inputFilePath file path of the file which was input as part of the main
     * command line argument.
     *
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.unique");

        // System.out.println("UniqueTokenAnalyzer.writeOutputFile method hit.");    /*TEMPORARY TEST */
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            outPutIndividualTokens(out);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
