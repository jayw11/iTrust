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


public class BookTest {
    @Test public void testBookConstructor1() {
        Book booktest = new Book("aa","bb");
        assertEquals("aa",booktest.getTitle());
        assertEquals("bb",booktest.getAuthor()); 
    }


    @Test public void testGetStringRepresentation1() throws Exception{
        //TODO implement this
        Book b1 = new Book("aa","bb");
        String str = b1.getStringRepresentation();

        Book b2 = new Book(str);
        assertEquals(b1.getTitle(),b2.getTitle()); 
        assertEquals(b1.getAuthor(),b2.getAuthor()); 

    }

    @Test public void testGetContainingCollections1() {
        //TODO implement this
        Book b1 = new Book("aa","bb");
        Collection c1 = new Collection("col1");
        c1.addElement(b1);
        ArrayList<Collection> o = new ArrayList<Collection>();
        o.add(c1);
        assertEquals(o,b1.getContainingCollections()); 
    }
    @Test public void testGetContainingCollections2() {
        Book b1 = new Book("aa","bb");
        Collection c1 = new Collection("col1");
        Collection c2 = new Collection("col2");
        c1.addElement(b1);

        c2.addElement(c1);
        ArrayList<Collection> o = new ArrayList<Collection>();
        o.add(c1);
        o.add(c2);
        assertEquals(o,b1.getContainingCollections()); 
    }
    /*@Test public void testBookConstructor2() {
        Book b1 = new Book("{\"Price\":5,\"author\":\"Ben\",\"title\":\"Stods\"}");
        JSONObject obj = b1.toJSONObject();
        assertEquals(5,b1.obj.getInt("Price")); 
    }*/
}
