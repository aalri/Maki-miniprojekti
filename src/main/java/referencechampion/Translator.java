package referencechampion;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Translator {

    private FileWriter fw;
    private HashMap<Character, String> specialChars;

    public Translator(FileWriter fw) {
        this.fw = fw;
        this.specialChars = new HashMap();
        specialChars.put('ä', "\\\"{a}");
        specialChars.put('ö', "\\\"{o}");
        specialChars.put('å', "\\aa");
    }

    public String translateReference(Reference reference, String type) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("@");
        sb.append(type);
        sb.append("{");
        sb.append(reference.getField("key"));
        sb.append(",\n");
        for (String field : reference.getFields()) {
            appendField(sb, field, reference);
        }
        sb.append("}\n");
        writeInFile(sb.toString());
        return sb.toString();
    }
    
//    public void translateBook(Book book) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("@book{");
//        sb.append(book.getField("key"));
//        sb.append(",\n");
//        for (String field : book.getFields()) {
//            appendField(sb, field, book);
//        }
//        sb.append("}\n");
//        System.out.println(sb.toString());
//        writeInFile(sb.toString());
//    }

    private void appendField(StringBuilder sb, String field, Reference reference) {
        sb.append("\t");
        sb.append(capsuleUpperCases(field));
        sb.append(" = ");
        inputParam(sb, reference.getField(field));
    }

    private  String capsuleUpperCases(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                sb.append("{");
                sb.append(processSpecialCharacters(s.charAt(i)));
                sb.append("}");
            } else {
                sb.append(processSpecialCharacters(s.charAt(i)));
            }
        }
        return sb.toString();
    }
    
   private String processSpecialCharacters(char charAt) {
        Character lowercaseChar = Character.toLowerCase(charAt);
        
        if (specialChars.containsKey(lowercaseChar)) {
            return specialChars.get(lowercaseChar);
        }
        return charAt + "";
    }

    private void inputParam(StringBuilder sb, String field) {
        sb.append("\"");
        String compiledfield = capsuleUpperCases(field);
        sb.append(compiledfield);
        sb.append("\",\n");
    }

    private void writeInFile(String bibtexString) throws IOException {
            fw.write(bibtexString);

    }
}
