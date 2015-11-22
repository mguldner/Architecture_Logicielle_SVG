package datastructure.actions;

import datastructure.Action;
import datastructure.Drawing;
import datastructure.Path;
import managers.ColorManager;
import visitors.Visitor;


/**
 * This class is the representation of one type of Action.
 * This action insert a drawing delimited with a path inside an other drawing.
 */
public class Insert implements Action {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * drawing: The original drawing.
   * drawingToInsert: The drawing to insert.
   */

  private Drawing drawing;
  private Path[] paths;
//  private Drawing drawingToInsert;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  /**
   * Construct a drawing by filling a closed path.
   * @param path the closed path to fill.
   * @param color the color with which the path has to be filled.
   */
 /* public Insert(Drawing drawing, Drawing drawingToInsert) {
    if (!path.isClosed()) {
      throw new Error("Path is not closed : unable to fill");
    }
    this.path = path;
    this.color = color;
  }*/
  public Insert(Drawing drawing, Path[] paths){
    this.drawing = drawing;
    this.paths = paths;
  }
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitInsert(drawing, paths, optionalParams);
  }

}
