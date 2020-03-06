package com.example.springbootproject.client;

import com.example.springbootproject.entity.googleapis.BookVolume;
import com.example.springbootproject.entity.googleapis.IndustryIdentifiers;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
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
        System.out.println("Total Pages: " + employeeTotal.getTotal_pages());*/

        RestTemplate restTemplate = new RestTemplate();
        BookVolume bookVolume = restTemplate.getForObject("https://www.googleapis.com/books/v1/volumes/xYotngEACAAJ", BookVolume.class);

        System.out.println("Kind is: " + bookVolume.getKind());
        System.out.println("Id is: " + bookVolume.getId());
        System.out.println("Self Link is: " + bookVolume.getSelfLink());

        System.out.println("Title is: " + bookVolume.getVolumeInfo().getTitle());
        System.out.println("Authors are: " + bookVolume.getVolumeInfo().getAuthors()[0]);
        System.out.println("Publisher is: " + bookVolume.getVolumeInfo().getPublisher());
        System.out.println("Published date is: " + bookVolume.getVolumeInfo().getPublishedDate());
        System.out.println("Description is: " + bookVolume.getVolumeInfo().getDescription());

        IndustryIdentifiers[] identifiers = bookVolume.getVolumeInfo().getIndustryIdentifiers();

        for(IndustryIdentifiers identifier:identifiers){
            System.out.println("Industry identifiers are: "
                    + "Type is: " + identifier.getType()
                    + " Identifier is: " + identifier.getIdentifier());
        }

        System.out.println("Reading modes are: " + bookVolume.getVolumeInfo().getReadingModes().isText()
                + " " + bookVolume.getVolumeInfo().getReadingModes().isImage());


        System.out.println("Page count is: " + bookVolume.getVolumeInfo().getPageCount());
        System.out.println("Printed Page count is: " + bookVolume.getVolumeInfo().getPrintedPageCount());

        System.out.println("Dimensions are: "
                + bookVolume.getVolumeInfo().getDimensions().getHeight()
                + " " + bookVolume.getVolumeInfo().getDimensions().getWidth()
                + " " + bookVolume.getVolumeInfo().getDimensions().getThickness());

        System.out.println("Categories are: " + bookVolume.getVolumeInfo().getCategories()[0]);

        System.out.println("country: " + bookVolume.getAccessInfo().getCountry());
        System.out.println("viewability: " + bookVolume.getAccessInfo().getViewability());
        System.out.println("embeddable: " + bookVolume.getAccessInfo().isEmbeddable());
        System.out.println("publicDomain: " + bookVolume.getAccessInfo().isPublicDomain());
        System.out.println("textToSpeechPermission: " + bookVolume.getAccessInfo().getTextToSpeechPermission());
        System.out.println("epub: " + bookVolume.getAccessInfo().getEpub().isAvailable());
        System.out.println("pdf: " + bookVolume.getAccessInfo().getPdf().isAvailable());
        System.out.println("webLinkReader: " + bookVolume.getAccessInfo().getWebLinkReader());
        System.out.println("accessViewStatus: " + bookVolume.getAccessInfo().getAccessViewStatus());
        System.out.println("quoteSharingAllowed: " + bookVolume.getAccessInfo().isQuoteSharingAllowed());


    }



    @Override
    public void run(String... args) throws Exception {
        callRestService();
    }
}
