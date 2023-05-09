package org.example;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "student_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;
    private String city;
    @Column(name = "street",length = 50)
    private String street;
    @Temporal(TemporalType.DATE)
    private Date currentDate;
    @Lob
    private byte[] image;

    public Address() {
    }

    public Address(int addressId, String city, String street, Date currentDate, byte[] image) {
        this.addressId = addressId;
        this.city = city;
        this.street = street;
        this.currentDate = currentDate;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", currentDate=" + currentDate +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
