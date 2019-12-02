package tst;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class RestStepsTest {

    private URL url;

    {
        try {
            url = new URL("https://jsonplaceholder.typicode.com/users");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGet() {
        System.out.println("-> id: " + Thread.currentThread().getId());
        given().when().get(url).then().statusCode(200);
    }

    @Test
    public void testGetResponseHeader() {
        System.out.println("-> id: " + Thread.currentThread().getId());
        ResponseSpecification spec = new ResponseSpecBuilder()
                .expectContentType("application/json; charset=utf-8")
                .build();

        given().when().get(url).then().spec(spec);
    }

    @Test
    public void testGetBody() {
        System.out.println("-> id: " + Thread.currentThread().getId());
        given().when().get(url).then().assertThat().body("size()", is(10));
    }
}
