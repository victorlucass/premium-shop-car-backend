package com.premiumshopcarbackend.services;

import com.premiumshopcarbackend.DTO.UserDTO;
import com.premiumshopcarbackend.entities.User;
import com.premiumshopcarbackend.repositories.UserRepository;
import com.premiumshopcarbackend.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements BaseResourceService<User, UserDTO>{

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(Integer id) {
        Optional<User> userSelect = repo.findById(id);
        return userSelect.orElseThrow(
                () -> new ObjectNotFoundException("Usuário não encontrado! Talvez o id " + id + " não exista."));
    }

    @Override
    public User save(UserDTO dto) {
        User user = fromObject(dto, new User());
        user.setId(null);
        if (repo.findByEmail(dto.getEmail()) != null){
            throw new ObjectNotFoundException("Email já cadastrado");
        }
        return repo.save(user);
    }

    @Override
    public User update(UserDTO dto) {
        User user = findById(dto.getId());
        User email = repo.findByEmail(dto.getEmail());
        if (email != null && !(email.getId().equals(dto.getId()))){
            throw new ObjectNotFoundException("Email já cadastrado");
        }
        fromObject(dto, user);
        return repo.save(user);
    }

    @Override
    public void delete(Integer id) {
        User userDelete = findById(id);
        repo.delete(userDelete);
    }

    public User fromObject(UserDTO dto, User user){
        user.setId(dto.getId());
        user.setNome((dto.getNome() == null) ? user.getNome() : dto.getNome());
        user.setEmail((dto.getEmail() == null) ? user.getEmail() : dto.getEmail());
        user.setSenha((dto.getSenha() == null) ? user.getSenha() : dto.getSenha());
        return user;
    }


}
