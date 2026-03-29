package net.guides.springboot.registration_login_demo.service.impl;

import net.guides.springboot.registration_login_demo.dto.UserDto;
import net.guides.springboot.registration_login_demo.entity.Role;
import net.guides.springboot.registration_login_demo.entity.User;
import net.guides.springboot.registration_login_demo.repository.RoleRepository;
import net.guides.springboot.registration_login_demo.repository.UserRepository;
import net.guides.springboot.registration_login_demo.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }



    //This method creates a new User Entity and saves it to the database.
    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null) {
            role = checkRoleExist();
        }

        user.setRoles(List.of(role));
        userRepository.save(user);

    }

    // This method finds a user in the database by their email address.
    // It takes an email address as input and returns the corresponding User entity
    // if it exists.
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);

    }

    // This method retrieves a list of all users from the database
    // and maps each User entity to a UserDto object, which contains
    // only the user's name and email address.
    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist() {
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
