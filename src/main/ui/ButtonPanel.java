package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private JButton addItem;

    Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK,1,true);

    public ButtonPanel() {
        this.setPreferredSize(new Dimension(500,50));
        this.setBackground(Color.white);

        addItem = new JButton("Add Item");
        addItem.setBorder(buttonBorder);
        addItem.setFont(new Font("Sans-serif",Font.PLAIN, 20));

        this.add(addItem);
        this.setVisible(true);
    }


    public JButton getAddItem() {
        return addItem;
    }
}