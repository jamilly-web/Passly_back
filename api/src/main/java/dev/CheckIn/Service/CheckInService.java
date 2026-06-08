package dev.CheckIn.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import dev.CheckIn.Models.CheckInModel;
import dev.Client.Entity.TuristaEntity;
import dev.Client.Entity.VisitacoesEntityByTurista;
import dev.Client.Repository.IVisitacoesRepositoryByTurist;
import dev.Client.Repository.TuristaRepository;
import dev.Instituicao.Entity.LocalTuristicoEntity;
import dev.Instituicao.Entity.VisitacaoEntity;
import dev.Instituicao.Repository.Interface.ILocalTuristicoRepository;
import dev.Instituicao.Repository.Interface.IVisitacoesRepository;

@RestController
public class CheckInService {
    static ILocalTuristicoRepository ILocalTuristicoRepository;
    static TuristaRepository TuristaRepository;
    static IVisitacoesRepository iVisitacoesRepository;
    static IVisitacoesRepositoryByTurist iVisitacoesRepositoryByTurist;
    public void CheckIn(
        Long IdLocal, 
        long IdUser,
        CheckInModel heckInModel
    ){
        LocalTuristicoEntity localTuristicoEntity = ILocalTuristicoRepository.findById(IdLocal).orElse(null);
        TuristaEntity turista = TuristaRepository.findById(IdUser).orElse(null);
        String LatitudeByUser = heckInModel.getLatitude();
        String  LatitudeByLocal= localTuristicoEntity.getLatitude().toString();
        String LongitudeByUser = heckInModel.getLongitude().toString();
        String LongitudeByLocal =  localTuristicoEntity.getLongitude().toString();
        
        if (LatitudeByLocal == LatitudeByUser && LongitudeByLocal == LongitudeByUser) {
        VisitacaoEntity visitacaoLocal = VisitacaoEntity.builder()
        .notaVisitacao(heckInModel.getNota())
        .localTuristico(localTuristicoEntity)
        .build();
        iVisitacoesRepository.save(visitacaoLocal);


            // 3. Cria a Visitação no schema turista
    VisitacoesEntityByTurista visitacaoTurista = VisitacoesEntityByTurista.builder()
        .dataVisita(LocalDateTime.now())
        .notaAvaliacao((short) 5)
        .localVisitado(localTuristicoEntity.getNucleoNome())
        .duracaoVisita(Duration.ofHours(1))
        .comentario(heckInModel.getComentario())
        .turista(turista)
        .build();

    iVisitacoesRepositoryByTurist.save(visitacaoTurista);
        




        }
    }
    
}
