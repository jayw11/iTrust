package edu.illinois.cs427.mp4;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import java.io.StringWriter;

/**

 * This class contains the information needed to represent a book.
 */
public final class Book extends Element {
    private String title;
    private String author;
    /**
     * Builds a book with the given title and author.
     *
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Builds a book from the string representation, 
     * which contains the title and author of the book. 
     *
     * @param stringRepresentation the string representation
     */
    public Book(String stringRepresentation) throws Exception {
        // TODO implement this
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(stringRepresentation);
        JSONObject jo = (JSONObject) obj; 
        
        this.title = (String)jo.get("title");
        this.author = (String)jo.get("author");
    }

    /**
     * Returns the string representation of the given book.
     * The representation contains the title and author of the book.
     *
     * @return the string representation
     */
    public String getStringRepresentation() throws Exception{
        // TODO implement this
        JSONObject obj = getJSONObjectRepresentation();

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();
        return jsonText;
    }
    public JSONObject getJSONObjectRepresentation(){
      JSONObject obj = new JSONObject();
      obj.put("type", "book");
      obj.put("title", title);
      obj.put("author", author);
      return obj;
    }

    /**
     * Returns all the collections that this book belongs to directly and indirectly.
     * Consider the following. 
     * (1) Computer Science is a collection. 
     * (2) Operating Systems is a collection under Computer Science. 
     * (3) The Linux Kernel is a book under Operating System collection. 
     * Then, getContainingCollections method for The Linux Kernel should return a list 
     * of these two collections (Operating Systems, Computer Science), starting from 
     * the direct collection to more indirect collections.
     *
     * @return the list of collections
     */
    public List<Collection> getContainingCollections() {
        // TODO implement this
        Collection parent = this.getParentCollection();
        //String parentName = parent.getName();
        List<Collection> list = new ArrayList<Collection>();
        list.add(parent);
        while(parent.getParentCollection() != null){
            //System.out.println(parent.getName());
            parent = parent.getParentCollection();
            list.add(parent);
        }
        return list;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        // TODO implement this
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        // TODO implement this
        return author;
    }
}
