package com.mycoolprojects.shopmanager.repository;

import com.mycoolprojects.shopmanager.entity.NewsPost;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsPostsRepository extends JpaRepository<NewsPost, Long> {
}
