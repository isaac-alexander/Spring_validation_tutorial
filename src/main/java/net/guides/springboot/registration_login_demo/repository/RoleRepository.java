package net.guides.springboot.registration_login_demo.repository;

import net.guides.springboot.registration_login_demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}

//  The JpaRepository interface provides several methods for performing
//  CRUD (Create, Read, Update, Delete) operations on a JPA entity.
//  It takes two type parameters: the entity type, Role,
//  and the type of the entity's primary key, Long.