package com.erickjesus.workshopmongo.dto;

import java.util.Date;

public class CommentDTO {
    private String text;
    private Date moment;

    private AuthorDTO authorDTO;

    public CommentDTO() {
    }

    public CommentDTO(String text, Date moment, AuthorDTO authorDTO) {
        this.text = text;
        this.moment = moment;
        this.authorDTO = authorDTO;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }
}
