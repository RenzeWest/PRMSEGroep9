package com.groep9.moviemingleserver.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Config {

    private static final String CONFIG_PATH = "options.json";

    private final String databasePassword;
    private final String databaseUser;
    private final String databaseURL;

    public Config() {
        File configFile = new File(CONFIG_PATH);

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(configFile);

            // assign values
            this.databasePassword = rootNode.get("databasePassword").asText();
            this.databaseUser = rootNode.get("databaseUser").asText();
            this.databaseURL = rootNode.get("databaseURL").asText();

        } catch (IOException e) {
            throw new RuntimeException("Failed to read config file.");
        }

    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public String getDatabaseURL() {
        return databaseURL;
    }
}
