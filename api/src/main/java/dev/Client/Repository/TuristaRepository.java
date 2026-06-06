package com.passly.passly.repository;

import com.passly.passly.entity.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TuristaRepository extends JpaRepository<Turista, Long> {

    Optional<Turista> findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}