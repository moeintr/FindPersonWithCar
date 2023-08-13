package com.a.model.repository;

import com.a.model.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FindPersonWithCaraRepository extends JpaRepository<Person, Long> {
    @Query("select distinct (o) from person o left join fetch o.cars c where o.personId=:personId")
    List<Person> selectPersonWithCarsByPersonId(@Param("personId") Long personId);
}
