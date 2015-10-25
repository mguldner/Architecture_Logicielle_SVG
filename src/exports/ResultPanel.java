package exports;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import datastructure.Drawing;

public class ResultPanel extends JPanel {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  private Drawing drawing;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public ResultPanel(Drawing d) {
    super();
    this.drawing = d;
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
  public void paintComponent(Graphics graphics) {
    Graphics2D g = (Graphics2D) graphics;
    Drawing drawing = this.getDrawing();
    drawing.generateJavaCode(g);
  }
}
