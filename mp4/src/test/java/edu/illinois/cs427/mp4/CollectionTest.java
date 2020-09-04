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

public class CollectionTest {
    @Test public void testRestoreCollection1() throws Exception{
        //TODO implement this
        Collection col1 = new Collection("col1");
        Book booktest1 = new Book("aa1","bb1");
        Book booktest2 = new Book("aa2","bb2");
        col1.addElement(booktest1);
        col1.addElement(booktest2);

        String jsonText = col1.getStringRepresentation();
        Collection col2= new Collection("col1");
        col2 = Collection.restoreCollection(jsonText);

        assertEquals(col2.getName(),col1.getName());
        assertEquals(((Book)(col2.getElements().get(0))).getTitle(),((Book)(col1.getElements().get(0))).getTitle());
        assertEquals(((Book)(col2.getElements().get(0))).getAuthor(),((Book)(col1.getElements().get(0))).getAuthor());


    }

    @Test public void testGetStringRepresentation1() throws Exception{
        //TODO implement this
        Collection col1 = new Collection("col1");
        Book booktest1 = new Book("aa1","bb1");
        Book booktest2 = new Book("aa2","bb2");
        col1.addElement(booktest1);
        col1.addElement(booktest2);

        Collection col2 = new Collection("col1");
        Book booktest3 = new Book("aa1","bb1");
        Book booktest4 = new Book("aa2","bb2");
        col2.addElement(booktest3);
        col2.addElement(booktest4);

        String jsonText1 = col1.getStringRepresentation();
        String jsonText2 = col2.getStringRepresentation(); 
        assertEquals(jsonText1,jsonText2); 

    }

    @Test public void testAddElement1() {
        //TODO implement this
        Collection col1 = new Collection("col1");
        Book booktest1 = new Book("aa1","bb1");
        Book booktest2 = new Book("aa2","bb2");
        col1.addElement(booktest1);
        col1.addElement(booktest2);

        List<Element> elements = new ArrayList<Element>();
        elements.add(booktest1);
        elements.add(booktest2);
        assertEquals(elements,col1.getElements());
    }

    @Test public void testDeleteElement1() {
        Collection col1 = new Collection("col1");
        Book booktest1 = new Book("aa1","bb1");
        col1.addElement(booktest1);
        col1.deleteElement(booktest1);
        assertEquals(0,col1.getElements().size()); 
    }
}
