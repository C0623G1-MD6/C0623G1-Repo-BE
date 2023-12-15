package com.example.fashion.repository.customerRepository;

import com.example.fashion.dto.customerDto.ICustomerDto;
import com.example.fashion.model.customer.Customer;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    /**
     * method editCustomerRepo
     * create by ThienLCH
     * date 11-12-2023
     * param : customer
     * return void
     */

    @Transactional
    @Modifying
    @Query(value = "update customers set name = :#{#customer.name}, gender = :#{#customer.gender}, " +
            " birthday = :#{#customer.birthday}, point = :#{#customer.point}, " +
            " address = :#{#customer.address}, email = :#{#customer.email}, phone = :#{#customer.phone} " +
            "WHERE id = :#{#customer.id} ", nativeQuery = true)
    void editCustomerRepo(@Param("customer") Customer customer);

    /**
     * method createCustomerRepo
     * create by ThienLCH
     * date 11-12-2023
     * param : customer
     * return void
     */

    @Transactional
    @Modifying
    @Query(value = "insert into customers (customer_code, name, gender, birthday, point, address, email, phone) " +
            "value ( :#{#customer.customerCode}, :#{#customer.name}, :#{#customer.gender}, :#{#customer.birthday}, " +
            ":#{#customer.point},  :#{#customer.address}, :#{#customer.email}, :#{#customer.phone}) "
            , nativeQuery = true)
    void createCustomerRepo(@Param("customer") Customer customer);

    /**
     * method findCustomerByPhone
     * create by ThienLCH
     * date 11-12-2023
     * param : phone
     * return Customer
     */
    @Query(value = " select * from customers where phone = :phone ", nativeQuery = true)
    Customer findCustomerByPhone(@Param("phone") String phone);

    /**
     * method findCustomerByEmail
     * create by ThienLCH
     * date 11-12-2023
     * param : email
     * return Customer
     */
    @Query(value = "select * from customers where email like :email ", nativeQuery = true)
    Customer findCustomerByEmail(@Param("email") String email);

    /**
     * method findCustomerByCode
     * create by ThienLCH
     * date 11-12-2023
     * param : code
     * return Customer
     */
    @Query(value = "select * from customers where customer_code like :code ", nativeQuery = true)
    Customer findCustomerByCode(@Param("code") String code);

    /**
     * method getAllCustomer
     * create by TrungND
     * date 12-12-2023
     * param :name, typeCustomer
     * return :
     */

    @Query(value = "select customers.id, customers.name,customers.customer_code,customers.gender,customers.birthday, customers.phone, " +
            "customers.email, customers.point, customers.address, customers.customer_type_id, customers.is_deleted " +
            "from customers" +
            " join customer_type on customers.customer_type_id = customer_type.id" +
            " where " +
            " customers.is_deleted = '0' " +
            " and customers.name like :name and customer_type.name like :typeCustomer", nativeQuery = true)
    Page<Customer> findAllCustomer(Pageable pageable, @Param("name") String name, @Param("typeCustomer") String typeCustomer);


    /**
     * method deleteCustomer
     * create by TrungND
     * date 12-12-2023
     * param :id
     * return :
     */

    @Modifying
    @Transactional
    @Query(value = " update customers set customers.is_deleted = 1 where customers.id = :id", nativeQuery = true)
    void deleteId(@Param("id") int id);






































    /**
     * The method help to get page customer from database.
     * @author NhatNk
     * @since 2023-12-13
     * @param pageable
     * @param keyword is String entered from input box on the screen
     * @return Page ICustomerDto If the query is correct
     * @return Exception or null If the query is incorrect
     * @see Page<ICustomerDto>
     */
    @Query(value = "select customers.id, customers.customer_code, customers.name, customers.phone, customers.point, customers.is_deleted, customer_type.discount_percent \n" +
            "from customers join customer_type on customers.customer_type_id = customer_type.id \n"+
            "where customers.is_deleted = '0' \n"+
            "and (customers.customer_code like :keyword \n" +
            "or customers.name like :keyword \n" +
            "or customers.phone like :keyword)"
            , nativeQuery = true)
    Page<ICustomerDto> getAllCustomer(Pageable pageable, @Param("keyword") String keyword);

}
