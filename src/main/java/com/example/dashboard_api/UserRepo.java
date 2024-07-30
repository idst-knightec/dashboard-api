package com.example.dashboard_api;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository is an interface that provides access to data in a database
 */
public interface UserRepo extends JpaRepository<User, UUID> {
}
