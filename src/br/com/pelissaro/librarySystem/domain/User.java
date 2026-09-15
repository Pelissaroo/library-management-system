package br.com.pelissaro.librarySystem.domain;

import java.util.Objects;

public class User {
    private String name;
    private int id;
    private String cpf;
    private String address;
    private int addressNumber;
    private String phoneNumber;
    private boolean active;

    public User(String name, String cpf, String address, int addressNumber, String phoneNumber) {
        this.name = name;
        this.cpf = cpf;
        this.address = address;
        this.addressNumber = addressNumber;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(cpf, user.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf);
    }


}
