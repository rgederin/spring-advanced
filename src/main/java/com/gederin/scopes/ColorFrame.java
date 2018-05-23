package com.gederin.scopes;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Random;

import javax.swing.*;

@Service
@Scope("prototype")
public abstract class ColorFrame extends JFrame {

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        Random random = new Random();

        setLocation(random.nextInt(800), random.nextInt(400));

        getContentPane().setBackground(getColor());

        repaint();
    }

    protected abstract Color getColor();
}
