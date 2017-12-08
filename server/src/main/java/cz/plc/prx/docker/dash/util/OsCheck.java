package cz.plc.prx.docker.dash.util;

import org.apache.commons.lang.SystemUtils;

public class OsCheck {
    private static String detectedOS;

    public static String getOperatingSystemType() {
        if (SystemUtils.IS_OS_MAC_OSX) {
            detectedOS = System.getProperty("os.name");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            detectedOS = System.getProperty("os.name");
        } else if (SystemUtils.IS_OS_LINUX) {
            detectedOS = System.getProperty("os.name");
        }
        return detectedOS;
    }
}