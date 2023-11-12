package com.example.springdatawthboot;


import com.example.springdatawthboot.entity.bank.BankAccount;
import com.example.springdatawthboot.entity.bank.CreditCard;
import com.example.springdatawthboot.service.partOne.BankAccountService;
import com.example.springdatawthboot.service.partOne.CreditCardService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class SpringDataWthBootApplication {


    private final BankAccountService bankAccountService;

    public SpringDataWthBootApplication(@Qualifier("bankAccountService")
                                    BankAccountService bankAccountService){
            this.bankAccountService = bankAccountService;
        }


    public static void main(String[] args) {
        SpringApplication.run(SpringDataWthBootApplication.class, args);
    }


    @Bean
    public Object serviceRunner(CreditCardService service){

        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber("845612");
        creditCard.setOwner("Hello");
        creditCard = service.save(creditCard);
        System.out.println(creditCard.getId());

        List<BankAccount> bankAccounts = bankAccountService.bankAccounts("opa");
        List<CreditCard> accounts = service.creditCards("5022_2913_1489_0888");

        List<CreditCard> cards = service.findByOwner("Hello");
        accounts.forEach(s -> System.out.println(s.getOwner()));
        bankAccounts.forEach(d -> System.out.println(d.getBankName()));

        return accounts;
    }



//    @Bean
//    public List<Person> getAllPersonByFamily(PersonService service){
//        service.updateAllPerson("9856", "0258", "asgariEmad");
//        List<Person> list = service.findByFamilyOrName("asgariEmad", null);
//        list.forEach(s -> System.out.println(s.getName() + "  " + s.getFamily()
//                + "   " + s.getAddress().getStreet() + "   " + s.getAddress().getZipCode()));
//
//        return service.personList();
//    }


//    @Bean
//    public List<BankAccount> bankAccountList(BankAccountService service){
//        List<BankAccount> list = service.bankAccounts();
//
//        list.forEach(s -> System.out.println(s.getOwner()));
//
//        return list;
//    }














//    @Bean
//    public List<Person> runner(PersonService personService){
//        Address address = new Address("furozanfar", "021");
//       Person person = personService.insert("ali", "asgariEmad", address);

//        personService.people().forEach(x -> System.out.println(x.getId() + ",  " + x.getName() + ", " +
//                x.getFamily() + ",  " + x.getRc()));

//        personService.getAllBydIds(Arrays.asList(11L, 13L, 15L, 19L, 20L)).forEach(w ->
//                System.out.println(w.getName() + "  " + w.getFamily()));

//        personService.findByStreamable("I").forEach(w -> System.out.println(w.getName() + "  " + w.getFamily()));

//        System.out.println(
//        personService.countByExpression("Hell"));

//        personService.findByNameWithLimitation("a").forEach(q -> System.out.println(q.getFamily()));

//        Person person = new Person(6L, "sdasd", "dsafda");
//        personService.update(person.getName());


//        personService.findPersonByVersion(0, Sort.by("name"))
//                .forEach(w -> System.out.println(w.getName() + ", " + w.getFamily()));
//
//        return personService.people();
//    }


//    @Bean
//    public List<UserView> runnerOne(UserService service){
//        User user = service.insertService(13L, "0440642701");
//        System.out.println(user.getId() + ", " + user.getPersonId() +
//                ", " + user.getNaturalCode() + ", -> " + user.getAverageIds());

//        viewService.views().forEach(e -> System.out.println(e.getViewId() + ", " + e.getName() + ", "
//                   + e.getFamily() + ", " + e.getUniqueCode() + ", " + e.getSumming()));

//        return null;
//    }


//    @Bean
//    public Address runnerTwo(PersonService service){
//        Address address = new Address("furozanfar", "021");
//
//        Person person = service.insert("ali", "asgariEmad", address, null);
//
//        System.out.println(person.getName() + ",  " + person.getAddress().getZipCode() + ",  " +
//                address.getZipCode() + ",  " + address.getStreet());
//
//        return address;
//    }

//    @Bean
//    public List<Person> runnerThree(PersonService service){
//
//         service.findPersonByVersion(0, Sort.by("name"))
//                .forEach(w -> System.out.println(w.getName() + ", " + w.getFamily()));
//
//        List<Person> list = service.generify(service.people());
//        List<Object> list1 = new ArrayList<>();
//        list1.add("");
//
//        list.forEach(System.out::println);
//
//        return null;
//    }



}
