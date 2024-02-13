package com.ua.project.models;

import com.ua.project.util.helpers.InputHelpers;

import java.util.Objects;

public class Author {
    private String firstName;
    private String lastName;
    private String patronymic;

    public Author(String firstName, String lastName, String patronymic) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }
    public Author(String firstName, String lastName) {
        this(firstName, lastName, "");
    }
    public Author() {
        this("SomeName", "SomeLastName");
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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void fillBio() {
        String tempStringInput;

        this.setLastName(InputHelpers.getStringInputByLength("\n Enter last name: ", 4));
        this.setFirstName(InputHelpers.getStringInputByLength("\n Enter first name: ", 3));

        tempStringInput = InputHelpers.getStringInputByLength("\n Enter patronymic (to skip, enter \"0\"): ", 1);
        this.setPatronymic(tempStringInput.equals("0") ? "" : tempStringInput);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(getFirstName().toLowerCase(), author.getFirstName().toLowerCase()) && Objects.equals(getLastName().toLowerCase(), author.getLastName().toLowerCase()) && Objects.equals(getPatronymic().toLowerCase(), author.getPatronymic().toLowerCase());
    }

    @Override
    public String toString() {
        return " " + this.getFirstName() +
                " " + this.getLastName() +
                " " + this.getPatronymic();
    }
}
