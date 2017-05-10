package java112.analyzer;


import java.io.*;
import java.util.*;


/**
 * class KeywordAnalzyer implements Analyzer.  This class will import two text
 * files.  It will use a list of strings from text file #1 and check text file #2
 * for those strings.  KeywordAnalyzer will output a file  containing all of the
 * Key words/strings we found and a numeric representation of where those key
 * words were found within text file #2.
 * @author Tony Alvarez
 **/
public class KeywordAnalyzer implements Analyzer {

    private Map<String, List <Integer>> keywordMap;
    private Properties properties;
    private int tokenOccurence;


    /**
     * Empty Constructor for KeywordAnalzyer implements Analyzer
     **/
    public KeywordAnalyzer() {
        keywordMap = new TreeMap<String, List <Integer>>();
    }


    /**
     * Constructor for KeywordAnalyzer which loads the properties file to the
     * properties object variable.  This method also kicks off the filechecker().
     *@param properties The properties object containing details needed for
     * processing such as file paths and file names.
     */
    public KeywordAnalyzer(Properties properties) {
        this();
        this.properties = properties;

        getKeywordsFile();
    }


    /**
     * Checks to make sure we can read the passed in File for processing with
     * exception handling.  If we are able to read the file we then initiate parsing
     * the file into tokens.
     *
     */
    private void getKeywordsFile() {

        try (BufferedReader inputReader = new BufferedReader
        (new FileReader(properties.getProperty("file.path.keywords")))) {

            generateKeywordMap(inputReader);
        } catch (FileNotFoundException fileNotFound) {
            fileNotFound.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    /**
     * Parses the file content into single line strings.  Those single line strings
     * are then passed into the tokenIterator method to be broken into tokens.
     *
     *@param input the BufferedReader object that contains the file content
     *@throws IOException IOException
     */
    private void generateKeywordMap(BufferedReader input) throws IOException {
        String inputLine = null;

        while (input.ready()) {
            inputLine = input.readLine();
            
            //Filters out empty strings from the inputs
            if (!inputLine.isEmpty()) {
            
            keywordMap.put(inputLine, new ArrayList<Integer>());
            }
        }
    }


    /**
     * obtains the current value of the KeywordMap variable which is a MAP object.
     *
     *@return keywordMap - Map object containing  a String, List of Integers set.
     */
    public Map<String, List <Integer>> getKeywordMap() {
        return keywordMap;
    }


    /**
     *  Processes one token at a time from file #2 (book file).
     * During this processing we keep track of which token we are processing
     * and check it against the list of Key words (file #1) for a match.
     * If a match is found we add the token place where we found it (tokenOccurence)
     * to the List within the KeywordMap
     * @param token a single token passed in from the book file
     *
     */
    public void processToken(String token) {
        tokenOccurence++;

        if (keywordMap.containsKey(token)) {

            List<Integer> listValue = keywordMap.get(token);
            listValue.add(tokenOccurence);
        }
    }


    /**
     * Prepares all of the details related to the content and formating of the
     * output file.
     *
     * @param out A Printwriter that containes the results of the processing output
     */
    public void prepareOutput(PrintWriter out) {

        for (Map.Entry <String, List <Integer>> entry : keywordMap.entrySet()) {

                out.println(entry.getKey() + " =");
                out.print("[");

            List<Integer> valueList = entry.getValue();

            Iterator<Integer> locationIterator = valueList.iterator();

            if (!locationIterator.hasNext()) {
                out.print("]");
                out.println();
                out.println();
            }


            prepareLocations(out, locationIterator);
        /*
         *  MOVED This nexted Loop into its own method - PrepareLocations()
         *
         * while (locationIterator.hasNext() == true) {
         *
         * String currentValue = locationIterator.next().toString();
         *
         * out.print(currentValue);
         *
         * if (currentLength < MAXLENGTH && locationIterator.hasNext() == true) {
         * out.print(", ");
         * currentLength = currentLength + currentValue.length() + 2;
         * } else if (currentLength < MAXLENGTH && locationIterator.hasNext() == false) {
         *
         * out.print("]\n\n");
         * currentLength = 0;
         * } else if (currentLength >= MAXLENGTH && locationIterator.hasNext() == true) {
         * out.print(",\n");
         * currentLength = 0;
         * } else if (currentLength >= MAXLENGTH && locationIterator.hasNext() == false) {
         * out.print("]\n\n");
         * currentLength = 0;
         * }
         * } */
        }
    }


    /**
     * Loops through the location integers and outputs them to the printwriter.
     *
     * @param out PrintWriter object containing the output which is written to a file
     * @param locationIterator  contains the list of locations a word appears and
     * allows us to iterate through them for controlled output formating.
     */
    public void prepareLocations(PrintWriter out, Iterator<Integer> locationIterator) {

        Integer MAXLENGTH = 66;
        Integer currentLength = 0;

        while (locationIterator.hasNext() == true) {

            String currentValue = locationIterator.next().toString();

            out.print(currentValue);

            if (currentLength < MAXLENGTH && locationIterator.hasNext() == true) {
                out.print(", ");
                currentLength = currentLength + currentValue.length() + 2;
            } else if (currentLength < MAXLENGTH && locationIterator.hasNext() == false) {

                out.print("]");
                out.println();
                out.println();
                
                currentLength = 0;
            } else if (currentLength >= MAXLENGTH && locationIterator.hasNext() == true) {
                //out.print(",\n");
                out.print(",");
                out.println();
                currentLength = 0;
            } else if (currentLength >= MAXLENGTH && locationIterator.hasNext() == false) {
                //out.print("]\n\n");
                out.print("]");
                out.println();
                out.println();
                currentLength = 0;
            }
        }
    }


    /*  **** WORKING BASED ON NUMBER OF WORDS ON LINE KEEP UNTIL REVIEW******
     * public void prepareOutput(PrintWriter out) {
     *
     * Integer maxLength = 8;
     * Integer currentLength = 1;
     *
     * for (Map.Entry<String, List<Integer>> entry : keywordMap.entrySet()) {
     *
     * out.print(entry.getKey() + " =\n" + "[");
     * //System.out.print("\n" + entry.getValue() + "]");
     *
     *
     * List<Integer> valueList = entry.getValue();
     *
     * Iterator<Integer> locationIterator = valueList.iterator();
     * while (locationIterator.hasNext() == true) {
     *
     * out.print(locationIterator.next());
     *
     * if (currentLength < maxLength && locationIterator.hasNext() == true) {
     * out.print(", ");
     * currentLength ++;
     * } else if (currentLength < maxLength && locationIterator.hasNext() == false) {
     *
     * out.print("]\n\n");
     * currentLength = 1;
     *
     * } else if(currentLength == maxLength && locationIterator.hasNext() == true) {
     * out.print(",\n");
     * currentLength = 1;
     * } else if (currentLength == maxLength && locationIterator.hasNext() == false) {
     * out.print("]\n\n");
     * currentLength = 1;
     * }
     *
     * }
     *
     * }
     *
     * }
     *********************************************************************/

    /**
     * Writes a new file to disc containing the unique list of tokens and a count
     * for how many times that token(word) was used in the processed file.
     * During the file creation exception handling is managed here.  The output
     * file name and destination are pulled from the properties instance variable
     * and mapped here.
     * @param inputFilePath file path of the file which was input as part of the
     * main command line argument.
     *
     */
    public void writeOutputFile(String inputFilePath) {
        String outputFilePath = properties.getProperty("output.dir")
        + properties.getProperty("output.file.keyword");

        // System.out.println("KeywordAnalyzer.writeOutputFile method hit." + outputFilePath);    /*TEMPORARY TEST */
        try (PrintWriter out = new PrintWriter(new BufferedWriter
        (new FileWriter(outputFilePath)))) {

            prepareOutput(out);
        } catch (IOException inputOutputException) {
            inputOutputException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
