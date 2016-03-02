package leaderus.study.clone;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import leaderus.study.clone.entry.MyCloneableObj;
import leaderus.study.clone.entry.MyInfo;

/**
* @Description: shallow Clone / Deep Clone test
* @author 张福泉 zhang_91026@163.com 
* @date 2016年3月2日 上午11:12:56 
*/
public class CloneTest {
	
	public static Set<String> s1 = new HashSet<String>();
	public static Set<String> s2 = new HashSet<String>();
	public static Set<String> s3 = new HashSet<String>();
	public static Set<String> s4 = new HashSet<String>();
	public static Set<String> s5 = new HashSet<String>();
	
	private static String myId = "20160301";
	
	private static MyCloneableObj obj;
	
	static {
		
		for(int i=0;i<10;i++){
			s1.add(new Random().nextInt(100000)+"");
			s2.add(new Random().nextInt(100000)+"");
			s3.add(new Random().nextInt(100000)+"");
			s4.add(new Random().nextInt(100000)+"");
			s5.add(new Random().nextInt(100000)+"");
		}
		
		Map<String,MyInfo> myInfos = new HashMap<String, MyInfo>();
		
		myInfos.put("s1", new MyInfo(s1,true)); 
		
		myInfos.put("s2", new MyInfo(s2,new Random().nextInt(2)==0)); 
		
		myInfos.put("s3", new MyInfo(s3,new Random().nextInt(2)==0)); 
		
		myInfos.put("s4", new MyInfo(s4,new Random().nextInt(2)==0)); 
		
		myInfos.put("s5", new MyInfo(s5,new Random().nextInt(2)==0)); 
		
		obj = new MyCloneableObj(myInfos,myId,new Date());
	}
	
	
	public static void cloneTest() {
		
		MyCloneableObj obj2 = (MyCloneableObj) obj.clone();
		
		System.out.println(obj == obj2);
		
		System.out.println(obj.equals(obj2));
	}
	
	public static void ModifyAttr() {
		
		MyCloneableObj obj2 = (MyCloneableObj) obj.clone();
		
		obj2.getMyInfos().get("s1").setEnabled(false);
		
		System.out.println(obj == obj2);
		
		System.out.println(obj.equals(obj2));
	}

	public static void main(String[] args){
		ModifyAttr();
	}
}
