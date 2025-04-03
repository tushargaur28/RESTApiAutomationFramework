package graphQL;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class GraphQLScript {
	public static void main(String[] args) {

		// Query
		String queryResponse = given().log().all().header("Content-Type", "application/json").body(
				"{\"query\":\"query($species:String!,$name:String!,$gender:String,$status:String)\\n{\\n  characters(filters:{species:$species,name:$name,gender:$gender,status:$status})\\n  {\\n    info{\\n      count\\n      pages\\n    }\\n    result{\\n      name\\n      type\\n      status\\n      species\\n      gender\\n    }\\n  }\\n}\\n   \",\"variables\":{\"species\":\"Human\",\"name\":\"Tushar\",\"gender\":\"Male\",\"status\":\"Alive\"}}")
				.when().post("https://rahulshettyacademy.com/gq/graphql").then().log().all().extract().response()
				.asString();

		System.out.println(queryResponse);

		JsonPath js = new JsonPath(queryResponse);
		int characterCount = js.getInt("data.characters.info.count");
		assert characterCount == 25;
		
		// Mutation
		String mutationResponse = given().log().all().header("Content-Type", "application/json").body(
				"{\"query\":\"mutation($locationName:String!,$characterName:String!,$episodeName:String!){\\n  createLocation(location:{name:$locationName,type:\\\"Apartment\\\",dimension:\\\"32\\\"})\\n  {\\n    id\\n  }\\n  createCharacter(character:{name:$characterName,type:\\\"Human\\\",status:\\\"Alive\\\",species:\\\"Human\\\",gender:\\\"Male\\\",image:\\\"png\\\",originId:19838,locationId:19838})\\n  {\\n    id\\n  }\\n  createEpisode(episode:{name:$episodeName,air_date:\\\"Jan 05, 2025\\\",episode:\\\"1\\\"})\\n  {\\n    id\\n  }\\n}\",\"variables\":{\"locationName\":\"NZ\",\"characterName\":\"Ria\",\"episodeName\":\"I am ria\"}}")
				.when().post("https://rahulshettyacademy.com/gq/graphql").then().log().all().extract().response()
				.asString();
		System.out.println(mutationResponse);
		System.out.println("testing github demo");
		
	}

	
	

}
