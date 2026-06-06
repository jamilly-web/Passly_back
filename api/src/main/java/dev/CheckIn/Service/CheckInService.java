package dev.CheckIn.Service;

import org.springframework.web.bind.annotation.RestController;

import dev.CheckIn.Models.CheckInModel;

@RestController
public class CheckInService {
    
    public static void AddVisitByLocalTuristico(CheckInModel checkInModel, String idString) {
        if(checkInModel != null && idString!= ""){
            // Add By Local Turistico 
            // Add By User 
        }
    }
}
