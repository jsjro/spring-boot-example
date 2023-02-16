package io.github.jsjro.springBootCrudExample.rest.post.repository;

import io.github.jsjro.springBootCrudExample.rest.post.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByStatus(boolean status);

    List<Post> findByTitleContaining(String title);
}