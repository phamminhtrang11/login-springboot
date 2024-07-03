package com.example.logindemospringboot.ILogin.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginImp {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LoginImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean validUser(String username, String password) {
        String sql = "SELECT COUNT(*) FROM login WHERE username = ? AND password = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);

        return count != null && count > 0;
    }
}
