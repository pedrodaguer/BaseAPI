package br.daguer.BaseAPI.service.impl;

import br.daguer.BaseAPI.domain.model.User;
import br.daguer.BaseAPI.repository.UserRepository;
import br.daguer.BaseAPI.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate.getId() == null) {
            throw new IllegalArgumentException("User Id cannot be null!");
        }
        if (userRepository.existsById(userToCreate.getId())) {
            throw new IllegalArgumentException("This user Id already exists!");
        }
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists!");
        }
        else {
            return userRepository.save(userToCreate);
        }
    }
}
