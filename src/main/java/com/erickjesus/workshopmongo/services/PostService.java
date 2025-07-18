package com.erickjesus.workshopmongo.services;

import com.erickjesus.workshopmongo.domain.Post;
import com.erickjesus.workshopmongo.repository.PostRepository;
import com.erickjesus.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Id não encontrado!"));
    }

    public List<Post> findByTitle(String text) {
        return repository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return repository.fullSearch(text, minDate, maxDate);
    }
}
