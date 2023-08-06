import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GreeterAssignment {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\muham\\Desktop\\GreeterApp\\src\\src\\data.xlsx";

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming the data is on the first sheet

            Map<String, Greeter> greetersMap = new HashMap<>();

            for (Row row : sheet) {
                String status = row.getCell(0).getStringCellValue();
                if (status.equalsIgnoreCase("Arrived")) { // Assuming "Arrived" indicates a newcomer
                    String firstName = row.getCell(2).getStringCellValue();
                    String lastName = row.getCell(3).getStringCellValue();

                    Newcomer newcomer = new Newcomer(firstName, lastName);

                    // Assign the newcomer to a greeter
                    Greeter greeter = getGreeter(); // Implement this method to get a greeter from the list
                    greeter.addNewcomer(newcomer);
                }
            }

            // Print the assignment
            for (Greeter greeter : greetersMap.values()) {
                System.out.println(greeter.getName() + "'s assigned newcomers:");
                for (Newcomer newcomer : greeter.getAssignedNewcomers()) {
                    System.out.println(newcomer.getFirstName() + " " + newcomer.getLastName());
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Implement this method to get a greeter from the list (You can add more greeters in the future)
    private static Greeter getGreeter() {
        // You can have a list of greeters and choose one based on some criteria (e.g., load balancing)
        // For simplicity, let's just return one greeter for now.
        return new Greeter("Muja");
    }
}
