package com.types.util;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/*
 * Painel customizado para colocar imagens de fundo
 */
@SuppressWarnings("serial")
public class ImagePanel extends JPanel{

    private Image image;

    public ImagePanel(String path) {
       image = new ImageIcon(getClass().getResource("/" + path)).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this); // see javadoc for more info on the parameters            
    }

}
