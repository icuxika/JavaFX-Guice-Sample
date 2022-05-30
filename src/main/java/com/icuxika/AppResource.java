package com.icuxika;

import java.net.URL;

public class AppResource {
    public static URL load(String path) {
        return AppResource.class.getResource(path);
    }

}
