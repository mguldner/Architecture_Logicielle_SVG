package utils;

/**
 * This class allows drawings to be represented in 2D.
 */
public class Point2D {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/ 
  private int xcoordinate;
  private int ycoordinate;

  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public Point2D() {
    this.xcoordinate = 0;
    this.ycoordinate = 0;
  }
  
  public Point2D(int xcoordinate, int ycoordinate) {
    this.xcoordinate = xcoordinate;
    this.ycoordinate = ycoordinate;
  }

  
  /*============================*/
  /*========== Getters =========*/
  /*============================*/
  public int getX() {
    return xcoordinate;
  }
  
  public int getY() {
    return ycoordinate;
  }
  
  
  /*============================*/
  /*========== Setters =========*/
  /*============================*/
  public void setX(int xcoordinate) {
    this.xcoordinate = xcoordinate;
  }
  
  public void setY(int ycoordinate) {
    this.ycoordinate = ycoordinate;
  }
}
