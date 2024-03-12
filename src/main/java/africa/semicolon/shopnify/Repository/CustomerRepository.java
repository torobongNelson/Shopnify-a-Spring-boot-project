package africa.semicolon.shopnify.Repository;

import africa.semicolon.shopnify.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    //the jpa has a class that extends jpa repository that has all the methods we need

}
