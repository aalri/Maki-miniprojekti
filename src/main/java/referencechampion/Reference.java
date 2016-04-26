
package referencechampion;

import java.io.Serializable;
import java.util.List;

public interface Reference extends Serializable {

    String getField(String key);
    
    void addValue(String key, String value);

    List<String> getFields();
    
    String getType();

    public String toString();
}
