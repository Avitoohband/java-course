package app.core.com.company.restTemplates;

import app.core.com.company.beans.Employee;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CompanyClient {

    private RestTemplate rt = new RestTemplate();


    public Object getOne(long id) throws RestClientException{
        String url = "http://localhost:8080/api/get-one/" + id;
        try {
            //define a request with http method and uri
            RequestEntity<?> req = new RequestEntity<>(HttpMethod.GET, new URI(url));
            // make the request and get a response
            ResponseEntity<Employee> res = rt.exchange(req,Employee.class);
            // get the response body (where the data that i wanted can be found)
            return res.getBody();
        } catch (URISyntaxException e) {
            return "Error has occurred";
        }catch (RestClientException ex){
            return ex.getMessage();
        }

    }
    public List<Employee> getAll(){
        try{
            String url = "http://localhost:8080/api/get-all";
            RequestEntity<?> req = new RequestEntity<>(HttpMethod.GET, new URI(url));
            ResponseEntity<List> res = rt.exchange(req, List.class);
            return (List<Employee>) res.getBody();
        }catch (URISyntaxException e) {
            return new ArrayList<>();
        }
    }
    public Object add(Employee employee){
        try {
            String url = "http://localhost:8080/api/";
            RequestEntity<Employee> req = new RequestEntity<>(employee, HttpMethod.POST, new URI(url));
            ResponseEntity<Long> res = rt.exchange(req, Long.class);
            return res.getBody();
        } catch (URISyntaxException e) {
            return "Error has occurred";
        }
    }
    public List<Employee> getAllByName(String name){
        try{
            String url = "http://localhost:8080/api/get-all-names?name=" + name;
            RequestEntity<?> req = new RequestEntity<>(HttpMethod.GET, new URI(url));
            ResponseEntity<List> res = rt.exchange(req, List.class);
            return (List<Employee>) res.getBody();
        }catch (URISyntaxException e) {
            return new ArrayList<>();
        }
    }

}
