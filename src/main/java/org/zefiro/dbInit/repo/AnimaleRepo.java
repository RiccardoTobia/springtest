package org.zefiro.dbInit.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zefiro.dbInit.models.Animale;

public interface AnimaleRepo extends JpaRepository<Animale, Long>{

	public Optional<Animale> findByNome(String name);
}
