package br.daguer.BaseAPI.repository;

import br.daguer.BaseAPI.domain.model.Account;
import br.daguer.BaseAPI.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
