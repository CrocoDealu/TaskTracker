package Containers;

import Model.Tasks.Task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JSONRepository extends TaskMapContainer{
    private final FileWriter fileW;
    private final FileReader fileR;
    public JSONRepository(String path) throws IOException {
        fileW = new FileWriter(path);
        fileR = new FileReader(path);
    }

    public void save() throws IOException {
        for (Task t: this.getAll()) {
            String s = t.toJSON();
            fileW.write(s);
        }
    }

    public void read() throws IOException {
        BufferedReader reader = new BufferedReader(fileR);
        StringBuilder json = new StringBuilder();
        String line;

        line = reader.readLine();
        while ((line = reader.readLine()) != null) {
            json.append(line);
        }
        reader.close();
        if (!json.isEmpty()) {
            String jsonString = json.toString();
            int id = Integer.parseInt(jsonString.split("\"id\": ")[1].split(",")[0].trim());
            String description = jsonString.split("\"description\": \"")[1].split("\"")[0].trim();
            String status = jsonString.split("\"status\": \"")[1].split("\"")[0].trim();
        }
    }
}
