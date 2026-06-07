package dev.CheckIn.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import dev.CheckIn.Models.CheckInModel;
import dev.CheckIn.Service.CheckInService;
import dev.Err.Response.ErroResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
class CheckInController {
    @PostMapping("/check-in/{id}")
    public ResponseEntity<String> checkInByIdLocalTuristico(@PathVariable long Id_, CheckInModel checkInModel) {
        try {
            CheckInService.AddVisitByLocalTuristico(checkInModel, Id_);
            return ResponseEntity.status(HttpStatus.CREATED).body("Check-in criado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErroResponse(500, e.getMessage()).toString());
        }
    }
}
