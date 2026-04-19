package app;

import ui.DrawingPanel;
import utils.ImageManager;

import javax.swing.*;
import java.awt.*;

public class PaintApp extends JFrame {

    public PaintApp(){

        // Initialize window
        setTitle("Paint Brush");
        setSize(1000,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DrawingPanel panel=new DrawingPanel();
        JPanel top=new JPanel();

        JRadioButton red = new JRadioButton("Red");
        JRadioButton green = new JRadioButton("Green");
        JRadioButton blue = new JRadioButton("Blue");

        // Group for choosing one color
        ButtonGroup colorsGroup = new ButtonGroup();
        colorsGroup.add(red);
        colorsGroup.add(green);
        colorsGroup.add(blue);

        JButton line=new JButton("Line");
        JButton rect=new JButton("Rect");
        JButton oval=new JButton("Oval");
        JButton free=new JButton("Free");
        JButton eraser=new JButton("Eraser");

        JButton undo=new JButton("Undo");
        JButton clear=new JButton("Clear");
        JButton save=new JButton("Save");
        JButton open=new JButton("Open");

        JCheckBox filled=new JCheckBox("Filled");
        JCheckBox dotted=new JCheckBox("Dotted");

        // Color selection
        red.addActionListener(e->panel.color=Color.RED);
        green.addActionListener(e->panel.color=Color.GREEN);
        blue.addActionListener(e->panel.color=Color.BLUE);

        // Tool selection
        line.addActionListener(e->panel.tool="LINE");
        rect.addActionListener(e->panel.tool="RECT");
        oval.addActionListener(e->panel.tool="OVAL");
        free.addActionListener(e->panel.tool="FREE");
        eraser.addActionListener(e->panel.tool="ERASER");

        // Options
        filled.addActionListener(e->panel.filled=filled.isSelected());
        dotted.addActionListener(e->panel.dotted=dotted.isSelected());

        // Actions
        undo.addActionListener(e->panel.undo());
        clear.addActionListener(e->panel.clearAll());

        // Save image
        save.addActionListener(e->{
            try{
                JFileChooser fc=new JFileChooser();
                if(fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
                    ImageManager.saveImage(panel.getImage(),fc.getSelectedFile());
                }
            }catch(Exception ex){ex.printStackTrace();}
        });

        // Open image
        open.addActionListener(e->{
            try{
                JFileChooser fc=new JFileChooser();
                if(fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
                    Image img=ImageManager.loadImage(fc.getSelectedFile());
                    panel.getGraphics().drawImage(img,0,0,null);
                }
            }catch(Exception ex){ex.printStackTrace();}
        });

        top.add(red); top.add(green); top.add(blue);
        top.add(line); top.add(rect); top.add(oval); top.add(free); top.add(eraser);
        top.add(filled); top.add(dotted);
        top.add(undo); top.add(clear); top.add(save); top.add(open);

        add(top,BorderLayout.NORTH);
        add(panel,BorderLayout.CENTER);
    }

    // Main method (entry point)
    public static void main(String[] args){
        new PaintApp().setVisible(true);
    }
}
