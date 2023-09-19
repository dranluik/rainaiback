package ee.valiit.rainaiback.util;

import java.nio.charset.StandardCharsets;

public class ContentConverter {


    public static byte[] getBytesArrayFromContent(String content) {
        return content.getBytes(StandardCharsets.UTF_8);
    }



}


