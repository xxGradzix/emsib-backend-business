package com.emsib.relational_database;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_")
public class UserEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Integer userId;

    @Column(name = "name_", nullable = false, length = 50)
    public String name;

    @Column(name = "surname", length = 50)
    public String surname;

    @Column(name = "email", nullable = false, length = 100)
    public String email;

    @Column(name = "phone", nullable = false, length = 16)
    public String phone;

    @Column(name = "nip", length = 10)
    public String nip;

    @Column(name = "password_hash", nullable = false)
    public byte[] passwordHash;

    @Column(name = "salt", nullable = false)
    public byte[] salt;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", nip='" + nip + '\'' +
                ", passwordHash=" + Arrays.toString(passwordHash) +
                ", salt=" + Arrays.toString(salt) +
                '}';
    }
}
