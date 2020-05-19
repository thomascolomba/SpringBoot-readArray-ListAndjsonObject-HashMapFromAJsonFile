package readListAndHashMapFromAJsonFile.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyConfigurationDisplayer implements ApplicationListener<ApplicationReadyEvent> {
	@Autowired
	MyConfigurationBean myConf;
	
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		System.out.println("Will display the array(List), json object(HashMap) and array of json object value from the src/main/resources/myConfiguration.json file");
		System.out.println(myConf.getMyStringList());
		System.out.println(myConf.getMySingleNestedObject());
		System.out.println(myConf.getMyNestedObjectList());
	}
}