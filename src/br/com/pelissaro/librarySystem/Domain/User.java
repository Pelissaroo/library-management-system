package br.com.pelissaro.librarySystem.Domain;

public class User {
    private String name;
    private int id;
    private String cpf;
    private String address;
    private int addressNumber;
    private String phoneNumber;
    private boolean active;

    public User(String name,int id, String cpf, String adress, int adressNumber, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.cpf = cpf;
        this.address = adress;
        this.addressNumber = adressNumber;
        this.phoneNumber = phoneNumber;
        this.active = true;
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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", address='" + address + '\'' +
                ", adressNumber=" + addressNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", UserId=" + id +
                '}';
    }
}
