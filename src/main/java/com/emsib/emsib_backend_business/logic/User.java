package com.emsib.emsib_backend_business.logic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String nip;

    @Column(name = "password_hash")
    private Byte[] hash;
    private Byte[] salt;

    public User(){
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Byte[] getHash() {
        return hash;
    }

    public void setHash(Byte[] hash) {
        this.hash = hash;
    }

    public Byte[] getSalt() {
        return salt;
    }

    public void setSalt(Byte[] salt) {
        this.salt = salt;
    }

    
}
