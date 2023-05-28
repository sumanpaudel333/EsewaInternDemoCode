package com.microservice.addressservice.repo;

import com.microservice.addressservice.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    // find address by employee id
    @Query(nativeQuery = true,value = "SELECT ea.id,ea.street,ea.city,ea.state FROM microservice_demo.address ea " +
            "inner join microservice_demo.employee e on e.id=ea.employee_id where ea.employee_id= ?;")
     Address findEmployeeByAddressId(int id);
}
