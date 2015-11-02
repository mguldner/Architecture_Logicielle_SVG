package exports;

import datastructure.Drawing;
import visitors.VisitorJava;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * This class allows the representation of the drawing 
 * with the Graphics2D library.
 */
public class ResultPanel extends JPanel { 
  private static final long serialVersionUID = -6598904090856293425L;
  
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  private Drawing drawing;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public ResultPanel(Drawing drawing) {
    super();
    this.drawing = drawing;
  }
  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  public Drawing getDrawing() {
    return this.drawing;
  }
  
  /*============================*/
  /*========== Methods =========*/
  /*============================*/
  @Override
  public void paintComponent(Graphics graphics) {
    Graphics2D graph = (Graphics2D) graphics;
    Object[] params = {graph};
    Drawing drawing = this.getDrawing();
    drawing.render(new VisitorJava(), params);
  }
}
