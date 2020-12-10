package com.example.repository;

import com.example.entity.NewsPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsPostsRepository extends JpaRepository<NewsPost, Long> {
}
