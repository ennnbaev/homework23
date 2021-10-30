package com;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Car car = new Car("BMW", "520");
        System.out.println(convertClassToXML(car));
    }

    static public String convertClassToXML(Object input) throws IllegalAccessException {
        String nextLine = "\n";
        StringBuilder xml = new StringBuilder();
        Class getClass = input.getClass();
        String className = getClass.getSimpleName().toLowerCase();
        xml.append(TagForXml.addWordInBeginTag(className)).append(nextLine);
        Field[] fields = getClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!field.isAnnotationPresent(Ignore.class)) {
                if (field.isAnnotationPresent(Pseudonym.class)) {
                    xml.append(TagForXml.addWordInBeginTag(field.getDeclaredAnnotation(Pseudonym.class).value()));
                    xml.append(field.get(input));
                    xml.append(TagForXml.addWordInEndTag(field.getDeclaredAnnotation(Pseudonym.class)
                            .value())).append(nextLine);
                } else {
                    xml.append(TagForXml.addWordInBeginTag(field.getName()));
                    xml.append(field.get(input));
                    xml.append(TagForXml.addWordInEndTag(field.getName())).append(nextLine);
                }
            }
        }
        xml.append(TagForXml.addWordInEndTag(className));
        return xml.toString();
    }


}
