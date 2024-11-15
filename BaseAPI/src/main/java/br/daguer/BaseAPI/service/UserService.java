package br.daguer.BaseAPI.service;

import br.daguer.BaseAPI.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

}
