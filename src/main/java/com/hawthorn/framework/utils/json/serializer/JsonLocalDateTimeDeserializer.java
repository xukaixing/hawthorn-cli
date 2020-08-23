package com.hawthorn.framework.utils.json.serializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.hawthorn.framework.utils.common.Str2Util;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 针对dto，处理LocalDateTime按指定格式反序列化， @JsonSerialize(using = JsonLocalDateTimeSerializer.class)
 * @author:andy.ten@tom.com
 * @date:2020/8/23 5:23 下午
 * @version v1.0.1
 */
@Slf4j
public class JsonLocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime>
{
  @Override
  public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException
  {
    String date = p.getText();
    try
    {
      if (Str2Util.isEmpty(date))
      {
        return null;
      } else
      {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(date)), ZoneOffset.of("+8" ));
      }
    } catch (Exception e)
    {
      log.error("json转LocalDateTime序列化失败，将值设置为null" );
      return null;
    }
  }
}
