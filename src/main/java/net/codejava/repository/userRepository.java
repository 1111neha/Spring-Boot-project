package net.codejava.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.codejava.model.user;

@Repository
public interface userRepository extends JpaRepository<user, Long>
{

	
} 





