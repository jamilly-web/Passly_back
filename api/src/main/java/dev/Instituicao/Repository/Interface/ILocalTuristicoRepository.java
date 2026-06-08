package dev.Instituicao.Repository.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.Instituicao.Entity.LocalTuristicoEntity;
import dev.Instituicao.Entity.VisitacaoEntity;

public interface ILocalTuristicoRepository extends JpaRepository<LocalTuristicoEntity, Long> {
    @Query(value = """
    SELECT * FROM passly.visitacao
    WHERE id = :idLocal
    """, nativeQuery = true)
List<VisitacaoEntity> findVisitacoesByLocalId(@Param("idLocal") Long idLocal);
}