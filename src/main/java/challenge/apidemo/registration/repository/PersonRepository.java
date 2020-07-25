package challenge.apidemo.registration.repository;

import challenge.apidemo.registration.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
