package com.example.springdatawthboot.service.old;

import java.util.List;
import java.util.stream.Stream;

import com.example.springdatawthboot.entity.old.Address;
import com.example.springdatawthboot.entity.old.Person;
import com.example.springdatawthboot.facade.old.PersonIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PersonService {

    @Autowired
    PersonIRepository repository;


    public Person insert(String name, String family, Address address) {
        Person person = new Person(name, family, address);
        repository.save(person);

        return person;
    }

    public void updateAllPerson(String street, String zipcode, String family){
        repository.updateAllPerson(street, zipcode, family);
    }


    public List<Person> personList(){

        Address address = new Address();
        address.setStreet("av");
        address.setZipCode("021");

        Person person = new Person("ali", "asgariEmad", address);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching().
                withIgnorePaths("address").
                withMatcher("Family", ExampleMatcher.GenericPropertyMatcher::contains).
                withIgnoreNullValues();

        Example<Person> example = Example.of(person, exampleMatcher);
        List<Person> personList = repository.findAll(example);


        return personList;
    }



    public List<Person> people(){
       return repository.findAll();
    }

    public List<Person> getAllBydIds(List<Long> list){
        return repository.findTopByIdIn(list);
    }

    public Integer countByExpression(String alias) {
        return repository.personNumber(alias);
    }

    public List<Person> findByStreamable(String family){
        try(Stream<Person> personStream = repository.findAllByFamilyContaining(family).stream()){

            List<Person> list = personStream.toList();
            System.out.println(list.size());

            return list;
        }
    }

    public List<Person.Projection> findByNameWithLimitation(String name){
        List<Person.Projection> list = repository.findByNameContaining(name);

        System.out.println(list.size());

        return list;
    }

    public List<Person> findByFamilyOrName(String family, String name){
        return repository.getPersonByFamilyOrName(family, null);
    }

    public List<Person.Projection> findByNameWithNo(String name){
       return repository.findByNameContaining(name);
    }

    public void update(String person) {
         repository.updatePerson(person);
    }

    public List<Person> findPersonByVersion(Integer rc, Sort name){
        return repository.findByRc(rc, name);
    }

    public <T> T generify(T t){
        return t;
    }


}
