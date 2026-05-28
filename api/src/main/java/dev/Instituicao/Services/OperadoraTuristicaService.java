package dev.Instituicao.Services;

import dev.Instituicao.Entity.OperadoraTuristicaEntity;
import dev.Instituicao.Repository.OperadoraTuristicaRepository;
import dev.Instituicao.Repository.Interface.IOperadoraTuristicaRepository;
import dev.Instituicao.Services.Interfaces.IOperadoraTuristicaService;

import java.time.LocalDate;
import java.util.List;

import org.springframework.util.StringUtils;

public class OperadoraTuristicaService implements IOperadoraTuristicaService{
    private final OperadoraTuristicaRepository operadoraTuristicaRepository = new OperadoraTuristicaRepository();
    @Override
    public String DeleteOperadoraTuristicaById(String PId) {
        if (!StringUtils.hasText(PId)) {
            try {
                operadoraTuristicaRepository.Delete(PId);
                return "Sucess";
            } catch (Exception e) {
                return "Erro: "+ e;
            }
        }
        return "Erro: O id esta nullo";
        
    }
    @Override
    public String UpdateOperadoraTuristicaById(OperadoraTuristicaEntity POperadoraTuristica, String PId) {
        if (!POperadoraTuristica.equals(null) || StringUtils.hasText(PId)) {
            try {
            operadoraTuristicaRepository.Update(PId, POperadoraTuristica);
                
            } catch (Exception e) {
                return "Erro: "+e.toString();
            }
        }
        else{
            return "Erro: O objeto ou o id esta vazio";
        }
        return null;
    }
    @Override
    public String CreateOperadoraTuristica(OperadoraTuristicaEntity POperadoraTuristica) {
        
        if (!POperadoraTuristica.equals(null)) {
            try {
                operadoraTuristicaRepository.Save();
                return "Sucess";
                
            } catch (Exception e) {
                return "Erro: "+e;
            }
        } else {
            return "Erro: objeto nullo";
        }
        
    }
    @Override
    public OperadoraTuristicaEntity ReadOperadoraTuristicaById(String Pid) {
         OperadoraTuristicaEntity operadora= OperadoraTuristicaEntity.builder()
            .NomeUser("")
            .NomeInstituicao("")
            .Cnpj("")
            .Senha("")
            .Login("")
            .DataCriacao(null)
            .PolosVisitacoes(List.of()) 
            .build();

        if (!StringUtils.hasText(Pid)) {
            
            try {            
                
                if (!operadoraTuristicaRepository.Get(Pid).equals(null)) {
                    operadora = operadoraTuristicaRepository.Get(Pid);
                }
            } 
            catch(Exception err){
                operadora.setNomeUser(err.toString());
                operadora.setNomeInstituicao(err.toString());
                operadora.setDataCriacao(LocalDate.now());
            }
            finally{
                return operadora;
            }
            
        }
        else{
            return operadora;
        }

        
    }
}
