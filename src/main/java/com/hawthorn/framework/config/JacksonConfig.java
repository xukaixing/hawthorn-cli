package com.hawthorn.framework.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: jackson配置类
 * @author:andy.ten@tom.com
 * @date:2020/8/23 5:37 下午
 * @version v1.0.1
 */
@Configuration
public class JacksonConfig
{
  /**
   * @remark: 对mapper对象进行设置，所有序列化的对象都将按改规则进行系列化
   * <p>
   * 适用的是@JsonFormat和@DateTimeFormat注解
   * 该方式只能指定一种日期的格式，但是前端可能传递各种类型的日期格式，所以推荐使用自定义Json日期转换器@JsonSerialize
   * </p>
   * @param: builder
   * @return: com.fasterxml.jackson.databind.ObjectMapper
   * <p></p>
   * @author: andy.ten@tom.com
   * @date: 2020/8/23 6:28 下午
   * @version: 1.0.1
   * Modification History:
   * Date         Author          Version            Description
   * -----------------------------------------------------------
   * 2020/8/23    andy.ten        v1.0.1             init
   */
  @SuppressWarnings("deprecation" )
  @Bean
  @Primary
  @ConditionalOnMissingBean(ObjectMapper.class)
  public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder)
  {
    ObjectMapper objectMapper = builder.createXmlMapper(false).build();


    // Include.ALWAYS 默认
    // Include.NON_DEFAULT 属性为默认值不序列化
    // Include.NON_EMPTY 属性为 空（""） 或者为 NULL 都不序列化，则返回的json是没有这个字段的。这样对移动端会更省流量
    // Include.NON_NULL 属性为NULL 不序列化
    //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

    // 转换LocalDateTime,对应实体类dto上的@JsonFormat和@DateTimeFormat
    JavaTimeModule javaTimeModule = new JavaTimeModule();
    javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd" )));
    javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss" )));
    javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss" )));
    objectMapper.registerModule(javaTimeModule);
    // 取消将java.util.Date属性序列化为timestamps时间戳形式
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    // 是否允许对象忽略json中不存在的属性
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    // 允许出现特殊字符和转义符
    objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    // 允许出现单引号
    objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
    // 字段保留，将null值转为""
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator,
//                                  SerializerProvider serializerProvider)
//                    throws IOException {
//                jsonGenerator.writeString("");
//            }
//        });
    return objectMapper;
  }
}
