package ui;

import javax.swing.*;
import java.awt.*;

public class Title extends JPanel {
    public Title() {
        this.setPreferredSize(new Dimension(500,50));
        this.setBackground(Color.WHITE);

        JLabel titleText = new JLabel("Profit Finder");
        titleText.setFont(new Font("Sans-serif", Font.BOLD,30));
        titleText.setHorizontalAlignment(JLabel.CENTER);
        titleText.setPreferredSize(new Dimension(200,30));

        this.add(titleText);
        this.setVisible(true);
    }

}
