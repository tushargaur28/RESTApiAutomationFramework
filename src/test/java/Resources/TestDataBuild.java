package Resources;

import java.util.ArrayList;
import java.util.List;

import Pojo.AddPlace;
import Pojo.Location;

public class TestDataBuild {
public AddPlace addPlacePayload(String name, String language, String address) {
	AddPlace ap = new AddPlace();
	ap.setAccuracy(50);
	ap.setAddress(address);
	ap.setLanguage(language);
	ap.setName(name);
	ap.setPhone_number("(+91) 983 893 3937");
	ap.setWebsite("http://google.com");

	List<String> myList = new ArrayList<String>();
	myList.add("shoe park");
	myList.add("shop");
	ap.setTypes(myList);

	Location l = new Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	ap.setLocation(l);
	return ap;
}

	public String deletePlacePayload(String placeId) {
		return "{\n    \"place_id\":\""+placeId+"\"\n}\n";
	}
}
