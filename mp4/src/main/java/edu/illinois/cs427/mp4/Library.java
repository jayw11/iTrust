package edu.illinois.cs427.mp4;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.io.StringWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

/**i
 * Container class for all the collections (that eventually contain books).
 * Its main responsibility is to save the collections to a file and restore them from a file.
 */
public final class Library {
    private List<Collection> collections;

    /**
     * Builds a new, empty library.
     */
    public Library() {
        // TODO implement this
        collections = new ArrayList<Collection>();
    }

    /**
     * Builds a new library and restores its contents from the given file.
     *
     * @param fileName the file from where to restore the library.
     */
    public Library(String fileName) throws Exception{
        // TODO implement this
        collections = new ArrayList<Collection>();
        FileReader reader = new FileReader(fileName);
            //Read JSON file
            JSONParser jsonParser = new JSONParser();
            JSONObject jo = (JSONObject)jsonParser.parse(reader);

            JSONArray ja = (JSONArray) jo.get("collections");
            for (int i = 0; i < ja.size(); i++){
              collections.add((Collection)Collection.restore((JSONObject)ja.get(i)));
            }
        
    }

    /**
     * Saved the contents of the library to the given file.
         *
     * @param fileName the file where to save the library
     */
    public void saveLibraryToFile(String fileName)throws Exception{
        // TODO implement this
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        for (int i = 0; i < collections.size(); i++){
          ja.add(collections.get(i).getJSONObjectRepresentation());
        }
        jo.put("collections", ja);
        Writer fileWriter = new FileWriter(fileName);
        fileWriter.write(jo.toJSONString());
        fileWriter.flush();
        /*
        try (FileWriter file = new FileWriter(fileName)) {
                file.write(jo.toJSONString());
            }catch (Exception e) {
        System.err.print("Something went wrong");
        }*/
    }

    /**
     * Returns the collections contained in the library.
     *
     * @return library contained elements
     */
    public List<Collection> getCollections() {
        // TODO implement this
        return collections;
        //return null;
    }

    /**
     * Add collections to the library.
     *
     * @param collection to be added to the library
     */
    public void addCollection(Collection collection) {
        collections.add(collection);
        // TODO implement this
    }
   
}
