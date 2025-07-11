package com.erickjesus.workshopmongo.services;

import com.erickjesus.workshopmongo.domain.Post;
import com.erickjesus.workshopmongo.repository.PostRepository;
import com.erickjesus.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Id não encontrado!"));
    }
}
