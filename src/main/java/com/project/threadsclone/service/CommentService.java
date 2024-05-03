package com.project.threadsclone.service;

import com.project.threadsclone.dto.CommentDto;
import com.project.threadsclone.dto.converter.CommentDtoConverter;
import com.project.threadsclone.dto.request.CreateCommentRequest;
import com.project.threadsclone.dto.request.UpdateCommentRequest;
import com.project.threadsclone.exception.CommentNotFoundException;
import com.project.threadsclone.model.Comment;
import com.project.threadsclone.model.Post;
import com.project.threadsclone.model.User;
import com.project.threadsclone.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentDtoConverter commentDtoConverter;
    private final PostService postService;
    private final UserService userService;

    public CommentService(CommentRepository commentRepository, CommentDtoConverter commentDtoConverter, PostService postService, UserService userService) {
        this.commentRepository = commentRepository;
        this.commentDtoConverter = commentDtoConverter;
        this.postService = postService;
        this.userService = userService;
    }

    public CommentDto createComment(CreateCommentRequest createCommentRequest) {
        Post post = postService.findPostById(createCommentRequest.getPostId());
        User user = userService.findUserById(createCommentRequest.getUserId());
        Comment comment = new Comment(post, user, createCommentRequest.getComment(),
                LocalDateTime.now());

        return commentDtoConverter.convert(commentRepository.save(comment));
    }

    public CommentDto updateComment(UpdateCommentRequest updateCommentRequest, Long id) {
        Comment comment = findCommentById(id);

        comment.setComment(updateCommentRequest.getComment());

        return commentDtoConverter.convert(commentRepository.save(comment));
    }

    public void deleteComment(Long id) {
        findCommentById(id);
        commentRepository.deleteById(id);
    }

    protected Comment findCommentById(Long id){
        return commentRepository.findById(id).orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + id));
    }
}
