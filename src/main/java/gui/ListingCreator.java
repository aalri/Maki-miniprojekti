
package gui;

import gui.actionlisteners.RemoveReference;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import referencechampion.Reference;
import referencechampion.ReferenceBase;


public class ListingCreator {
    
    public static List<ListedReference> createListedReferences(List<Reference> references, Container container, ReferenceBase base, ActionListener al, JFrame frame, UI ui) {

        List<ListedReference> list = new ArrayList<ListedReference>();
        int index = 1;
        for (Reference r : references) {
            ListedReference lr = new ListedReference(r, container, new RemoveReference(r, base, frame), al, index, ui);
            list.add(lr);
            index ++;
        }

        return list;
    }

    public static void clearListedReferences(List<ListedReference> references) {
        if (references != null) {
            for (ListedReference lr : references) {
                lr.clear();
            }
            references.clear();
        }
    }
}
