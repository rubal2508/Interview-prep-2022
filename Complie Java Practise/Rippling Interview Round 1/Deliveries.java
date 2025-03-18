import java.io.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import java.math.*;


public class Deliveries{
    Integer driverId;
    Long startTimeStamp;
    Long endTimeStamp;
    Boolean isSettled;

    public Deliveries(Integer driverId, Long startTimeStamp, Long endTimeStamp){
        this.driverId = driverId;
        this.startTimeStamp = startTimeStamp;
        this.endTimeStamp = endTimeStamp;
        isSettled = false;
    }


}