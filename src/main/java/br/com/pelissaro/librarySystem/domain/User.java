package br.com.pelissaro.librarySystem.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
@Entity
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @Column(columnDefinition = "char(11)", length = 11)
    @NotBlank
    private String cpf;
    @NotBlank
    private String address;

    @Column(name = "address_number")
    @Positive
    private int addressNumber;

    @Column(name = "phone_number")
    @NotBlank
    private String phoneNumber;

    private boolean active;

    public User(String name, String cpf, String address, int addressNumber, String phoneNumber) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.addressNumber = addressNumber;
        this.phoneNumber = phoneNumber;
        this.active = true;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserId = " + id +
                ",name = " + name + '\'' +
                ", cpf = " + cpf.substring(0,3)+"."+ cpf.substring(3,6)+"."+ cpf.substring(6,9)+"-"+ cpf.substring(9,11) + '\'' +
                ", address= " + address + '\'' +
                ", addressNumber=" + addressNumber +
                ", phoneNumber= " + "(" + phoneNumber.substring (0,2) + ") " + phoneNumber.substring (2,7) + "-" + phoneNumber.substring(7,11) +
                ", active= " + active + '}';
    }
}
