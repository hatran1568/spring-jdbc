package com.example.example130921.controller;

import com.example.example130921.dao.entity.Customer;
import com.example.example130921.dto.request.CustomerRequest;
import com.example.example130921.dto.response.CustomerResponse;
import com.example.example130921.service.CustomerService;
import com.example.example130921.service.impl.CustomerServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController extends AbstractController<CustomerService>{

    @GetMapping("")
    public ModelAndView getAllCustomers(){
        ModelAndView modelAndView = new ModelAndView("customer");
        modelAndView.addObject("customerList", service.getCustomers().get());
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        return response(service.getById(id));
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd(){
        return new ModelAndView("customer-add");
    }

    @PostMapping("/add")
    public ModelAndView addCustomer(HttpServletRequest httpServletRequest){
        CustomerRequest customerRequest = new CustomerRequest(httpServletRequest.getParameter("customerName"),
                                                                httpServletRequest.getParameter("phone"));
        service.add(customerRequest);
        return new ModelAndView("redirect:/customers");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormEdit(@PathVariable int id){
        Optional<CustomerResponse> customerResponse = service.getById(id);
        if(customerResponse.isEmpty()){
            return new ModelAndView("redirect:/customers");
        } else {
            ModelAndView modelAndView = new ModelAndView("customer-update");
            modelAndView.addObject("customer", customerResponse.get());
            return modelAndView;
        }
    }

    @PostMapping("/update/{id}")
    public ModelAndView updateCustomer(@PathVariable int id, HttpServletRequest httpServletRequest){
        CustomerRequest customerRequest = new CustomerRequest(httpServletRequest.getParameter("customerName"),
                httpServletRequest.getParameter("phone"));
        service.updateById(id, customerRequest);
        return new ModelAndView("redirect:/customers");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCustomer(@PathVariable int id){
        Optional<CustomerResponse> customerResponse = service.getById(id);
        if(!customerResponse.isEmpty()){
            service.deleteById(id);
        }
        return new ModelAndView("redirect:/customers");
    }
}
