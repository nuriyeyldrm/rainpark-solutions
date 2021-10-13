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
@Table(name = "questions")
public class Question implements Serializable {

    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private Long id;

    @Size(max = 50)
    @NotNull(message = "Please enter your first name")
    @Column(nullable = false, length = 50)
    private String firstName;

    @Size(max = 50)
    @NotNull(message = "Please enter your last name")
    @Column(nullable = false, length = 50)
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

    @Size(max = 50)
    @Column(nullable = false, length = 50)
    private String jobTitle;

    @NotNull(message = "Please enter your country")
    private String country;

    private Integer experience;

    private String tools;

    public Question(String firstName, String lastName, String phoneNumber, String email, String jobTitle,
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
        if (!(o instanceof Question)) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(firstName, question.firstName) &&
                Objects.equals(lastName, question.lastName) &&
                Objects.equals(phoneNumber, question.phoneNumber) &&
                Objects.equals(email, question.email) &&
                Objects.equals(jobTitle, question.jobTitle) &&
                Objects.equals(country, question.country) &&
                Objects.equals(experience, question.experience) &&
                Objects.equals(tools, question.tools);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email, jobTitle, country, experience, tools);
    }
}
