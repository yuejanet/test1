package com.cy.users.dto;

public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String birthday;
    private String country;

    public UserDto(){
        super();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public UserDto(String firstName, String lastName, String birthday, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.country = country;

    }
}
