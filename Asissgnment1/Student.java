package Session11.Asissgnment1;

import java.awt.*;
import java.sql.Date;

public class  Student {
    public Integer Id;
    public String Name;
    public Date dateOfBirth;
    public String Address;
    public String Email;
    public String Phone;

    public Student(Integer Id, String Name, Date dateOfBirth, String Address, String Email, String Phone) {
        this.Id = Id;
        this.Name = Name;
        this.dateOfBirth = dateOfBirth;
        this.Address = Address;
        this.Email = Email;
        this.Phone = Phone;

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}