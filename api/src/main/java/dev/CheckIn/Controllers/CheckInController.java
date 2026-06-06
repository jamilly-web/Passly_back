package dev.CheckIn.Controllers;

import org.springframework.web.bind.annotation.RestController;
import dev.CheckIn.Models.CheckInModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
class CheckInController {

    @RequestMapping("/check-in/{id}")
    public String checkInByIdLocalTuristico (@PathVariable  String Id_, CheckInModel checkInModel) {
        return "";
    }
    
    
}