package io.github.jsjro.springBootCrudExample.rest.post.controller;

import io.github.jsjro.springBootCrudExample.rest.post.model.Post;
import io.github.jsjro.springBootCrudExample.rest.post.repository.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping(value = "/api")
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

    final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * getAllPosts
     *
     * @param title
     * @return
     */
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts(@RequestParam(required = false) String title) {
        try {
            List<Post> posts = new ArrayList<Post>();

            if (title == null)
                posts.addAll(postRepository.findAll());
            else
                posts.addAll(postRepository.findByTitleContaining(title));

            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("" + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * getPostById
     *
     * @param id
     * @return
     */
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") long id) {
        Optional<Post> postData = postRepository.findById(id);

        if (postData.isPresent()) {
            return new ResponseEntity<>(postData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * createPost
     *
     * @param post
     * @return
     */
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            Post _post = postRepository.save(new Post(post.getTitle(), post.getContent(), false, new Date(), null));
            return new ResponseEntity<>(_post, HttpStatus.CREATED);
        } catch (Exception e) {
            LOGGER.error("" + e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * updatePost
     *
     * @param id
     * @param post
     * @return
     */
    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
        Optional<Post> postData = postRepository.findById(id);

        if (postData.isPresent()) {
            Post _post = postData.get();
            _post.setTitle(post.getTitle());
            _post.setContent(post.getContent());
            _post.setStatus(post.isStatus());
            _post.setModified_date(new Date());
            return new ResponseEntity<>(postRepository.save(_post), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * deletePost
     *
     * @param id
     * @return
     */
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
        try {
            postRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error("" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * deleteAllPosts
     *
     * @return
     */
    @DeleteMapping("/posts")
    public ResponseEntity<HttpStatus> deleteAllPosts() {
        try {
            postRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            LOGGER.error("" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * findByStatus
     *
     * @return
     */
    @GetMapping("/posts/status")
    public ResponseEntity<List<Post>> findByStatus() {
        try {
            List<Post> posts = postRepository.findByStatus(true);

            if (posts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(posts, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}