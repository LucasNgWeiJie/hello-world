package Lab6;

public class Plane{
    private PlaneSeat[] seatArray = new PlaneSeat[12];
    private int numEmptySeat;

    public Plane(){
        this.numEmptySeat = 12;
        for(int i=0;i<12;i++){
            seatArray[i] = new PlaneSeat(i+1);
        }
    }

    private PlaneSeat[] sortSeats(){
        //copy seat array
        PlaneSeat[] seatArray1 = new PlaneSeat[12];
        for(int i=0;i<12;i++){
            seatArray1[i] = this.seatArray[i];
        }
        for(int i=0;i<12;i++){
            for(int j=0;j<12-i-1;j++){
                if(seatArray1[j].getCustomerID() > seatArray1[j+1].getCustomerID()){
                    PlaneSeat temp = seatArray1[j];
                    seatArray1[j] = seatArray1[j+1];
                    seatArray1[j+1] = temp;
                }
            }
        }  
        return seatArray1;
    }

    public void showNumEmptySeats(){
        //displays number of empty seats
        System.out.println("There are "+numEmptySeat+" empty seats.");
    }

    public void showEmptySeats(){
        System.out.println("The following seats are empty:");
        for(int i=0;i<12;i++){
            if(seatArray[i].isOccupied() == false){
                System.out.println("SeatID " + seatArray[i].getSeatID());
            }
        }
    }

    public void showAssignedSeat(boolean bySeatId){
        //display the assigned seats with seat ID and customer ID
        System.out.println("The seat assignments are as follow:");
        if(bySeatId){
            //display order by seatid
            for(int i=0;i<12;i++){
                if(this.seatArray[i].isOccupied()) System.out.printf("SeatID %d assigned to CustomerID %d.\n", this.seatArray[i].getSeatID(), this.seatArray[i].getCustomerID());
            }
        }
        else{
            //display order by customerid
            PlaneSeat[] temp = sortSeats();
            for(int i=0;i<temp.length;i++){
                if(temp[i].isOccupied()) System.out.printf("SeatID %d assigned to CustomerID %d.\n", temp[i].getSeatID(), temp[i].getCustomerID());
            }

        }
    }

    public void assignSeat(int seatId, int cust_id){
        //assigns customer ID to seatId, if its empty
        for(int i=0;i<12;i++){
            if(this.seatArray[i].getSeatID() == seatId){
                if(this.seatArray[i].isOccupied()){
                    System.out.println("Seat already assigned to a customer.");
                    return;
                }
                else{
                    this.seatArray[i].assign(cust_id);
                    this.numEmptySeat--;
                    System.out.println("Seat Assigned!");
                    return;
                }
            }
        }

    }
    public void unAssignSeat(int seatId){
        //unassigns seat by seatid
        for(int i=0;i<12;i++){
            if(this.seatArray[i].getSeatID() == seatId && this.seatArray[i].isOccupied()){
                this.seatArray[i].unAssign();
                this.numEmptySeat++;
            }
        }
        System.out.println(("Seat unassigned!"));
    }
}
