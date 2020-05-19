package readListAndHashMapFromAJsonFile.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import readListAndHashMapFromAJsonFile.mySourceFactory.MyJsonPropertySourceFactory;

@Component
@PropertySource(
		  value = "classpath:myConfiguration.json", 
		  factory = MyJsonPropertySourceFactory.class)
@ConfigurationProperties
public class MyConfigurationBean {
	private List<String> myStringList = new ArrayList<String>();
    private HashMap<String, String> mySingleNestedObject;
    private List<HashMap<String, String>> myNestedObjectList = new ArrayList<HashMap<String, String>>();
	public List<String> getMyStringList() {
		return myStringList;
	}
	public void setMyStringList(List<String> myStringList) {
		this.myStringList = myStringList;
	}
	public HashMap<String, String> getMySingleNestedObject() {
		return mySingleNestedObject;
	}
	public void setMySingleNestedObject(HashMap<String, String> mySingleNestedObject) {
		this.mySingleNestedObject = mySingleNestedObject;
	}
	public List<HashMap<String, String>> getMyNestedObjectList() {
		return myNestedObjectList;
	}
	public void setMyNestedObjectList(List<HashMap<String, String>> myNestedObjectList) {
		this.myNestedObjectList = myNestedObjectList;
	}
}