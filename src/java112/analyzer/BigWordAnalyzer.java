package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * The BigWordAnalyzer class will only store unique toeksn that are greater than
 * or equal to the minimum word length within the properties file.  It will then
 * create an output file that has a list of all unique words along with a count of
 * how many times each word was used.
 *
 * @author Tony Alvarz
 *
 */
public class BigWordAnalyzer implements Analyzer {

    private Properties properties;
    private Set<String> bigWords;
    private int minimumWordLength;


    /**
     *Returns a SET of strings containing all of the Big Words from the processed file.
     * @return bigWords -all of the big words
     **/
    public Set<String> getBigWords() {
        return bigWords;
    }


    /**
     * Constructor for BigWordAnalyzer. Sets the bigWords variable to a TreeSet
     * to ensure the list of big words is unique.
     **/
    public BigWordAnalyzer() {
        bigWords = new TreeSet<String>();
    }


    /**
     * Loads the properties file into the properties instance variable and
     * also obtains the minimum word length that the program is to use as a
     * filter.
     * @param properties properties file values as a Properties object
     **/
    public BigWordAnalyzer(Properties properties) {

        // loadProperties();
        this();
        this.properties = properties;

        minimumWordLength = Integer.parseInt(properties.getProperty("bigwords.minimum.length"));
    }


    /**
     * loops through the list of big words and outputs them.
     * @param out output
     **/
    private void outPutIndividualTokens(PrintWriter out) {

        // System.out.println("BigWordAnalyzer.outPutIndividualToken hit");    /*TEMPORARY TEST*/
        for (String name : bigWords) {
            out.println(name);
        }
    }


    public void processToken(String token) {

        // System.out.println("BigWordAnalyzer.processToken hit"); /* TEMP TEST */
        if (token.length() >= minimumWordLength) {

            // System.out.println("processToken IF statement hit" + token);    /* TEMP TEST LINE */
            bigWords.add(token);
        }
    }


    /**
     * Writes a new file to disc containing the unique list of Big words that have
     * been processed.  During the file creation exception handling is managed here.
     * @param inputFilePath file path of the file which was input as part of the main
     * command line argument.
     *
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir") + properties.getProperty("output.file.bigwords");

        // System.out.println("BigWordAnalyzer.writeOutputFile method hit." + outputFilePath);    /*TEMPORARY TEST */
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            outPutIndividualTokens(out);
            // System.out.println("bigWordAnalyzer.outPutIndividualTokens(out)hit");
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
