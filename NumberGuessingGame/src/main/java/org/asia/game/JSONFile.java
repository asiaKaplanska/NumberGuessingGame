package org.asia.game;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Paths;

public class JSONFile {

    GameUI gameUI = new GameUI();

    public <T> void serialise(T object) {

        var mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try {
            var json = mapper.writeValueAsString(object);
            gameUI.printSerialisedJson(json);
            mapper.writeValue(Paths.get("myFile.json").toFile(), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
