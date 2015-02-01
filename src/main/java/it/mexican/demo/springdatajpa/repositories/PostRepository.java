package it.mexican.demo.springdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import it.mexican.demo.springdatajpa.entities.Post;
import it.mexican.demo.springdatajpa.entities.User;
import it.mexican.demo.springdatajpa.factory.LoyaltyRepository;

public interface PostRepository extends LoyaltyRepository<Post, Integer> {

}
