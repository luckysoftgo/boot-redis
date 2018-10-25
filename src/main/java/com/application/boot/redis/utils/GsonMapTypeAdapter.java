package com.application.boot.redis.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

/**
 * @desc 重新序列化gson的map对象
 * @author 孤狼
 */
public class GsonMapTypeAdapter extends TypeAdapter<Object> {

    @Override
    public Object read(JsonReader in) throws IOException {
        JsonToken token = in.peek();
        switch (token) {
        case BEGIN_ARRAY:
            List<Object> list = new ArrayList<Object>();
            in.beginArray();
            while (in.hasNext()) {
                list.add(read(in));
            }
            in.endArray();
            return list;

        case BEGIN_OBJECT:
            Map<String, Object> map = new LinkedTreeMap<String, Object>();
            in.beginObject();
            while (in.hasNext()) {
                map.put(in.nextName(), read(in));
            }
            in.endObject();
            return map;

        case STRING:
            return in.nextString();

        case NUMBER:
            /**
             * 改写数字的处理逻辑，将数字值分为整型与浮点型。
             */
            double dbNum = in.nextDouble();

            // 数字超过long的最大值，返回浮点类型
            if (dbNum > Long.MAX_VALUE) {
                return dbNum;
            }

            // 判断数字是否为整数值
            long lngNum = (long) dbNum;
            if (dbNum == lngNum) {
                return lngNum;
            } else {
                return dbNum;
            }

        case BOOLEAN:
            return in.nextBoolean();

        case NULL:
            in.nextNull();
            return null;

        default:
            throw new IllegalStateException();
        }
    }

    @Override
    public void write(JsonWriter arg0, Object arg1) throws IOException {
        // TODO Auto-generated method stub

    }

}
