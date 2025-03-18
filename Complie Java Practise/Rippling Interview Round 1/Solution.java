
/**
Food delivery companies employ tens of thousands of delivery drivers who each submit hundreds of deliveries per week.
Delivery details are automatically sent to the system immediately after the delivery.

Delivery drivers have different hourly payment rates, depending on their performance.
Drivers can take on, and be paid for, multiple deliveries simultaneously.

If a driver is paid $10.00 per hour, and a delivery takes 1 hour and 30 minutes, the driver is paid $15.00 for that delivery.

We are building a dashboard to show a single number - the total cost of all deliveries - on screens in the accounting department offices.

At first, we want the following functions:

* `addDriver(driverId [integer], usdHourlyRate [float])`
   - The given driver will not already be in the system

* `recordDelivery(driverId [integer], startTime, endTime)`
   - Discuss the time format you choose
   - Times require minimum one-second precision
   - The given driver will already be in the system
   - All deliveries will be recorded immediately after the delivery is completed

* `getTotalCost()`
   - Return the total, aggregated cost of all drivers' deliveries recorded in the system
   - For example, return 135.30 if one driver is in the system and has a total cost of 100.30 USD and another driver is in the system and has a total cost of 35.00 USD.
   - This will be used for a live dashboard
   - Do not worry about exact formatting

All inputs will be valid.

Share any decisions or assumptions you make.
If you do anything differently in this interview than you would in production, share that.

Before coding, let's discuss how you will store the time data and why.

We want to see good OOP practices.
You may look up syntax using a search engine.
-----

The analytics team uses the live dashboard reporting function you built to see how much money is owed in total to all drivers.

Add the following functions:
* `payUpTo (payTime [integer, Unix time from epoch])`
   - Pay all drivers for recorded deliveries which ended up to and including the given time
* `getTotalCostUnpaid()`
   - Return the total, aggregated cost of all drivers' deliveries which have not been paid
The solution does not need to be thread-safe or handle concurrency.


Test case:
deliveryDashboard.addDriver(1, 35.10);
deliveryDashboard.addDriver(2, 15.15);
deliveryDashboard.addDriver(3, 8.55);
deliveryDashboard.addDriver(4, 11.28);

deliveryDashboard.recordDelivery(1, 5460, 9060);  // Jan 1 1970 01:31:00 - Jan 1 1970 02:31:00
deliveryDashboard.recordDelivery(2, 5700, 11100);  // Jan 1 1970 01:35:00 - Jan 1 1970 03:05:00
deliveryDashboard.recordDelivery(2, 11100, 12900);  // Jan 1 1970 03:05:00 - Jan 1 1970 03:35:00

System.out.println(deliveryDashboard.getTotalCost());


deliveryDashboard.payUpto(9061)  # Jan 1 1970 02:31:01, one second after the first delivery
print(billing_system.get_total_cost_unpaid())
print(billing_system.get_total_cost())


*/



import java.io.*;
import java.util.*;
import java.lang.*;


public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        DeliveryDashboard deliveryDashboard = new DeliveryDashboard();

        // deliveryDashboard.addDriver(1,(float)1);
        // deliveryDashboard.addDriver(2,(float)2);

        // deliveryDashboard.recordDelivery(1, 0L, 3600000L);  // 1 hour, Rate 1   > 1
        // deliveryDashboard.recordDelivery(2, 0L, 1800000L);  // 0.5 hours, Rate 2 > 1

        // deliveryDashboard.getTotalCost();

        deliveryDashboard.addDriver(1, (float)35.10);
        deliveryDashboard.addDriver(2, (float)15.15);
        deliveryDashboard.addDriver(3, (float)8.55);
        deliveryDashboard.addDriver(4, (float)11.28);

        deliveryDashboard.recordDelivery(1, 5460000L, 9060000L);  // Jan 1 1970 01:31:00 - Jan 1 1970 02:31:00
        deliveryDashboard.recordDelivery(2, 5700000L, 11100000L);  // Jan 1 1970 01:35:00 - Jan 1 1970 03:05:00
        deliveryDashboard.recordDelivery(2, 11100000L, 12900000L);  // Jan 1 1970 03:05:00 - Jan 1 1970 03:35:00

        deliveryDashboard.getTotalCost();


        deliveryDashboard.payUpto(9061000L);  // # Jan 1 1970 02:31:01, one second after the first delivery
        deliveryDashboard.getTotalCostUnpaid();
        deliveryDashboard.getTotalCost();

    }
}
