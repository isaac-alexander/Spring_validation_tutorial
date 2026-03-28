package net.guides.springboot.registration_login_demo.repository;

import net.guides.springboot.registration_login_demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}

// The JpaRepository interface provides several methods for performing
// CRUD (Create, Read, Update, Delete) operations on a JPA entity.
// It takes two type parameters: the entity type, User,
// and the type of the entity's primary key, Long.