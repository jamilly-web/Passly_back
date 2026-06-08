package dev.Instituicao.Services;

import dev.Instituicao.Entity.OperadoraTuristicaEntity;
import dev.Instituicao.Repository.Interface.IOperadoraTuristicaRepository;
import dev.Instituicao.Services.Interfaces.IOperadoraTuristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class OperadoraTuristicaService implements IOperadoraTuristicaService {
    private final IOperadoraTuristicaRepository _operadoraTuristicaRepository;

    @Autowired
    public OperadoraTuristicaService(IOperadoraTuristicaRepository operadoraTuristicaRepository) {
        this._operadoraTuristicaRepository = operadoraTuristicaRepository;
    }

    @Override
    public String DeleteOperadoraTuristicaById(Long PId) {
        
            try {
                _operadoraTuristicaRepository.deleteById(PId);
                return "Sucess";
            } catch (Exception e) {
                return "Erro: " + e;
            }
    }

    @Override
    public String UpdateOperadoraTuristicaById(OperadoraTuristicaEntity POperadoraTuristica, Long PId) {
        if (POperadoraTuristica != null && PId != null) {
            try {
                OperadoraTuristicaEntity operadoraTuristicaAtualizada = new OperadoraTuristicaEntity();
                operadoraTuristicaAtualizada.setId(PId);
                // Copiar propriedades do parâmetro para o novo objeto
                operadoraTuristicaAtualizada = POperadoraTuristica;
                operadoraTuristicaAtualizada.setId(PId);
                _operadoraTuristicaRepository.save(operadoraTuristicaAtualizada);
                return "Sucess";
            } catch (Exception e) {
                return "Erro: " + e.toString();
            }
        } else {
            return "Erro: O objeto ou o id esta vazio";
        }
    }
    @Override
    public String CreateOperadoraTuristica(OperadoraTuristicaEntity POperadoraTuristica) {
        if (POperadoraTuristica != null) {
            try {
                _operadoraTuristicaRepository.save(POperadoraTuristica);
                return "Sucess";
            } catch (Exception e) {
                return "Erro: " + e;
            }
        } else {
            return "Erro: objeto nullo";
        }
    }
    @Override
    public OperadoraTuristicaEntity ReadOperadoraTuristicaByLogin(String Login) {
        return _operadoraTuristicaRepository.findByLogin(Login).orElse(null);
        
    }
}
