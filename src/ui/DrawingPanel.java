package ui;

import shapes.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class DrawingPanel extends JPanel {

    public ArrayList<MyShape> shapes=new ArrayList<>();
    private MyShape currentShape;

    public String tool="LINE";
    public Color color=Color.BLACK;
    public boolean filled=false;
    public boolean dotted=false;

    int x1,y1;

    // Temporary shape used for live preview while dragging
    private MyShape previewShape;

    public DrawingPanel(){

        // Start drawing
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                x1=e.getX(); y1=e.getY();

                if(tool.equals("FREE")){
                    currentShape=new FreeHandShape(color);
                }
            }

            // Finalizes shape when mouse is released
            public void mouseReleased(MouseEvent e){
                int x2=e.getX(), y2=e.getY();

                switch(tool){
                    case "LINE":
                        shapes.add(new LineShape(x1,y1,x2,y2,color,dotted)); break;
                    case "RECT":
                        shapes.add(new RectShape(x1,y1,x2,y2,color,filled,dotted)); break;
                    case "OVAL":
                        shapes.add(new OvalShape(x1,y1,x2,y2,color,filled,dotted)); break;
                    case "ERASER":
                        shapes.add(new EraserShape(x1,y1,x2,y2)); break;
                }

                previewShape = null; // clears preview
                repaint();
            }
        });

// Updates preview shape while dragging mouse
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e){

                int x2 = e.getX();
                int y2 = e.getY();

                if(tool.equals("LINE")){
                    previewShape = new LineShape(x1,y1,x2,y2,color,dotted);
                }
                else if(tool.equals("RECT")){
                    previewShape = new RectShape(x1,y1,x2,y2,color,filled,dotted);
                }
                else if(tool.equals("OVAL")){
                    previewShape = new OvalShape(x1,y1,x2,y2,color,filled,dotted);
                }
                else if(tool.equals("ERASER")){
                    previewShape = new EraserShape(x1,y1,x2,y2);
                }
                else if(tool.equals("FREE")){
                    ((FreeHandShape)currentShape).addPoint(x2,y2);
                    shapes.add(currentShape);
                }

                repaint();
            }
        });
    }

    // Undo last action
    public void undo(){
        if(!shapes.isEmpty())
            shapes.remove(shapes.size()-1);
        repaint();
    }

    // Clear all drawings
    public void clearAll(){
        shapes.clear();
        repaint();
    }

    // Convert panel to image
    public BufferedImage getImage(){
        BufferedImage img=new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2=img.createGraphics();
        paint(g2);
        return img;
    }

    // Paint all shapes
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;

        // Draw all saved shapes
        for(MyShape s:shapes){
            s.draw(g2);
        }

// Draw preview shape (while dragging)
        if(previewShape != null){
            previewShape.draw(g2);
        }
    }
}