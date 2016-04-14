/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package referencechampion;

/**
 *
 * @author juhokyyh
 */
public class ReferenceValidator {
    public boolean validate(Reference ref) {
        if (ref.getClass().equals(Book.class)) return (validateBook((Book)ref));
        if (ref.getClass().equals(Article.class)) return (validateArticle((Article)ref));
        if (ref.getClass().equals(Inproceedings.class)) return (validateInproceedings((Inproceedings)ref));
        return false;
    }
    
    private boolean validateBook(Book book) {
        return validateField(book.getField("publisher")) && validateField(book.getField("author")) && validateField(book.getField("title"));
    }
    
    public boolean validateArticle(Article article) {
        return validateField(article.getField("journal")) && validateField(article.getField("author")) && validateField(article.getField("title")) && validateField(article.getField("year"));
    }
    
    public boolean validateInproceedings(Inproceedings inproceedings) {
        return validateField(inproceedings.getField("author")) && validateField(inproceedings.getField("title"))
           &&  validateField(inproceedings.getField("booktitle")) && validateField(inproceedings.getField("year"));
    
    }
        
    private boolean validateField(String field) {
        return field!=null && !field.equals("");
    }
}
