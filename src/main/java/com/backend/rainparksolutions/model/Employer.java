package com.backend.rainparksolutions.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "employers")
public class Employer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "employer_sequence", sequenceName = "employer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employer_sequence")
    private Long id;

    @Size(max = 50)
    @NotNull(message = "Please enter your company name")
    @Column(nullable = false, length = 50)
    private String companyName;

    @Size(max = 50)
    @NotNull(message = "Please enter your full name")
    @Column(nullable = false, length = 50)
    private String fullName;

    @Size(max = 50)
    @NotNull(message = "Please enter your position/title")
    @Column(nullable = false, length = 50)
    private String position;

    @NotNull(message = "Please enter company address")
    @Column(nullable = false)
    private String companyAddress;

    @NotNull(message = "Please enter city")
    @Column(nullable = false)
    private String city;

    @NotNull(message = "Please enter state")
    @Column(nullable = false)
    private String state;

    @NotNull(message = "Please enter zip code")
    @Column(nullable = false)
    private String zipCode;

    @Email(message = "Please enter valid email")
    @NotNull(message = "Please enter your email")
    @Size(min = 5, max = 254)
    @Column(nullable = false, unique = true, length = 254)
    private String email;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @NotNull(message = "Please enter your phone number")
    @Size(min = 14, max= 14, message = "Phone number should be exact 10 characters")
    @Column(length = 14)
    private String phoneNumber;

    @NotNull(message = "Please enter job category")
    @Column(nullable = false)
    private String jobCategory;

    @NotNull(message = "Please enter job title")
    @Column(nullable = false)
    private String jobTitle;

    @NotNull(message = "Please enter salary range")
    @Column(nullable = false)
    private Double salaryRange;

    @NotNull(message = "Please enter city where position is located")
    @Column(nullable = false)
    private String positionLocatedCity;

    @NotNull(message = "Please enter city where position status")
    @Column(nullable = false)
    private String positionStatus;

    public Employer(String companyName, String fullName, String position, String companyAddress, String city,
                    String state, String zipCode, String email, String phoneNumber, String jobCategory,
                    String jobTitle, Double salaryRange, String positionLocatedCity, String positionStatus) {
        this.companyName = companyName;
        this.fullName = fullName;
        this.position = position;
        this.companyAddress = companyAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.jobCategory = jobCategory;
        this.jobTitle = jobTitle;
        this.salaryRange = salaryRange;
        this.positionLocatedCity = positionLocatedCity;
        this.positionStatus = positionStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return Objects.equals(id, employer.id) &&
                Objects.equals(companyName, employer.companyName) &&
                Objects.equals(fullName, employer.fullName) &&
                Objects.equals(position, employer.position) &&
                Objects.equals(companyAddress, employer.companyAddress) &&
                Objects.equals(city, employer.city) &&
                Objects.equals(state, employer.state) &&
                Objects.equals(zipCode, employer.zipCode) &&
                Objects.equals(email, employer.email) &&
                Objects.equals(phoneNumber, employer.phoneNumber) &&
                Objects.equals(jobCategory, employer.jobCategory) &&
                Objects.equals(jobTitle, employer.jobTitle) &&
                Objects.equals(salaryRange, employer.salaryRange) &&
                Objects.equals(positionLocatedCity, employer.positionLocatedCity) &&
                Objects.equals(positionStatus, employer.positionStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, fullName, position, companyAddress, city, state, zipCode, email,
                phoneNumber, jobCategory, jobTitle, salaryRange, positionLocatedCity, positionStatus);
    }
}
