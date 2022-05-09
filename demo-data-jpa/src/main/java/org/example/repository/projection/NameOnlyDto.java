package org.example.repository.projection;

public class NameOnlyDto {
    private final String firstName;
    private final String lastName;

    NameOnlyDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
