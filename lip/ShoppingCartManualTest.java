package lip;
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); 
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }
        // Test 4; คำนวณโดยมีการแถม ต้องมีโค้ด BOGO
        ArrayList<CartItem> X1 = new ArrayList<>();
        X1.add(new CartItem("BOGO","ครีมทาตัว", 120, 2));
        X1.add(new CartItem("BOGO", "มาม่า", 6, 2)); 
        double total4 = ShoppingCartCalculator.calculateTotalPrice(X1);
        if(total4 ==  126.0){
           System.out.println("PASSED : x1 total is correct (126.0)");
           passedCount++;
        }else{
            System.out.println("FAILED X1 total expected 126.0 but got " + total4);
            failedCount++;
        }
        // Test 5; คำนวณโดยที่ซื้อมากกว่า 6 ชิ้นมีส้วนลด
        ArrayList<CartItem> X2 = new ArrayList<>();
        X2.add(new CartItem("BULK", "มาม่า", 6, 7)); 
        X2.add(new CartItem("BULK", "ลูกอม", 2, 8)); 
        double total5 = ShoppingCartCalculator.calculateTotalPrice(X2);
        if(total5 == 52.2){
            System.out.println("PASSED : X2 total is correct (52.2)");
            passedCount++;
        }else{
            System.out.println("FAILED X1 total expected 52.2 but got " + total5);
            failedCount++;
        }
        // Test 6; มีทั้งแถม กัยส่วนลด
        ArrayList<CartItem> X3 = new ArrayList<>();
        X3.add(new CartItem("BOGO","ครีมทาตัว", 120, 2)); 
        X3.add(new CartItem("BULK", "มาม่า", 6, 7)); 
        double total6 = ShoppingCartCalculator.calculateTotalPrice(X3);
        if (total6 == 157.8) {
            System.out.println("PASSED : X3 total is correct (157.8)");
            passedCount++;
            }else {
                System.out.println("FAILED X3 total expected 157.8 but got " + total6);
                failedCount++;
            }

            // --- Test Summary 
     
            System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}