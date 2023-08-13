package com.a.model.service;

import com.a.model.domain.Person;
import com.a.model.repository.Crud;
import com.a.model.repository.FindPersonWithCaraRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Scope("singleton")
public class FindService {
    private final Crud<Person, Long> findCrud;
    private final FindPersonWithCaraRepository findPersonWithCaraRepository;

    public FindService(Crud<Person, Long> findCrud, FindPersonWithCaraRepository findPersonWithCaraRepository) {
        this.findCrud = findCrud;
        this.findPersonWithCaraRepository = findPersonWithCaraRepository;
    }
    public Optional<List<Person>> findAllPersonWithCars() {
        return Optional.ofNullable(findCrud.selectAllWithChildes(Person.class,"cars"));
    }
    public Optional<List<Person>> findPersonWithCarsByPersonId(Person person) {
        return Optional.ofNullable(findPersonWithCaraRepository.selectPersonWithCarsByPersonId(person.getPersonId()));
    }
}
