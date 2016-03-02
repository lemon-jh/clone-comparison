package leaderus.study.clone.entry;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
* @Description: 比较 深/浅 clone 
* @author 张福泉 zhang_91026@163.com 
* @date 2016年3月1日 下午4:58:49 
*/
public class MyInfo implements Cloneable{

    private Set<String> enabledFeature;
    
    private boolean enabled;
    
    public MyInfo(Set<String> enabledFeature, boolean enabled) {
		super();
		this.enabledFeature = enabledFeature;
		this.enabled = enabled;
	}

	protected Object clone() throws CloneNotSupportedException {
    	MyInfo info = (MyInfo) super.clone();
    	if(enabledFeature == null){
    		info.enabledFeature = new HashSet<String>();
    		for (String string : enabledFeature) {
    			info.enabledFeature.add(string);
			}
    	}
    	return info;
    }

	@Override
	public boolean equals(Object o) {
		
		if (o == null) {
            return false;
        }
		
		if (!(o instanceof MyInfo)){
			return false;
		}
		
        if (getClass() != o.getClass()) {
            return false;
        }
        
        MyInfo obj = (MyInfo) o;
        
		return (this.enabled == obj.enabled)
			&& (this.enabledFeature == null ? obj.enabledFeature == null :equalsWithSets(obj.enabledFeature));
	}
	
	private boolean equalsWithSets(Set<String> set) {
		
		if(enabledFeature == null || set == null || (enabledFeature.size() != set.size())){
			return false ;
		}
		
		Iterator<String> it = set.iterator();
		
        while (it.hasNext()) {  
        	if(!enabledFeature.contains(it.next())){
        		return false;
        	}
        }  
		
		return true;
	}

	public Set<String> getEnabledFeature() {
		return enabledFeature;
	}

	public void setEnabledFeature(Set<String> enabledFeature) {
		this.enabledFeature = enabledFeature;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
    
    
}
