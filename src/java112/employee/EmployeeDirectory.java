package java112.employee;


import java.sql.*;
import java.util.*;
import java.util.Scanner.*;


/**
 * @author Tony Alvarez
 * class Employeedirectory
 */
public class EmployeeDirectory {

    private Properties properties;


    /**
     * Constructor for EmployeeDirectory
     */
    public EmployeeDirectory() {
    }


    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }

    public void addEmployeeRecord(String firstName, String lastName,
    String socialSecurityNumber, String department, String roomNumber,
    String phoneNumber) {

        Employee currentEmployee = new Employee();

        currentEmployee.setFirstName(firstName);
        currentEmployee.setLastName(lastName);
        currentEmployee.setSocialSecurityNumber(socialSecurityNumber);
        currentEmployee.setDepartment(department);
        currentEmployee.setRoomNumber(roomNumber);
        currentEmployee.setPhoneNumber(phoneNumber);

        insertQueryString(currentEmployee);
    }

        public Search searchEmployeeRecord(String searchType, String searchTerm) {
        
            Search search = new Search();
            
            search.setSearchType(searchType);
            search.setSearchTerm(searchTerm);
            
        System.out.println(searchType);
        System.out.println(searchTerm);
        
        searchEmployeeQuery(search);
        
        return search;
        
    }
    

    /**
     *establish a connection tothedatabase and return the connection to the
     *calling method
     */
    private Connection connectToDatabase() {
        System.out.println("EmployeeDirectory.connectToDatabase hit");    /* Temporary Test */

        Connection connection = null;

        try {

            Class.forName(properties.getProperty("driver"));

            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("username"),
                    properties.getProperty("password"));
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        return connection;
    }
    
    private void searchEmployeeQuery(Search search) {
        
        System.out.println("searchEmployeeQueryHit");
        System.out.println(search.getSearchType());
        System.out.println(search.getSearchTerm());
        
        Statement statement = null;
        Connection connection = connectToDatabase();
        ResultSet resultSet = null;
        
        try {
            
            statement = connection.createStatement();

            String queryString = "Select emp_id, first_name, last_name, ssn, dept, room, phone"
                    + " from employees where " 
                    + search.getSearchType() + " = '" 
                    + search.getSearchTerm() + "'";
                    //+ ")";
                    
/*                  + currentEmployee.getFirstName()
                    + "', '" + currentEmployee.getLastName()
                    + "', '" + currentEmployee.getSocialSecurityNumber()
                    + "', '" + currentEmployee.getDepartment()
                    + "', '" + currentEmployee.getRoomNumber()
                    + "', '" + currentEmployee.getPhoneNumber()
                    + "')";
*/

            System.out.println("queryString: " + queryString);
            System.out.println("searchBoolean: " + search.getEmployeesFound());
            
            resultSet = statement.executeQuery(queryString);
  /* Testing Result set */
           // if (resultSet.Next()) {
           //     search.setEmployeesFound(true);
                
                while (resultSet.next()) {
                search.setEmployeesFound(true);
                String employeeId = resultSet.getString("emp_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                System.out.println(" Row: " + employeeId + " "
                            + firstName + " " 
                            + lastName 
                            + search.getEmployeesFound());
            }
                
           // } else {
           //     search.setEmployeesFound(false);   
           // }
  
            System.out.println("searchBoolean: " + search.getEmployeesFound());
            //while (resultSet.next()) {
            //    
            //    String employeeId = resultSet.getString("emp_id");
            //    String firstName = resultSet.getString("first_name");
            //    String lastName = resultSet.getString("last_name");
            //    System.out.println(" Row: " + employeeId + " "
            //                + firstName + " " 
            //                + lastName 
            //                + search.getEmployeesFound());
            //}
            

            //int row = statement.executeUpdate(queryString);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        
        try {
            
            if (resultSet != null) {
                    resultSet.close();
                }

            if (statement != null) {
                statement.close();
            }


            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
        
    }


    private void insertQueryString(Employee currentEmployee) {
        Statement statement = null;
        Connection connection = connectToDatabase();
        
        try {
            
            statement = connection.createStatement();

            String queryString = "Insert into employees(first_name, last_name, ssn, dept, room, phone)"
                    + " values('" + currentEmployee.getFirstName()
                    + "', '" + currentEmployee.getLastName()
                    + "', '" + currentEmployee.getSocialSecurityNumber()
                    + "', '" + currentEmployee.getDepartment()
                    + "', '" + currentEmployee.getRoomNumber()
                    + "', '" + currentEmployee.getPhoneNumber()
                    + "')";

            int row = statement.executeUpdate(queryString);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
        
        try {

            if (statement != null) {
                statement.close();
            }


            if (connection != null) {
                connection.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


   // private void closeMyConnection(Connection connection, Statement statement) {
   //
   //     try {
   //
   //         if (statement != null) {
   //             statement.close();
   //         }
   //
   //
   //         if (connection != null) {
   //             connection.close();
   //         }
   //     } catch (SQLException sqlException) {
   //         sqlException.printStackTrace();
   //     } catch (Exception exception) {
   //         exception.printStackTrace();
   //     }
   // }
}
