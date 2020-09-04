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
import java.io.FileReader;
import java.io.FileWriter;  

public class LibraryTest {
    @Test public void testLibraryConstructorFromFile1() throws Exception {
        //TODO implement this
        String filename = "file.txt";
        Library lib1 = new Library();

        Collection col1 = new Collection("col1");
        Book booktest1 = new Book("aa1","bb1");
        Book booktest2 = new Book("aa2","bb2");
        col1.addElement(booktest1);
        col1.addElement(booktest2);

        lib1.addCollection(col1);
        lib1.saveLibraryToFile(filename);

        Library lib2 = new Library(filename);

        assertEquals(lib1.getCollections().size(),lib2.getCollections().size());

    }

    @Test public void testSaveLibraryToFile1() throws Exception{
        //TODO implement this
    	String filename = "file1.txt";
        Library lib1 = new Library();

        Collection col1 = new Collection("col1");
        Book booktest1 = new Book("aa1","bb1");
        Book booktest2 = new Book("aa2","bb2");
        col1.addElement(booktest1);
        col1.addElement(booktest2);

        lib1.addCollection(col1);
        lib1.saveLibraryToFile(filename);

        Library lib2 = new Library(filename);
        assertEquals(lib1.getCollections().get(0).getName(),lib2.getCollections().get(0).getName());
        assertEquals("aa1",((Book)(col1.getElements().get(0))).getTitle());
        assertEquals("bb1",((Book)(col1.getElements().get(0))).getAuthor());

    }

    @Test public void testEmptyCollection() throws Exception{
        //TODO implement this
        Library lib1 = new Library();
        assertEquals(0,lib1.getCollections().size());
    }

    @Test public void testAddCollection() throws Exception{
        //TODO implement this
        Library lib1 = new Library();
        Collection col1 = new Collection("col1");
        lib1.addCollection(col1);
        assertEquals(1,lib1.getCollections().size());
    }
    /*@Test public void testEmptyFileName() throws Exception{
        String filename = "";
        Library lib1 = new Library();

        Collection col1 = new Collection("col1");
        Book booktest1 = new Book("aa1","bb1");
        Book booktest2 = new Book("aa2","bb2");
        col1.addElement(booktest1);
        col1.addElement(booktest2);

        lib1.addCollection(col1);
        try {lib1.saveLibraryToFile(filename);}catch (Exception e) {
        	assertEquals(e,"Something went wrong");
        }
    }*/
}
