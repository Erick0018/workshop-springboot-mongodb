package com.erickjesus.workshopmongo.services;

import com.erickjesus.workshopmongo.domain.User;
import com.erickjesus.workshopmongo.dto.UserDTO;
import com.erickjesus.workshopmongo.repository.UserRepository;
import com.erickjesus.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findALL() {
        return repo.findAll();
    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

   public void delete(String id) {
        findById(id);
        repo.deleteById(id);
   }

   public User update(User obj) {
       User newObj = new User();
       updateData(newObj, obj);
       return repo.save(newObj);
   }

    public void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
   }

}
