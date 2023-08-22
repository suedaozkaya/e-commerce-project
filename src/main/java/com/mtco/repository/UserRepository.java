package com.mtco.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtco.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	boolean existsByEmail(String email);

	// User Role ilişkisi default olarak LAZY tanımlıydı, 
	// @EntityGraph ile EAGER yapıldı (repodayken yapmak daha iyiymiş)
	@EntityGraph(attributePaths = "roles")
	Optional<User> findByEmail(String email);

	@EntityGraph(attributePaths = "roles")
	List<User> findAll();
	
	@EntityGraph(attributePaths = "roles")
	Optional<User> findById(Long id);
}
