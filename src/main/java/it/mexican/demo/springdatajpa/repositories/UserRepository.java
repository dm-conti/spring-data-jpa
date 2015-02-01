package it.mexican.demo.springdatajpa.repositories;

import it.mexican.demo.springdatajpa.entities.User;
import it.mexican.demo.springdatajpa.factory.LoyaltyRepository;

import java.util.List;

public interface UserRepository extends LoyaltyRepository<User, Long> {
	List<User> findByLastname(String lastname);
}