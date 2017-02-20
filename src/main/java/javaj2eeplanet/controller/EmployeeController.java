package javaj2eeplanet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javaj2eeplanet.model.Employee;
import javaj2eeplanet.model.EmployeeDao;

/**
 * A class to test interactions with the MySQL database using the EmployeeDao class.
 *
 * @author javaj2eeplanet
 */
@Controller
public class EmployeeController {

  
  
  @Autowired
  EmployeeDao employeeDao;
  // ------------------------
  // PUBLIC METHODS
  // ------------------------
  
  /**
   * /create  --> Create a new employee and save it in the database.
   * 
   * @param email Employee's email
   * @param name Employee's name
   * @return A string describing if the employee is succesfully created or not.
   */
  @RequestMapping("/create")
  @ResponseBody
  public String create(String email, String name) {
    Employee user = null;
    try {
      employee = new Employee(email, name);
      employeeDao.save(employee);
    }
    catch (Exception ex) {
      return "Error creating the employee: " + ex.toString();
    }
    return "Employee succesfully created! (id = " + employee.getId() + ")";
  }
  
  /**
   * /delete  --> Delete the employee having the passed id.
   * 
   * @param id The id of the employee to delete
   * @return A string describing if the employee is succesfully deleted or not.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(long id) {
    try {
      Employee employee = new Employee(id);
      employeeDao.delete(employee);
    }
    catch (Exception ex) {
      return "Error deleting the employee: " + ex.toString();
    }
    return "Employee succesfully deleted!";
  }
  
  /**
   * /get-by-email  --> Return the id for the employee having the passed email.
   * 
   * @param email The email to search in the database.
   * @return The employee id or a message error if the user is not found.
   */
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(String email) {
    String userId;
    try {
      Employee employee = employeeDao.findByEmail(email);
      employeeId = String.valueOf(employee.getId());
    }
    catch (Exception ex) {
      return "Employee not found";
    }
    return "The employee id is: " + employeeId;
  }
  
  /**
   * /update  --> Update the email and the name for the employee in the database 
   * having the passed id.
   * 
   * @param id The id for the user to update.
   * @param email The new email.
   * @param name The new name.
   * @return A string describing if the user is succesfully updated or not.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateEmployee(long id, String email, String name) {
    try {
      Employee employee = employeeDao.findOne(id);
      employee.setEmail(email);
      employee.setName(name);
      employeeDao.save(employee);
    }
    catch (Exception ex) {
      return "Error updating the employee: " + ex.toString();
    }
    return "Employee succesfully updated!";
  }
 
} 
