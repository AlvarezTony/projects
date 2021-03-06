package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 *
 * Creates an output text file which includes a summary report of processed tokens.
 * This summary report includes the application name, author, email, the file path
 * for the file that was processed, when it was processed and total count of tokens.
 *
 * @author Tony Alvarez
 */
public class SummaryReport implements Analyzer {

    private int totalTokensCount;
    private Properties properties;


    /**
     * Empty constructor for SummaryReport.
     */
    public SummaryReport() {
    // System.out.println("SummaryReport instantiated.");    /* TEMPORARY TEST */
    }


    /**
     * Loads the properties file into the properties instance variable
     * @param properties properties file values as a Properties object
     **/
    public SummaryReport(Properties properties) {
        this();
        this.properties = properties;
    }


    /**
     * This method returns the total count of tokens
     * @return totalTokensCount a total count (numeric) of tokens created.
     */
    public int getTotalTokensCount() {

        // System.out.println("getTotalTokensCount hit.");    /* TEMPORARY TEST */
        return totalTokensCount;
    }


    /**
     *Increments the count of total tokens by one each time it is called.
     *@param token a token which is passed in as part of the file processing.
     */
    public void processToken(String token) {
        totalTokensCount++;
        // System.out.println("SummaryReport.processToken method hit.");    /* TEMPORARY TEST */
    }


    /**
     * Creates the content for the summary report using values from the properties
     * file where available.
     *
     * @param inputFilePath file path of the file which was input as part of the main
     * @param out object to be writen to
     */
    private void createOutputContent(String inputFilePath, PrintWriter out) {
        String outputFilePath = properties.getProperty("output.dir")
                + properties.getProperty("output.file.summary");
        out.println("Application: " + properties.getProperty("application.name"));
        out.println("Author: " + properties.getProperty("author") + ", "
                + properties.getProperty("class.day.time"));
        out.println("email: " + properties.getProperty("author.email.address"));
        out.println("Input file: " + inputFilePath);
        out.println("Analyzed on: " + new Date());
        out.println("Total token count: " + getTotalTokensCount());
    }


    /**
     *Writes a new file to disc containing the summary report for the processed tokens.
     * During the file creation exception handling is managed here.
     * @param inputFilePath file path of the file which was input as part of the main
     * command line argument.
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = (properties.getProperty("output.dir")) + (properties.getProperty("output.file.summary"));

        // System.out.println("SummaryReport.writeOutputFile method hit.");    /* TEMPORARY TEST */
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath)))) {

            createOutputContent(inputFilePath, out);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
