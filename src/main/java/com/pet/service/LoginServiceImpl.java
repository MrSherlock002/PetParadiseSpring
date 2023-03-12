package com.pet.service;

import com.pet.entities.User;
import com.pet.exception.InvalidCredentialsException;
import com.pet.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public User login(User user) throws InvalidCredentialsException {
        Optional<User> opt = userRepository.findByUserName(user.getUserName());

        if(!opt.isPresent()) {
            throw new InvalidCredentialsException("Invalid Credentials");
        }

        User dbUser = opt.get();
        System.out.println(user);
        System.out.println(dbUser);
        User newUser = new User();

        if(dbUser.getCustomer() != null && (user.getUserType().equals("CUSTOMER") ||  user.getUserType().equals("ADMIN"))){
            if(user.getUserName().equals(dbUser.getUserName()) && user.getCustomer().getCustomerPassword().equals(dbUser.getCustomer().getCustomerPassword())) {
                newUser.setUserId(dbUser.getUserId());
                newUser.setUserName(dbUser.getUserName());
                newUser.setUserType(dbUser.getUserType());
                newUser.setCustomer(dbUser.getCustomer());

                return newUser;
            } else {
                throw new InvalidCredentialsException("Invalid credentials");
            }
        } else {
                throw new InvalidCredentialsException("Invalid credentials");
        }
    }

    @Override
    public User logout(User user) {
        user = null;
        return new User();
    }
}
