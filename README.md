How to read array, json object and list of json object from a json configuration file with Spring Boot.<br/>
<br/>
How to compile and execute :<br/>
mvn package<br/>
java -jar ./target/readListAndHashMapFromAJsonFile-0.0.1-SNAPSHOT.jar<br/>
<br/>
<br/>
---myConfiguration.json<br/>
{<br/>
&nbsp;&nbsp;"myStringList" : [<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"arrayString1",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"arrayString2"<br/>
&nbsp;&nbsp;],<br/>
&nbsp;&nbsp;"mySingleNestedObject" : {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"myNestedString1":"qwerty1",<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"myNestedString2":"qwerty2"<br/>
&nbsp;&nbsp;},<br/>
&nbsp;&nbsp;"myNestedObjectList" : [{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"nestedObject1" : "value1"<br/>
&nbsp;&nbsp;},{<br/>
&nbsp;&nbsp;&nbsp;&nbsp;"nestedObject2" : "value2"<br/>
&nbsp;&nbsp;}]<br/>
}<br/>
---MyJsonPropertySourceFactory.java<br/>
Map readValue = new ObjectMapper().readValue(resource.getInputStream(), Map.class);<br/>
return new MapPropertySource("json-property", readValue);<br/>
---MyConfigurationBean.java<br/>
@PropertySource(<br/>
&nbsp;&nbsp;value = "classpath:myConfiguration.json", <br/>
&nbsp;&nbsp;factory = MyJsonPropertySourceFactory.class)<br/>
...<br/>
private List&lt;String&gt; myStringList = new ArrayList&lt;String&gt;();<br/>
private HashMap&lt;String, String&gt; mySingleNestedObject;<br/>
private List&lt;HashMap&lt;String, String&gt;&gt; myNestedObjectList = new ArrayList&lt;HashMap&lt;String, String&gt;&gt;();<br/>
+getter and setter<br/>
---The class who displays the value of the 'myString' configuration<br/>
@Autowired<br/>
MyConfigurationBean myConf;<br/>
...<br/>
System.out.println(myConf.getMyStringList());<br/>
System.out.println(myConf.getMySingleNestedObject());<br/>
System.out.println(myConf.getMyNestedObjectList());<br/>
<br/>
<br/>
The application will read the values in array, json object and list of json object from the configuration file then display them in the terminal.<br/>


