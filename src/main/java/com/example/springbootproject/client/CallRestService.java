package com.example.springbootproject.client;

import com.example.springbootproject.entity.EmployeeData;
import com.example.springbootproject.entity.EmployeeTotal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService implements CommandLineRunner {

    private static void callRestService(){
        RestTemplate restTemplate =  new RestTemplate();
        EmployeeTotal employeeTotal = restTemplate.getForObject("https://reqres.in/api/users?page=2", EmployeeTotal.class);

        System.out.println("List of employees: " + employeeTotal.getEmployees().toString());
        System.out.println("Page: " + employeeTotal.getPage());
        System.out.println("Per Page: " + employeeTotal.getPer_page());
        System.out.println("Total: " + employeeTotal.getTotal());
        System.out.println("Total Pages: " + employeeTotal.getTotal_pages());

        RestTemplate restTemplateById =  new RestTemplate();
        EmployeeData employeeData = restTemplateById.getForObject("https://reqres.in/api/users/2", EmployeeData.class);

        System.out.println("Name of the employee is: " + employeeData.getEmployeeInfo().getFirst_name());
        System.out.println("Avatar of the employee is: " + employeeData.getEmployeeInfo().getAvatar());
        System.out.println("Employee infos are: " + employeeData.getEmployeeInfo().toString());
    }

    @Override
    public void run(String... args) throws Exception {
        callRestService();
    }
}
