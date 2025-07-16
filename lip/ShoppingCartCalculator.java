package lip;

import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เมธอดนี้จะทำการตรวจสอบสิ้นค้าภายในกระตร้า โดยในกระตร้าสามารถมีได้มากกว่าหนึ่งชิ้นสินค้าแต่ละตัวจะมรโค้ดที่แตกต่างกัน
     * เพื่อเอามาใช่คิดโปรโมชั่นของสินค้านั่นๆ โดยที่จะมีราคาพื้นฐานคือ ราคาสินค้า * จำนวนสินค้า 
     * -จะมีโปรโมชั่น ซื้อ1แถม1 โดยตัวสินค้าจะมีโค้ด BOGO เพื่อเข้ารหัสในการเอาโปรดมชั่นนี้
     * -ส่วนลดเมื่อซื้อเยอะ (6ชิ้นขึ้นไป) โดยจะมีการเข้ารหัส BULK เพื่อเอาส่วนลด
     * @param items คือจำนวนสินค้าที่ซื้อ ในกระตร้า
     * @return ราคาสินค้า เมื่อคำนวณผ่านโปรโมชั่นแล้ว
     *  
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        if (items == null || items.isEmpty()) {
            return 0.0;
        }
    
        double total = 0.0;
    
        for (CartItem item : items) {
            double itemTotal = 0.0;
            String type = item.sku().toUpperCase();
            double price = item.price();
            int quantity = item.quantity();
    
            switch (type) {
                case "BOGO":
                    
                    int chargeableQty = (quantity / 2) + (quantity % 2);
                    itemTotal = chargeableQty * price;
                    break;
    
                case "BULK":
                    itemTotal = price * quantity;
                    if (quantity > 6) {
                        itemTotal *= 0.9; /
                    }
                    break;
    
                case "NORMAL":
                default:
                    itemTotal = price * quantity;
                    break;
            }
    
            total += itemTotal;
        }
    
        return total;
    }
    
}