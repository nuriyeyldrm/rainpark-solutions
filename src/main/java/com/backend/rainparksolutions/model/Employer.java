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

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "employers")
public class Employer implements Serializable {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
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

}
