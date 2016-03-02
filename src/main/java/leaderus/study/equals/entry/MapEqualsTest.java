package leaderus.study.equals.entry;

import java.util.HashMap;
import java.util.Map;

public class MapEqualsTest {

	private String name;
	
	private Integer age;

	public MapEqualsTest(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		MapEqualsTest s = (MapEqualsTest) obj;  
        return name.equals(s.name) && age==s.age;  
	}

	

	//没有重写hashcode的时候可以看到map中有2条记录
	//重写hashcode的时候map中只有一条
	@Override
	public int hashCode() {
		return name.hashCode()+age.hashCode();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	//Hashset、Hashmap、Hashtable中对象作为key,中的equals陷阱
	//使用hashcode 进行比较容器中是否存在相同的值
	public static void main(String[] args) {
		
		MapEqualsTest test = new MapEqualsTest("zhangsan", 18);
		//MapEqualsTest test1 = new MapEqualsTest("zhangsan", 18);
		
		Map<MapEqualsTest,Integer> map = new HashMap<MapEqualsTest, Integer>();
		
		map.put(test, 1);
		
		System.out.println();
		
	}
}
