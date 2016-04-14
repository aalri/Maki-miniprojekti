package referencechampion;

public class ArticleValidator {
    public boolean validate(Article article) {
        return validateField(article.getField("journal")) && validateField(article.getField("author")) && validateField(article.getField("title")) && validateField(article.getField("year"));
    }
    
    private boolean validateField(String field) {
        return field!=null && !field.equals("");
    }
}
