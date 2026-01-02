package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimCardActivatorStepDefinitions {

    private final RestTemplate restTemplate = new RestTemplate();
    private ResponseEntity<String> activationResponse;
    private ResponseEntity<String> queryResponse;
    private String iccid;

    private static final String BASE_URL = "http://localhost:8080";

    @Given("the SIM card ICCID {string}")
    public void the_sim_card_iccid(String iccid) {
        this.iccid = iccid;
    }

    @When("I submit an activation request")
    public void i_submit_an_activation_request() {
        String url = BASE_URL + "/sim/activate";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String body = "{ \"iccid\": \"" + iccid + "\" }";
        HttpEntity<String> request = new HttpEntity<>(body, headers);

        activationResponse = restTemplate.postForEntity(url, request, String.class);
    }

    @Then("the activation should be successful")
    public void the_activation_should_be_successful() {
        assertEquals(HttpStatus.OK, activationResponse.getStatusCode());
    }

    @Then("the activation should fail")
    public void the_activation_should_fail() {
        assertEquals(HttpStatus.BAD_REQUEST, activationResponse.getStatusCode());
    }

    @Then("the SIM status should be {string}")
    public void the_sim_status_should_be(String expectedStatus) {
        String url = BASE_URL + "/sim/" + iccid + "/status";

        queryResponse = restTemplate.getForEntity(url, String.class);

        assertEquals(HttpStatus.OK, queryResponse.getStatusCode());
        assertTrue(queryResponse.getBody().contains(expectedStatus));
    }
}
