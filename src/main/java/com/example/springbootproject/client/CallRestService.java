package com.example.springbootproject.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class CallRestService implements CommandLineRunner {

    public CallRestService() {}

    private static void callRestService(){
        /*RestTemplate restTemplate =  new RestTemplate();
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
*/

        RestTemplate restTemplateByResponse =  new RestTemplate();

        /*List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplateByResponse.setMessageConverters(messageConverters);*/

        /*List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        Jaxb2RootElementHttpMessageConverter converter = new Jaxb2RootElementHttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplateByResponse.setMessageConverters(messageConverters);
*/
        /*MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter =
                new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(
                Arrays.asList(
                        MediaType.APPLICATION_JSON,
                        MediaType.APPLICATION_OCTET_STREAM));
        restTemplateByResponse.getMessageConverters().add(mappingJackson2HttpMessageConverter);*/

       MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add(HttpHeaders.USER_AGENT, "Mozilla/5.0");
        headers.add(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.8");
        headers.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        HttpEntity<?> entity = new HttpEntity<Object>(headers);
        HttpEntity<String> response = restTemplateByResponse.exchange("https://www.goodreads.com/author/list/18541?format=xml&key=WsCn5uVo7T5kMJNQqR8n3Q", HttpMethod.GET, entity, String.class);


        /*ResponseClass responseClass =
                restTemplateByResponse.getForObject("https://www.goodreads.com/author/list/18541?format=xml&key=WsCn5uVo7T5kMJNQqR8n3Q", ResponseClass.class);

        System.out.println("Authentication is: " + responseClass.getRequestClass().isAuthentication());
        System.out.println("Key is: " + responseClass.getRequestClass().getKey());
        System.out.println("Method is: " + responseClass.getRequestClass().getMethod());

        System.out.println("Author's id is: " + responseClass.getAuthor().getId());
        System.out.println("Author's name is: " + responseClass.getAuthor().getName());
        System.out.println("Author's link is: " + responseClass.getAuthor().getLink());*/


        System.out.println("Books are: " + response.getBody());

    }

    @Override
    public void run(String... args) throws Exception {
        callRestService();
    }
}
