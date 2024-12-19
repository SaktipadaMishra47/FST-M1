package Day2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    public List<String> passengers;
    public int maxPassengers;
    public Date lastTimeTookOf;
    public Date lastTimeLanded;
    
    public Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void onboard(String passenger) {
        this.passengers.add(passenger);
    }

    public Date takeOff() {
        Date lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }

    public void land() {
        this.passengers.clear();
    }

    public Date getLastTimeLanded() {
    	Date lastTimeLanded = new Date();
        return lastTimeLanded;
     }

    public List<String> getPassengers() {
        return passengers;
    }
}
public class Activity6 {

    public static void main(String[] args) throws InterruptedException {
        //There is a plane with max 10 passengers
        Plane plane = new Plane(10);
        //Add passengers on the list
        plane.onboard("Ram");
        plane.onboard("Laksha");
        plane.onboard("Sita");
        plane.onboard("Rama");
        plane.onboard("Lakshaa");
        plane.onboard("Sitaa");
        plane.onboard("Rahim");
        plane.onboard("Lukky");
        plane.onboard("Sima");
        plane.onboard("Gita");
        //Plane takes off
        System.out.println("Plane took off at: " + plane.takeOff());
        //Print list of people on board
        System.out.println("People on the plane: " + plane.getPassengers());
        //Flying.....
        Thread.sleep(5000);
        //Plane has landed
        plane.land();
        //Plane lands
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }
}
    
