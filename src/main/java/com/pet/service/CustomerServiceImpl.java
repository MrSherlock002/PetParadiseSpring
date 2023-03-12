package com.pet.service;

import com.pet.entities.Customer;
import com.pet.exception.CustomerNotFoundException;
import com.pet.repository.ICustomerRepository;
import com.pet.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// business logic for customer service
// Spring context will autodetect these classes
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    public CustomerServiceImpl(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /*public Map<String, String> validateLogin(User user) {
        Map<String, String> response = new HashMap<>();

        User getUser = userRepository.findByUserName(user.getUserName());
        if (user.getUserName().equals(getUser.getUserName())) {
            if (user.getCustomer().getCustomerPassword().equals(getUser.getCustomer().getCustomerPassword())) {
                response.put("Success", "Customer login successful");
                return response;
            }
        }

        response.put("Failure", "Customer login Unsuccessful");
        return response;
    }*/

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
        if (customerRepository.existsById(customer.getCustomerId())) {
            return customerRepository.saveAndFlush(customer);
        } else {
            throw new CustomerNotFoundException("Customer Not Found");
        }
    }

    @Override
    public Customer viewCustomer(Customer customer) throws CustomerNotFoundException {
        if (customerRepository.existsById(customer.getCustomerId())) {
            return customerRepository.findById(customer.getCustomerId()).get();
        } else {
            throw new CustomerNotFoundException("Customer Not Found");
        }
    }

    @Override
    public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {
        if (customerRepository.existsById(customerId)) {
            customerRepository.deleteById(customerId);
            return null;
        } else {
            throw new CustomerNotFoundException("Customer Not Found");
        }
    }

    @Override
    public List<Customer> showAllCustomers() {
        return customerRepository.findAll();
    }
}
