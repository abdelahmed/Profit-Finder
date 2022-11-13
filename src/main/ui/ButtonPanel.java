package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton addItem;
    private JButton save;
    private JButton load;

    Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK,1,true);

    public ButtonPanel() {
        this.setPreferredSize(new Dimension(500,50));
        this.setBackground(Color.white);

        addItem = new JButton("Add Item");
        addItem.setBorder(buttonBorder);
        addItem.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        this.add(addItem);
        this.setVisible(true);

        save = new JButton("Save");
        save.setBorder(buttonBorder);
        save.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        this.add(save);
        this.setVisible(true);

        load = new JButton("Load");
        load.setBorder(buttonBorder);
        load.setFont(new Font("Sans-serif",Font.PLAIN, 20));
        this.add(load);
        this.setVisible(true);
    }


    public JButton getAddItem() {
        return addItem;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getLoad() {
        return load;
    }
}