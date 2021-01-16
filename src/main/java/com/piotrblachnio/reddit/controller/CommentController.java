package com.piotrblachnio.reddit.controller;

import com.piotrblachnio.reddit.constants.ApiRoutes;
import com.piotrblachnio.reddit.dto.CommentDto;
import com.piotrblachnio.reddit.service.CommentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping(ApiRoutes.Comment.CREATE)
    public ResponseEntity<Void> createComment(@RequestBody CommentDto commentDto) {
        commentService.save(commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(ApiRoutes.Comment.GET_BY_POST)
    public ResponseEntity<List<CommentDto>> getAllCommentsByPost(@PathVariable Long postId) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllCommentsForPost(postId));

    }

    @GetMapping(ApiRoutes.Comment.GET_BY_USER)
    public ResponseEntity<List<CommentDto>> getAllCommentsByUser(@PathVariable String username) {
        return ResponseEntity.status(HttpStatus.OK).body(commentService.getAllCommentsForUser(username));
    }
}
