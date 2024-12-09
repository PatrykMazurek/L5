package pl.krakow.uken.mail_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.krakow.uken.mail_service.model.PersonMail;

@Repository
public interface PersonMailRepository extends JpaRepository<PersonMail, Long>{
    
}
