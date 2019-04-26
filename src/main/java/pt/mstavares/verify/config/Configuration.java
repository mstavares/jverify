package pt.mstavares.verify.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static final String KEYSTORE_PATH = "keystorePath";
    private static final String KEYSTORE_PASSWORD = "keystorePassword";
    private static final String DEBUG_MODE = "debugMode";

    private Properties properties = new Properties();

    public Configuration(String config) throws IOException {
        properties.load(new FileInputStream(config));
    }

    public String getKeystorePath() {
        return properties.getProperty(KEYSTORE_PATH);
    }

    public String getKeystorePassword() {
        return properties.getProperty(KEYSTORE_PASSWORD);
    }

    public boolean isDebugModeOn() {
        return Boolean.parseBoolean((String) properties.get(DEBUG_MODE));
    }

}
