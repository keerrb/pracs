package com.spring.boot.practice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ForExRepository extends JpaRepository<ForexValue, Long> {

	ForexValue findByFromAndTo(String from, String to);
}
