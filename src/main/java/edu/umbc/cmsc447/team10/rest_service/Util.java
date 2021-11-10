package edu.umbc.cmsc447.team10.rest_service;

import java.lang.reflect.Field;

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
}
