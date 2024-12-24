package com.crud.crud.services;

import com.crud.crud.models.Users;
import com.crud.crud.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class UsersServiceImpl implements UserDetailsService, UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with email '%s' not found", email)));

    }

    @Override
    public Users registerUser(Users users) {
        boolean isUserExist = usersRepository.findByEmail(users.getEmail()).isPresent();
        if(isUserExist){
            throw  new RuntimeException(String.format("User with email '%s' already exist", users.getEmail()));
        }

        String encodePassword = bCryptPasswordEncoder.encode(users.getPassword());
        users.setPassword(encodePassword);
        return usersRepository.save(users);
    }

}
