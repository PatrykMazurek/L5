package pl.krakow.uken.rest_service.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="person")
public class Person {
    
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private String apiKey;
    @Transient
    private String email;

}
