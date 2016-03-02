package leaderus.study.clone;

import java.util.HashMap;
import java.util.Map;

public class MapEqualsTest {

	private String name;
	
	private String age;

	public MapEqualsTest(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		MapEqualsTest s = (MapEqualsTest) obj;  
        return name.equals(s.name) && age.equals(s.age);  
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		
		MapEqualsTest test = new MapEqualsTest("acb","acb");
		
		MapEqualsTest test1 = new MapEqualsTest("acb","acb");
		
		Map<String,MapEqualsTest> map = new HashMap<String, MapEqualsTest>();
		
		map.put("1", test);
		
		map.put("2", test1);
		
		System.out.println(map.get("1") == map.get("2"));
		
		System.out.println(map.get("1").equals(map.get("2")));
		
	}
}
