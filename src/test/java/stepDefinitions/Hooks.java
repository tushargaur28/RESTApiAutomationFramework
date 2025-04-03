package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws IOException {
		StepDefinition m = new StepDefinition();
//		System.out.println(">>> Running @DeletePlace hook");
		if (StepDefinition.place_id == null) {
			m.add_place_payload_with("Tushar", "Hindi", "Russia");
			m.user_calls_with_http_request("AddPlaceAPI", "POST");
			m.verify_place_id_created_maps_to_using("Tushar", "getPlaceAPI");
		}
	}
}
