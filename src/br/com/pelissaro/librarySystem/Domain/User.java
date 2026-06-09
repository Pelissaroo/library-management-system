package br.com.pelissaro.librarySystem.Domain;

public class User {
    private String name;
    private int id;
    private int nextId;
    private String cpf;
    private String address;
    private int adressNumber;
    private String phoneNumber;

    public User(String name, String cpf, String adress, int adressNumber, String phoneNumber) {
        this.name = name;
        this.cpf = cpf;
        this.address = adress;
        this.adressNumber = adressNumber;
        this.phoneNumber = phoneNumber;
        id = ++nextId;
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

    public int getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(int adressNumber) {
        this.adressNumber = adressNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", address='" + address + '\'' +
                ", adressNumber=" + adressNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
