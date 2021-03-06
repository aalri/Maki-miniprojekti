/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Container;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alrial
 */
public class Field {

    private String name;
    private JTextField field;
    private JLabel text;
    private Container container;
    protected UI ui;

    public Field(String name, Container container, boolean required, UI ui) {
        this(name, name, container, required, ui);
    }

    public Field(String name, String textBoxName, Container container, boolean required, UI ui) {
        this.name = name;
        this.field = new JTextField();
        this.field.setName(textBoxName);
        if (required) name += "*";
        this.text = new JLabel(name);
        this.container = container;
        this.container.add(this.field);
        this.container.add(this.text);
        this.ui = ui;
    }

    public String getText() {
        return this.field.getText();
    }

    public void setText(String text) {
        this.field.setText(text);
    }

    public void setPosition(int x, int y) {
        this.text.setBounds(x, y, 100, 30);
        this.field.setBounds(x + 120, y, 300, 30);
    }

    public void clear() {
        this.container.remove(this.field);
        this.container.remove(this.text);
    }
}
