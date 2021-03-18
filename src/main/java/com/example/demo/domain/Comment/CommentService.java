package com.example.demo.domain.Comment;

import java.util.Date;
import java.util.UUID;

import com.example.demo.dto.CommentDTO.CommentDTO;
import com.example.demo.dto.CommentDTO.CreateCommentDTO;

public class CommentService {
    public static Comment create(CreateCommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.id = UUID.randomUUID();
        comment.SetDate(new Date());
        comment.text = commentDTO.text;
        comment.rating = commentDTO.rating;
        return comment;
    }

    public static CommentDTO createDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.id = comment.id;
        commentDTO.text = comment.text;
        commentDTO.rating = comment.rating;
        commentDTO.date = comment.getDate();
        return commentDTO;
    }

}
