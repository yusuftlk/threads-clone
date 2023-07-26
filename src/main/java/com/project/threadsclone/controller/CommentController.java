package com.project.threadsclone.controller;

import com.project.threadsclone.dto.CommentDto;
import com.project.threadsclone.dto.request.CreateCommentRequest;
import com.project.threadsclone.dto.request.UpdateCommentRequest;
import com.project.threadsclone.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CreateCommentRequest createCommentRequest){
        return ResponseEntity.ok(commentService.createComment(createCommentRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody UpdateCommentRequest updateCommentRequest){
        return  ResponseEntity.ok(commentService.updateComment(updateCommentRequest, id));
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id){
        commentService.deleteComment(id);
    }

}
