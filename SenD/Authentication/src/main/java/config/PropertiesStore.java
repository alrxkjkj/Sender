package config;

import utils.druid.DruidRead;

import java.io.*;
import java.util.Properties;

public class PropertiesStore {
    public String value(String filename,String key) throws IOException {
        Properties pro = new Properties();
        InputStream resourceAsStream = DruidRead.class.getClassLoader().getResourceAsStream(filename);
        pro.load(resourceAsStream);
        return pro.getProperty(key);
    }
}
