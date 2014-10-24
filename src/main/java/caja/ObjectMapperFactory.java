/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caja;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 *
 * @author carlos juarez
 */
public class ObjectMapperFactory {

    /**
     * Factory class that creates <code>ObjectMapper</code> objects from Jackson
     * JSON. In order to use it along with Spring MVC you need to define
     * different beans in the Application context file:
     * <bean id="objectMapperFactory" class="com.posabro.web.commons.ObjectMapperFactory"/>
     *
     * <bean id="objectMapper" class="org.codehaus.jackson.map.ObjectMapper" factory-bean="objectMapperFactory" factory-method="instanceObjectMapper"/>
     *
     * and finally
     *
     * <mvc:annotation-driven validator="validator">
     * <mvc:message-converters>
     * <bean class="org.springframework.http.converter.StringHttpMessageConverter"/>
     * <bean class="org.springframework.http.converter.ByteArrayHttpMessageConverter"/>
     * <bean class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter">
     * <property name="objectMapper" ref="objectMapper"/>
     * </bean>
     * </mvc:message-converters>
     * </mvc:annotation-driven>
     *
     * @author Carlos Juarez
     */
    public ObjectMapper instanceObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
//        objectMapper.enableDefaultTypingAsProperty(ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT, "class");

        objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
//        objectMapper.setDateFormat(DateFormat.getDateInstance(DateFormat.LONG));
        return objectMapper;
    }
}
