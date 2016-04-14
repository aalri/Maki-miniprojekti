
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package referencechampion;

/**
 *
 * @author alrial
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Inproceedings implements Reference {

    private HashMap<String, String> fields;
    

    public Inproceedings() {
        this("", "", "", "", "", "", "", "", "", "", "", "");
    }

    public Inproceedings(String key, String title, String year, String publisher, String author,
            String volume, String series, String address, String editor, String month,
            String booktitle, String note) {
        fields = new HashMap<String, String>();
        this.fields.put("key", key);
        this.fields.put("title", title);
        this.fields.put("year", year);
        this.fields.put("publisher", publisher);
        this.fields.put("author", author);
        this.fields.put("volume", volume);
        this.fields.put("series", series);
        this.fields.put("address", address);
        this.fields.put("editor", editor);
        this.fields.put("month", month);
        this.fields.put("booktitle", booktitle);
        this.fields.put("note", note);
    }

    public Inproceedings(HashMap<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String getField(String key) {
        return fields.get(key);
    }

    @Override
    public ArrayList<String> getFields() {
        return new ArrayList<String>(this.fields.values());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!obj.getClass().equals(Inproceedings.class)) return false;
        
        Inproceedings inproceedings = (Inproceedings) obj;
        
        return inproceedings.getField("title").equals(this.getField("title")) 
                && inproceedings.getField("author").equals(this.getField("author"));
    }
}
