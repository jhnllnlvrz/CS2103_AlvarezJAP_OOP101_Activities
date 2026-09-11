import java.util.Scanner;

class Canteen {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double[] prices = {80.00, 120.00, 100.00, 70.00, 90.00};

        int totalQuantity = 0;
        double totalAmount = 0;
        double totalDeduction = 0;
        
        System.out.println("====    M E N U    ====");
        System.out.println("1. Burger       - $80.00");
        System.out.println("2. Matcha       - $120.00");
        System.out.println("3. Pasta        - $100.00");
        System.out.println("4. Chicken      - $70.00");
        System.out.println("5. Pizza        - $90.00");

        char orderAgain = 'Y';
        while(orderAgain == 'Y' || orderAgain == 'y'){
            System.out.println();
            System.out.print("Enter item number: ");
            int itemNumber = scanner.nextInt();
            System.out.print("Enter quantity:  ");
            int quantity = scanner.nextInt();
    

            if (itemNumber < 1 || itemNumber > 5 || quantity < 1 || quantity > 10) {
                System.out.println();
                System.out.println("Invalid order! Please enter a valid item and quantity.");
                System.out.println();

                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next().charAt(0);
                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            char student = scanner.next().charAt(0);
            System.out.println();

            //compute subtotal value
            double subtotal = prices[itemNumber - 1] * quantity;
            
            //compute discount price
            double discountRate = 0;
            if((student == 'Y' || student == 'y') && subtotal >= 500){
                discountRate = 0.15;
            } else if(student == 'Y' || student == 'y'){
                discountRate = 0.10;
            } else if(subtotal >= 500){
                discountRate = 0.05;
            }

            double discount = subtotal*discountRate;
            double orderTotal = subtotal-discount;

            totalQuantity+=quantity;
            totalAmount+=subtotal;
            totalDeduction+=discount;

            System.out.printf("Subtotal: $%.2f%n", subtotal);
            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf("Order total: $%.2f%n", orderTotal);
            System.out.println();

            System.out.print("Do you want to order again? (Y/N): ");
            orderAgain = scanner.next().charAt(0);        
}
            //compute final amount
            double finalAmount = totalAmount - totalDeduction;

            System.out.println();
            System.out.println("==== ORDER SUMMARY ====");
            System.out.println("Total items: " + totalQuantity);
            System.out.printf("Total before discount: $%.2f%n", totalAmount);
            System.out.printf("Total discount: $%.2f%n", totalDeduction);
            System.out.printf("Final amount: $%.2f%n", finalAmount);
            System.out.println("Thank you for ordering!");

            scanner.close();

    }
}
