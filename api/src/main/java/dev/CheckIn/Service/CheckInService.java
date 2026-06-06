package dev.CheckIn.Service;

import org.springframework.web.bind.annotation.RestController;

import dev.CheckIn.Models.CheckInModel;
import dev.CheckIn.Repository.CheckInRepository;

@RestController
public class CheckInService {
    static private CheckInRepository _checkInRepository = new CheckInRepository();

    public static boolean AddVisitByLocalTuristico(CheckInModel checkInModel, long idString) {
        if (checkInModel == null || idString <= 0) {
            throw new IllegalArgumentException("CheckInModel inválido ou id inválido");
        }

        try {
            boolean successLocal = _checkInRepository.AddVisitByLocalTuristico();
            boolean successTurista = _checkInRepository.AddVisitInTurista();

            if (!successLocal || !successTurista) {
                throw new RuntimeException("Falha ao adicionar visita no repositório");
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar check-in: " + e.getMessage(), e);
        }
    }
}
