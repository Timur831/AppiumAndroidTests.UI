package api.utility;

import java.io.IOException;
import java.util.Properties;

public class UBProperties {
    private static Properties props = new Properties();

    public static Properties readConfigurationFile() {
        try {
            props.load(ClassLoader.getSystemResourceAsStream("configAPI.properties"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return props;
    }
}
