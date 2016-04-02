package basaki.service.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import basaki.data.Customer;
import basaki.data.CustomerList;
import basaki.service.CustomerService;

/**
 * 
 * <tt>CustomerServiceController</tt> is the Spring controller responsible for
 * processing customer REST requests. It delegates the processing to
 * <tt>CustomerService</tt> business service.
 * <p/>
 * 
 * @author Indra Basak
 * 
 */
@Controller
@RequestMapping("/customers")
public class CustomerServiceController {

    @Resource(name = "customerService")
    private CustomerService service;

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
	    MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
    @ResponseBody
    public Customer getCustomer(@PathVariable Integer id) {
	System.out.println("Retrieving customer with id =" + id);
	return service.getCustomer(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_XML_VALUE,
	    MediaType.APPLICATION_JSON_VALUE })
    @ResponseBody
    public CustomerList getCustomers() {
	System.out.println("Retrieving customers");
	return new CustomerList(new ArrayList<Customer>(service.getCustomers()));
    }

    @RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_XML_VALUE,
	    MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
		    MediaType.APPLICATION_JSON_VALUE })
    public @ResponseBody Customer createCustomer(@RequestBody Customer customer) {
	System.out.println("*** Start createCustomer");
	return service.createCustomer(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_XML_VALUE,
	    MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
    public @ResponseBody Customer deleteCustomer(@PathVariable("id") Integer id) {
	System.out.println("*** Start deleteCustomer");
	return service.deleteCustomer(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = { MediaType.APPLICATION_XML_VALUE,
	    MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
		    MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
    public @ResponseBody Customer updateCustomer(@PathVariable("id") Integer id, @RequestBody Customer customer) {
	System.out.println("*** Start updateCustomer");
	return service.updateCustomer(id, customer);
    }

    @RequestMapping(method = RequestMethod.PATCH, consumes = { MediaType.APPLICATION_XML_VALUE,
	    MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_XML_VALUE,
		    MediaType.APPLICATION_JSON_VALUE }, value = "/{id}")
    public @ResponseBody Customer updatePartialCustomer(@PathVariable("id") Integer id,
	    @RequestBody Customer customer) {
	System.out.println("*** Start updatePartialCustomer");
	System.out.println("cust in: " + customer);
	Customer cust = service.updatePartialCustomer(id, customer);
	System.out.println("cust out: " + cust);
	return cust;
    }
}
