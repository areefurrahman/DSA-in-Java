import java.util.ArrayList;
import java.util.Scanner;

class Customer{
    private String name;
    private int seatNo;

    public Customer(String name, int seatNo) {
        this.name = name;
        this.seatNo = seatNo;
    }

    public void displayCustomer(){
        System.out.println("Name: " + name + "--->Seat number: " + (seatNo + 1));
    }

}


public class Task_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Customer> customers = new ArrayList<>();

        while (true) {
            System.out.println("\n1) Book Seat  2) Cancel Booking  3) Display Seats  4) Exit");

            switch (input.nextInt()) {
                case 1 -> {
                    input.nextLine();
                    System.out.print("Name: "); String name =  input.nextLine();
                    System.out.println(name);

                    if (customers.size()<10)
                    {
                        customers.add(new Customer(name,customers.size()));
                        System.out.println("Booked Successfully. Your Seat number is: " + customers.size());
                    }
                    else {
                        System.out.println("All Seat Booked");
                    }

                }
                case 2 -> {
                    System.out.print("Enter seat number to Cancel booking: ");
                    int seatNO = input.nextInt();
                    if (seatNO< customers.size()) {
                        customers.remove(seatNO);
                        System.out.println(seatNO + " number seat Cancel successfully.");
                    }
                    else
                        System.out.println("Invalid seat number");
                }
                case 3 -> {
                    if (customers.isEmpty()) System.out.println("No Customer found.");
                    for(Customer customer: customers){
                        customer.displayCustomer();
                    }
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Exiting...");
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
