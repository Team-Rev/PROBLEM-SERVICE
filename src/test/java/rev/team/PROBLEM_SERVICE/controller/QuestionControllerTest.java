package rev.team.PROBLEM_SERVICE.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuestionControllerTest {

    @LocalServerPort
    int port;

    TestRestTemplate client = new TestRestTemplate();

    @DisplayName("1. Get question")
    @Test
    void test1(){
        String result = client.getForObject("http://localhost:" + port + "/question/256", String.class);

        System.out.println(result);
        assertNotNull(result);
    }

    @DisplayName("2. Get range question")
    @Test
    void test2(){
        String result = client.getForObject("http://localhost:" + port + "/rangeQuestion?start=261&end=270", String.class);

        System.out.println(result);
        assertNotNull(result);
    }


}