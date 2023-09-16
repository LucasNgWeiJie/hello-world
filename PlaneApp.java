package Lab6;
import java.util.Scanner;

public class PlaneApp{
    public static void main(String[] args){
        //print application interface
        System.out.println("(1) Show number of empty seats");
        System.out.println("(2) Show the list of empty seats");
        System.out.println("(3) Show the list of seat assignments by seat ID");
        System.out.println("(4) Show the list of seat assignments by customer ID");
        System.out.println("(5) Assign a customer to a seat");
        System.out.println("(6) Remove a seat assignment");
        System.out.println("(7) Exit");
        
        //create a plane object
        Plane plane = new Plane();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
        System.out.print("Enter the number of your choice: ");
        choice = sc.nextInt();
        switch(choice){
            case 1:{
                //show the number of empty seats
                plane.showNumEmptySeats();
                break;
            }
            case 2:{
                //show the list of empty seats
                plane.showEmptySeats();
                break;
            }
            case 3:{
                //show the list of customers together with their seat numbers in the order of the seat numbers
                plane.showAssignedSeat(true);
                break;
            }
            case 4:{
                //show the list of customers together with their seat numbers in the order of the customer id
                plane.showAssignedSeat(false);
                break;
            }
            case 5:{
                //Assign a customer to a seat
                System.out.println("Assigning seat...");
                System.out.print("Please enter SeatID: ");
                int seat_id = sc.nextInt();
                System.out.print("Please enter Customer ID: ");
                int customer_id = sc.nextInt();
                plane.assignSeat(seat_id, customer_id);
                break;
            }
            case 6:{
                //remove a seat assignment
                System.out.print("Enter seatID to unassign customer from: ");
                int seat_id = sc.nextInt();
                plane.unAssignSeat(seat_id);
                break;
            }
            default:{
                System.out.println("Exit plane app");
                break;
            }
        }
        }while(choice<7);
        sc.close();
    }
}