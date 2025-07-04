package com.erickjesus.workshopmongo.resources;

import com.erickjesus.workshopmongo.domain.User;
import com.erickjesus.workshopmongo.dto.UserDTO;
import com.erickjesus.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findALL();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        UserDTO userDTO = new UserDTO(obj);
        return ResponseEntity.ok().body(userDTO);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.insert(service.fromDTO(objDto));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
