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
@Table(name = "candidates")
@Entity
public class Candidate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "candidate_sequence", sequenceName = "candidate_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_sequence")
    private Long id;

    @Size(max = 25, message = "you have exceeded the size")
    @NotNull(message = "Please enter your first name")
    @Column(nullable = false, length = 25)
    private String firstName;

    @Size(max = 25, message = "you have exceeded the size")
    @NotNull(message = "Please enter your last name")
    @Column(nullable = false, length = 25)
    private String lastName;

    @Pattern(regexp = "^((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$",
            message = "Please enter valid phone number")
    @Size(min = 14, max= 14, message = "Phone number should be exact 10 characters")
    @Column(length = 14)
    private String phoneNumber;

    @Email(message = "Please enter valid email")
    @NotNull(message = "Please enter your email")
    @Size(min = 5, max = 254)
    @Column(nullable = false, unique = true, length = 254)
    private String email;

    @Size(max = 50, message = "you have exceeded the size")
    @Column(length = 50)
    private String jobTitle;

    @Size(max = 15, message = "you have exceeded the size")
    @NotNull(message = "Please enter your country that you locating now")
    @Column(nullable = false, length = 15)
    private String country;

    private Integer experience;

    @Size(max = 250, message = "you have exceeded the size")
    @Column(length = 250)
    private String tools;

    public Candidate(String firstName, String lastName, String phoneNumber, String email, String jobTitle,
                     String country, Integer experience, String tools) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.jobTitle = jobTitle;
        this.country = country;
        this.experience = experience;
        this.tools = tools;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidate)) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(id, candidate.id) &&
                Objects.equals(firstName, candidate.firstName) &&
                Objects.equals(lastName, candidate.lastName) &&
                Objects.equals(phoneNumber, candidate.phoneNumber) &&
                Objects.equals(email, candidate.email) &&
                Objects.equals(jobTitle, candidate.jobTitle) &&
                Objects.equals(country, candidate.country) &&
                Objects.equals(experience, candidate.experience) &&
                Objects.equals(tools, candidate.tools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email, jobTitle, country, experience, tools);
    }
}
