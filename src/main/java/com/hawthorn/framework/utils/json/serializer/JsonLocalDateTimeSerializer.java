package com.hawthorn.framework.utils.json.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.hawthorn.framework.constant.FormatConstant;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @copyright: Copyright (c) 2020 andyten
 * <p></p>
 * @remark: 针对dto，处理LocalDateTime按指定格式序列化，@JsonDeserialize(using = JsonLocalDateTimeSerializer.class)
 * @author:andy.ten@tom.com
 * @date:2020/8/23 5:31 下午
 * @version v1.0.1
 */
public class JsonLocalDateTimeSerializer extends JsonSerializer<LocalDateTime>
{
  @Override
  public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException
  {
    if (value == null)
    {
      gen.writeString("" );
      return;
    }
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(FormatConstant.FULL_DATE_TIME_FORMAT);
    gen.writeString(dateFormat.format(value));
  }
}
