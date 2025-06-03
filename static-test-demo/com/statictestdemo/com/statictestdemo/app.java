package com.statictestdemo; 

import java.util.ArrayList;
import java.util.List;


public class app {

    

    public app() {
        // Constructor
    }

    public void printWelcomeMessage(String name) {
        if (name != null) {
           
            System.out.println("Welcome, " + name.toUpperCase() + "!");
        } else {
          
            System.out.println("Welcome, Guest!");
        }
    }

    public int addNumbers(int a, int b) {
        return a + b; // Trả về trực tiếp, không cần biến tạm
    }

    public void processList() {
        List<String> items = new ArrayList<>(); // Sử dụng toán tử kim cương
        items.add("Item 1");
        items.add("Item 2");

        for (int i = 0; i < items.size(); i++) {
            // Sử dụng hằng chuỗi trước để tránh NullPointerException nếu items.get(i) là null
            if ("Item 1".equals(items.get(i))) {
                // LOGGER.info("Found Item 1 at index {}", i); // Tạm thời comment lại
                System.out.println("Found Item 1 at index " + i);
            }
        }
    }

    /**
     * Kiểm tra xem chuỗi đầu vào có khớp với một giá trị chuỗi cố định hay không.
     * Đã sửa lỗi so sánh chuỗi bằng == thành .equals().
     * @param input Chuỗi đầu vào để kiểm tra.
     * @return true nếu chuỗi khớp, false nếu không.
     */
    public boolean checkFixedString(String input) {
        String fixedValue = "VALID_STRING"; // Một chuỗi cố định để so sánh
        
        // Sửa lỗi: Sử dụng .equals() để so sánh nội dung chuỗi.
        // Gọi .equals() từ chuỗi hằng (fixedValue) để tránh NullPointerException nếu 'input' là null.
        if (fixedValue.equals(input)) { // ĐÃ SỬA
            System.out.println("Input matches fixed value (checked with .equals()).");
            return true;
        }
      

        System.out.println("Input does not match fixed value (checked with .equals()).");
        return false;
    }

    // Phương thức main để kiểm tra
    public static void main(String[] args) {
        app myApp = new app();

        System.out.println("--- Testing printWelcomeMessage ---");
        myApp.printWelcomeMessage("Student");
        myApp.printWelcomeMessage(null);

        System.out.println("\n--- Testing addNumbers ---");
        int sum = myApp.addNumbers(15, 20);
        System.out.println("Sum of 15 and 20 is: " + sum);

        System.out.println("\n--- Testing processList ---");
        myApp.processList();

        System.out.println("\n--- Testing checkFixedString (Đã sửa lỗi so sánh) ---");
        String testStr1 = "VALID_STRING";
        String testStr2 = new String("VALID_STRING"); // Tạo đối tượng String mới có cùng nội dung
        String testStr3 = "ANOTHER_STRING";
        String nullStr = null;

        System.out.print("Checking \"" + testStr1 + "\": ");
        myApp.checkFixedString(testStr1); // Mong đợi: true

        System.out.print("Checking new String(\"" + testStr2 + "\"): ");
        myApp.checkFixedString(testStr2); // Mong đợi: true (sau khi sửa bằng .equals())

        System.out.print("Checking \"" + testStr3 + "\": ");
        myApp.checkFixedString(testStr3); // Mong đợi: false
        
        System.out.print("Checking null string: ");
        myApp.checkFixedString(nullStr); // Mong đợi: false (vì fixedValue.equals(null) là false)
    }
}