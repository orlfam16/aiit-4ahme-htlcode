
package jsontutorial;

import java.util.Arrays;
import com.google.gson.Gson;


public class ConvertObjectToJson {
    
    public static void main(String[] args) {
        
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Lokesh");
        employee.setLastName("Gupta");
        employee.setRoles(Arrays.asList("ADMIN", "MANAGER"));
 
        Gson gson = new Gson();
 
        System.out.println(gson.toJson(employee));
    }
}
