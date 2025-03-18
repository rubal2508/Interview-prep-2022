import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import java.math.*;


public class DeliveryDashboard{
    
    HashMap<Integer,Float> driverRates;
    List<Deliveries> deliveries;
    
    public DeliveryDashboard(){
        driverRates = new HashMap<>();
        deliveries = new ArrayList<>();
    }

    public void addDriver(Integer driverId, Float rate){
        // Handle the case if driver is already present 
        driverRates.put(driverId, rate);
    }
    
    public void recordDelivery(Integer driverId, Long startTimeStamp, Long endTimeStamp){ // timstamp in milliseconds
        deliveries.add(new Deliveries(driverId, startTimeStamp, endTimeStamp));
    }

    public Float getTotalCost(){
        Float totalCost = (float)0.0;

        // for(Deliveries delivery : deliveries){
        //     System.out.println(delivery.driverId + " " + (delivery.endTimeStamp - delivery.startTimeStamp)/3600000L);
        // }

        for(Deliveries delivery : deliveries){
            totalCost += calculateDeliveryCost(delivery);
        }

        System.out.println("Total Cost: " + totalCost);
        return totalCost;
    }

    public void payUpto(Long cutOffTimeStamp){
        for(Deliveries delivery : deliveries){
            if(delivery.endTimeStamp <= cutOffTimeStamp){
                settleDelivery(delivery);
            }
        }
    }

    public Float getTotalCostUnpaid(){
        Float totalCost = (float)0.0;

        for(Deliveries delivery : deliveries){
            if(!delivery.isSettled){
                totalCost += calculateDeliveryCost(delivery);
            }
        }
        System.out.println("Total Unpaid Cost: " + totalCost);
        return totalCost;
    }

    public void settleDelivery(Deliveries delivery){
        // what if the delivery is already settled?
        delivery.isSettled = true;
        // other payment functions
    }

    public float calculateDeliveryCost(Deliveries delivery){
        Float deliveryRate = driverRates.get(delivery.driverId);
        Long deliveryDurationInMilliseconds = delivery.endTimeStamp - delivery.startTimeStamp;
        Float deliveryDurationInHours = (float) deliveryDurationInMilliseconds / (float)3600000;
        return deliveryDurationInHours * deliveryRate ;
    }
}

