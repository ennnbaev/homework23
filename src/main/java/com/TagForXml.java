package com;

public class TagForXml {
    static public String addWordInBeginTag(String word) {
        String beginTag = "<";
        String endTag = ">";
        return beginTag + word + endTag;
    }

    static public String addWordInEndTag(String word) {
        String beginTag = "<";
        String endTag = ">";
        String closeTag = "/";
        return beginTag + closeTag + word + endTag;
    }
}
