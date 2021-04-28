package com.example.restdemo.repository.impl;

import com.example.restdemo.dto.AccountDto;
import com.example.restdemo.dto.UserDto;
import com.example.restdemo.model.Account;
import com.example.restdemo.model.User;
import com.example.restdemo.repository.AccountRepository;
import com.example.restdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    @Autowired
    private Connection connection;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(AccountDto dto) {
        try {
            String sql = "INSERT INTO accounts(user_id, amount) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, dto.getUserId());
            ps.setDouble(2, dto.getAmount());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account read(Integer id) {
        Account account = new Account();
        try {
            String sql = "SELECT * FROM accounts WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                account.setId(rs.getInt("id"));
                User user = userRepository.read(rs.getInt("user_id"));
                account.setUser(user);
                account.setAmount(rs.getDouble("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public void update(Account obj) {
        try {
            String sql = "UPDATE accounts SET user_id = ?, amount = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, obj.getUser().getId());
            ps.setDouble(2, obj.getAmount());
            ps.setInt(3, obj.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM accounts WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Account> list() {
        List<Account> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM accounts";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                User user = userRepository.read(rs.getInt("user_id"));
                account.setUser(user);
                account.setAmount(rs.getDouble("amount"));
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
