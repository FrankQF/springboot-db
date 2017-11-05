package com.frank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frank.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
