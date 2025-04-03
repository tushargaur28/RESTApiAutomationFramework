package oAuth2_0;

import static io.restassured.RestAssured.given;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class oAuthTest {

	public static void main(String[] args) {

//		Web Automation of login has been disabled by google		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
//		driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//		driver.findElement(By.id("identifierId")).sendKeys("gaur.tushar281@gmail.com");
//		driver.findElement(By.linkText("identifierId")).click();
//		driver.findElement(By.name("Passwd")).sendKeys("Tushar@28");
//		driver.findElement(By.linkText("identifierId")).click();
//		String url = driver.getCurrentUrl();

//		Manually login using the getCode url, login successfully, copy the url and paste below as a workaround
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AQSTgQECpI4kcoUgu7rATZ_4jbGjb1Bq-3JQYXQulllM_HzD3SsMglZarRCFfNjiKbCYMg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=consent";
		String partialCode = url.split("code=")[1];
		String authorizationCode = partialCode.split("&scope")[0];
		String accessTokenResponse = given().urlEncodingEnabled(false).queryParams("code", authorizationCode)
				.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParams("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").asString();

		JsonPath js = new JsonPath(accessTokenResponse);
		String accessToken = js.getString("access_token");
		String response = given().contentType("application/json").queryParams("access_token", accessToken).expect()
				.defaultParser(Parser.JSON).when().get("https://www.googleapis.com/oauth2/v3/userinfo").asString();
		System.out.println("Response is here -->" + response);
	}

}
