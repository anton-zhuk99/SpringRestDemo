package com.example.restdemo.dto;

// {
//    userId: ???,
//    amount: ???
// }
public class AccountDto {

    private int userId;
    private double amount;

    public AccountDto() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
