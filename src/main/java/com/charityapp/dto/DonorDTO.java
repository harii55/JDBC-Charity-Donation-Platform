package main.java.com.charityapp.dto;

import main.java.com.charityapp.enums.GenderType;

import java.sql.Timestamp;

public class DonorDTO {
    private int donorId;
    private String name;
    private String email;
    private String password;
    private String city;
    private String state;
    private String country;
    private int age;
    private GenderType gender;
    private String incomeRange;
    private Timestamp createdAt;

    public DonorDTO() {}

    public DonorDTO(int donorId, String name, String email, String password, String city, String state, String country, int age, GenderType gender, String incomeRange, Timestamp createdAt) {
        this.donorId = donorId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.city = city;
        this.state = state;
        this.country = country;
        this.age = age;
        this.gender = gender;
        this.incomeRange = incomeRange;
        this.createdAt = createdAt;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getIncomeRange() {
        return incomeRange;
    }

    public void setIncomeRange(String incomeRange) {
        this.incomeRange = incomeRange;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
