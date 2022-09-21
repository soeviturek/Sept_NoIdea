package com.example.noidea.sept_noidea.dao;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserExistingDao {

    @NotNull(message = "id cannot be empty")
    private Integer id;
    @NotNull(message = "Password cannot be empty")
    @Size(min = 2, max = 15,
            message = "Password must be atleast of 2 letters and not more then 100 letters")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;

    private int userType;
    private String contactNumber;
    private int deleteFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}
