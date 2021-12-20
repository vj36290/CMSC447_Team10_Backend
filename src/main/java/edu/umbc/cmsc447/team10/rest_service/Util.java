package edu.umbc.cmsc447.team10.rest_service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

public final class Util {
    public static String toStringReflective(Object obj) {
        StringBuilder sb = new StringBuilder();
        for (Field f : obj.getClass().getDeclaredFields()) {
            try {
                f.setAccessible(true);
                sb.append(f.getName()).append(": ").append(f.get(obj)).append("\n");
            } catch (Exception ex) {
                ;
            }
        }
        // - 2 to cut off the last newline
        return sb.substring(0, sb.length() > 1 ? sb.length() - 1 : sb.length());
    }

    public static <T> void unpackToField(Object object, Field field, Function<String, T> converter, Map<String, String> map) {
        try {
            field.setAccessible(true);
            T value = null;
            String mappedValue = map.get(field.getName());

            if (mappedValue == null)
                return;

            if (converter != null)
                value = converter.apply(mappedValue);
            else
                value = (T) mappedValue;

            field.set(object, value);
        } catch (Exception ex) {
            ex.printStackTrace();
            // TODO more specific exception handling
        }
    }
}
