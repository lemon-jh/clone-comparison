package leaderus.study.clone.entry;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
* @Description: 比较 深/浅 clone 主类
* @author 张福泉 zhang_91026@163.com 
* @date 2016年3月1日 下午4:58:49 
*/
public class MyCloneableObj implements Cloneable{
	
	
    private Map<String,MyInfo> myInfos;//深度clone,需要将集合中的每一项进行深度clone
    
    private String myId;
    
    private Date validDate;
    
    public MyCloneableObj(Map<String, MyInfo> myInfos, String myId, Date validDate) {
		super();
		this.myInfos = myInfos;
		this.myId = myId;
		this.validDate = validDate;
	}

	public Object clone() {
		try{
	    	MyCloneableObj o = (MyCloneableObj) super.clone();
	    	o.validDate = (Date) validDate.clone();
	    	if(myInfos != null){
	    		o.myInfos = new HashMap<String, MyInfo>();
	    		for (Map.Entry<String, MyInfo> entry : myInfos.entrySet()) {
	    			o.myInfos.put(entry.getKey(), (MyInfo)entry.getValue().clone());
				}
	    	}
	    	return o;
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return null;
    }

	public boolean equals(Object o) {
		
		if (o == null) {
            return false;
        }
		
		if (!(o instanceof MyCloneableObj)){
			return false;
		}
		
        if (getClass() != o.getClass()) {
            return false;
        }
        
		MyCloneableObj obj = (MyCloneableObj) o;
		return (this.myId == null ? obj.getMyId() == null : this.myId.equals(obj.getMyId()))
			&& (this.validDate == null ? obj.getValidDate() == null : this.validDate.getTime() == obj.getValidDate().getTime())
			&& (this.myInfos == null ? obj.myInfos == null :equalsWithMaps(obj.myInfos));
	}
	
	private boolean equalsWithMaps(Map<String,MyInfo> map) {
		
		if(myInfos == null || map == null || (myInfos.size() != map.size())){
			return false ;
		}
		
		for(Map.Entry<String,MyInfo> entry:map.entrySet()) {
			//map的containsKey中有equals陷阱
			//在使用对象类型时,需要重写对象的hashcode方法
		
			if(!this.myInfos.containsKey(entry.getKey()) || !this.myInfos.get(entry.getKey()).equals(entry.getValue())){
				return false;
			}
		}
		
		return true;
	}

	public Map<String, MyInfo> getMyInfos() {
		return myInfos;
	}

	public void setMyInfos(Map<String, MyInfo> myInfos) {
		this.myInfos = myInfos;
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
    
    
}
