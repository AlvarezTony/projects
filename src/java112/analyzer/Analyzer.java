package java112.analyzer;


/**
 * The Analyzer interface will ensure that classes which implement it
 * have both a processToken and a writeOutputFile method.
 *
 * @author Tony Alvarez
 */
public interface Analyzer{

    /**
     * Any actions that need to be taken for a single token in relation to reporting
     * are to be done within the processToken method.
     * For example, outputing a single token to a list for later use or incrementing
     * a counter.
     *
     * @param token a single token
     */
    void processToken(String token);
    
    /**
     * Write an output file related to the tokens processed by the analyzer
     * application.
     *
     * @param inputFilePath file path of the file which was input as part of the main
     * command line argument.
     *
     *
     */
    void writeOutputFile(String inputFilePath);
}
