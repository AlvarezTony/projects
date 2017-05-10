package java112.analyzer;


/**
 * The AnalyzerDriver class is the starting point (main) for our application.
 * This class will create an instance of the AnalyzeFile class and pass the
 * arguments into the analyzer.runAnalysis method.
 * @author Tony Alvarez
 *
 */
public class AnalyzerDriver {

    /**
     * Constructor for AnalyzerDriver
     */
    public AnalyzerDriver() {
    }


    /**
     * This is the main method for the anlyzer program.
     *
     * @param arguments The command line arguments.
     */
    public static void main(String[] arguments) {
        AnalyzeFile analyzer = new AnalyzeFile();
        analyzer.runAnalysis(arguments);
    }
}
