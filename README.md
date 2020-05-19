How to read Integer, Boolean and String from a json configuration file with Spring Boot.<br/>
<br/>
How to compile and execute :<br/>
mvn package<br/>
java -jar ./target/readSimpleDataFromAJsonFile-0.0.1-SNAPSHOT.jar<br/>
<br/>
<br/>
---myConfiguration.json<br/>
{<br/>
 &nbsp;&nbsp;"myInteger" : 1234,<br/>
&nbsp;&nbsp;"myString" : "qwerty",<br/>
&nbsp;&nbsp;"myBoolean" : true<br/>
}<br/>
---MyJsonPropertySourceFactory.java<br/>
Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);<br/>
return new MapPropertySource("json-property", readValue);<br/>
---MyConfigurationBean.java<br/>
@PropertySource(<br/>
&nbsp;&nbsp;value = "classpath:myConfiguration.json", <br/>
&nbsp;&nbsp;factory = MyJsonPropertySourceFactory.class)<br/>
...<br/>
private Integer myInteger;<br/>
private String myString;<br/>
private Boolean myBoolean;<br/>
+getter and setter<br/>
---The class who displays the value of the 'myString' configuration<br/>
@Autowired<br/>
MyConfigurationBean myConf;<br/>
...<br/>
System.out.println(myConf.getMyInteger());<br/>
System.out.println(myConf.getMyString());<br/>
System.out.println(myConf.getMyBoolean());<br/>
<br/>
<br/>
The application will read the values '1234', 'qwerty' and 'true' from the configuration file then display it in the terminal.<br/>


