import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .map(Insurance::getName)
                     .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                      .map(Person::getCar)
                    .map(optCar -> optCar.flatMap(Car::getInsurance))


                      .map(optInsurance -> optInsurance.map(Insurance::getName))
                   //   .flatMap(Optional::stream)
                .flatMap(e->e.map(Stream::of).orElse(Stream.empty()))
                //.map(e->e.get())
                      .collect(toSet());
    }
}
