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
 * Represents a collection of books or (sub)collections.
 */
public final class Collection extends Element {
    List<Element> elements;
    private String name;
    
    /**
     * Creates a new collection with the given name.
     *
     * @param name the name of the collection
     */
    public Collection(String name) {
        elements = new ArrayList<Element>();
        this.name = name;
        this.setParentCollection(null);
    }

    /**
     * Restores a collection from its given string representation.
     *
     * @param stringRepresentation the string representation
     */
    /*public static Collection restoreCollection(String stringRepresentation) throws Exception{
        // TODO implement this
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(stringRepresentation);
        JSONObject jo = (JSONObject) obj; 
        
        String name1 = (String)jo.get("Name");
        Collection col = new Collection(name1);
        col.elements = (List<Element>)jo.get("Elements");
        return col;
    }*/

    public static Element restore(JSONObject element){
        if(((String)element.get("type")).equals("book")){
            String title = (String)element.get("title");
            String author = (String)element.get("author");
            Book b = new Book (title, author);
            return (Element)b;
        } else{
            String name = (String)element.get("name");
            JSONArray json_elements = (JSONArray)element.get("elements");
            Collection col = new Collection(name);

            for(int i = 0; i < json_elements.size(); i++){
                  JSONObject element1 = (JSONObject)json_elements.get(i);
                  col.elements.add(restore(element1));
            }
            return (Element)col;
        }
    }
    /**
     * Restores a collection from its given string representation.
     *
     * @param stringRepresentation the string representation
     */
    public static Collection restoreCollection(String stringRepresentation) throws Exception{
        // TODO implement this
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(stringRepresentation);

        String name = (String)object.get("name");
        JSONArray json_elements = (JSONArray)object.get("elements");
        Collection col = new Collection(name);

        for(int i = 0; i < json_elements.size(); i++)
        {
              JSONObject element1 = (JSONObject)json_elements.get(i);
              col.elements.add(restore(element1));
        }
        return col;
    }

    /**
     * Returns the string representation of a collection. 
     * The string representation should have the name of this collection, 
     * and all elements (books/subcollections) contained in this collection.
     *
     * @return string representation of this collection
     */
    /*public String getStringRepresentation() throws Exception{
        JSONObject obj = new JSONObject();
        obj.put("type","Collection");
        obj.put("Name",name);
        //obj.put("Elements", elements);

        for (i = 0; i < elements.length; i++) { 
            x = elements[i]; 
            System.out.print(x + " "); 
        } 

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        String jsonText = out.toString();
        System.out.println(jsonText);
        return jsonText;
    }*/

    public String getStringRepresentation() throws Exception{
        JSONObject obj = getJSONObjectRepresentation();


        StringWriter out = new StringWriter();
        obj.writeJSONString(out);

        String jsonText = out.toString();
        return jsonText;
    }

    public JSONObject getJSONObjectRepresentation(){
      JSONObject obj = new JSONObject();
      obj.put("type", "collection");
      obj.put("name", name);

      JSONArray ja = new JSONArray();

      for(int i = 0; i < elements.size(); i++){
        JSONObject jo = ((Book)elements.get(i)).getJSONObjectRepresentation();
        ja.add(jo);
      }

      obj.put("elements", ja);
      return obj;
    }


    /**
     * Returns the name of the collection.
     *
     * @return the name
     */
    public String getName() {
        // TODO implement this
        return name;
    }
    
    /**
     * Adds an element to the collection.
     * If parentCollection of given element is not null,
     * do not actually add, but just return false.
     * (explanation: if given element is already a part of  
     * another collection, you should have deleted the element 
     * from that collection before adding to another collection)
     *
     * @param element the element to add
     * @return true on success, false on fail
     */
    public boolean addElement(Element element) {
        // TODO implement this
        if(element.getParentCollection() != null){return false;}
        elements.add(element);
        element.setParentCollection(this);
        return true;
    }
    
    /**
     * Deletes an element from the collection.
     * Returns false if the collection does not have 
     * this element.
     * Hint: Do not forget to clear parentCollection
     * of given element 
     *
     * @param element the element to remove
     * @return true on success, false on failCollection
     */
    public boolean deleteElement(Element element) {
        // TODO implement this
        if(!elements.contains(element)){return false;}
        element.setParentCollection(null);
        elements.remove(element);

        return true;
    }
    
    /**
     * Returns the list of elements.
     * 
     * @return the list of elements
     */
    public List<Element> getElements() {
        // TODO implement this
        return elements;
    }
}
