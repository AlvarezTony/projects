package java112.employee;

import java.util.*;

/**
 * @author Tony Alvarez
 * class Search
 */
public class Search {
    
    private String searchType;
    private String searchTerm;
    private ArrayList<Employee> results; /* NEEDS to be an ArrayList<String> results */
    private boolean employeesFound;
	
    
    /**
     * Constructor for Search
     */
    public Search() {
        
    }
    
    /**
	 * Returns the value of searchType.
	 */
	public String getSearchType() {
		return searchType;
	}


	/**
	 * Sets the value of searchType.
	 * @param searchType The value to assign searchType.
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	/**
	 * Returns the value of searchTerm.
	 */
	public String getSearchTerm() {
		return searchTerm;
	}


	/**
	 * Sets the value of searchTerm.
	 * @param searchTerm The value to assign searchTerm.
	 */
	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}


	/**
	 * Returns the value of results.
	 */
	public ArrayList<Employee> getResults() {
		return results;
		//ArrayList<String>
	}


	/**
	 * Sets the value of results.
	 * @param results The value to assign results.
	 */
	public void setResults(Employee results) {
		this.results.add(results);
		//ArrayList<String>
	}


	/**
	 * Returns the value of employeesFound.
	 */
	public Boolean getEmployeesFound() {
		return employeesFound;
	}


	/**
	 * Sets the value of employeesFound.
	 * @param employeesFound The value to assign employeesFound.
	 */
	public void setEmployeesFound(Boolean employeesFound) {
		this.employeesFound = employeesFound;
	}

	/**
	* Will add the employee object to the list of found employee objects
	*
	*/
	public void addFoundEmployee(Employee employee) {
	    System.out.println("Search.addFoundEmployee hit");/* TEMPORARY TEST */
	}
    
    
  
    
    
    
}