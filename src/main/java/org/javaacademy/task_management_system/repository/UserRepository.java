package org.javaacademy.task_management_system.repository;

import lombok.RequiredArgsConstructor;
import org.javaacademy.task_management_system.entity.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import static java.util.Optional.empty;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private static final String FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static final String SAVE_USER_SQL = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
    private final JdbcTemplate jdbcTemplate;

    public void save(User user) {
        jdbcTemplate.update(
                SAVE_USER_SQL,
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public Optional<User> findByEmail(String email) {
        try {
            return Optional.of(jdbcTemplate.queryForObject(FIND_BY_EMAIL, this::toUser, email));
        } catch (DataAccessException e) {
            return empty();
        }
    }

    private User toUser(ResultSet rs, int rowNum) {
        User user = new User();
        try {
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}

