package com.kmitl.pectjro.Frame.Tools;

import java.awt.*;
import javax.swing.*;

public class Image_Resizer extends JPanel {
    private Image image;
    private int height;
    private int width;
    public Image_Resizer(ImageIcon image, int height, int width){
        this.image = image.getImage();
        this.height = height;
        this.width = width;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gp = (Graphics2D) g;
        gp.drawImage(image, 0, 0, width, height, this);
    }
}
