package referencechampion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Article implements Reference {

    private HashMap<String, String> fields;
    

    public Article() {
        this("", "", "", "", "", "", "", "");
    }

    public Article(String key, String title, String year, String journal, String author,
            String volume, String month, String note) {
        fields = new HashMap<String, String>();
        this.fields.put("key", key);
        this.fields.put("title", title);
        this.fields.put("year", year);
        this.fields.put("journal", journal);
        this.fields.put("author", author);
        this.fields.put("volume", volume);
        this.fields.put("month", month);
        this.fields.put("note", note);
    }

    public Article(HashMap<String, String> fields) {
        this.fields = fields;
    }

    @Override
    public String getField(String key) {
        return fields.get(key);
    }

    @Override
    public Set<String> getFields() {
        return this.fields.keySet();
    }

}
