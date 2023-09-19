package ee.valiit.rainaiback.util;

import ee.valiit.rainaiback.domain.lesson.Lesson;

import java.nio.charset.StandardCharsets;

public class ContentConverter {


    public static byte[] getBytesArrayFromContent(String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }


    public static String getContentAsString(byte[] content) {
        if (content == null) {
            return "";
        }
        return new String(content, StandardCharsets.UTF_8);
    }
}


