package Lab6;

/* Each PlaneSeat object should hold a seat
identification number (seatId), a marker (assigned) that indicates whether the seat is assigned and
the customer number (customerId) of the seat holder.*/

public class PlaneSeat{
    private int seatID;
    private boolean assigned;
    private int customerId;

    public PlaneSeat(int seat_id){
        this.seatID = seat_id;
        this.assigned = false;
    }
    public int getSeatID(){
        return this.seatID;
    }
    public int getCustomerID(){
        return this.customerId;
    }
    public boolean isOccupied(){
        return this.assigned;
    }
    public void assign(int cust_id){
        this.customerId = cust_id;
        this.assigned = true;
    }
    public void unAssign(){
        this.assigned = false;
    }
}