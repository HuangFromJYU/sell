package edu.jyu.sell.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * Date类型转换成Long类型工具类
 * @author Jason
 * @create 2017-12-18 20:54
 **/
public class Date2LongSerializer extends JsonSerializer<Date>{

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        long time = date.getTime()/1000;
        jsonGenerator.writeNumber(time);
    }
}
