
package referencechampion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class BookTest {
    
    private Book book;
    
    public BookTest() {
    }
    

    @Before
    public void setUp() {
        HashMap<String,String> values= new HashMap<String,String>();
        values.put("key", "key");
        values.put("title", "title");
        values.put("author", "author");
        values.put("publisher", "publisher");
        book = new Book(values);
    }
    
    @Test
    public void fieldNamesAreReturnedCorrectly() {
    }
    
    @Test
    public void constructorSetsFieldsCorrectly() {
        assertEquals("author", book.getAuthor());
    }
    
}
