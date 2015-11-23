package datastructure.actions;

import datastructure.Action;
import datastructure.Drawing;
import datastructure.Path;
import factories.actions.InsertFactory;
import visitors.Visitor;


/**
 * This class is the representation of one type of Action.
 * This action insert a drawing delimited with a path inside an other drawing.
 */
public class Insert<T> implements Action<T>, InsertFactory {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * drawing: The original drawing.
   * drawingToInsert: The drawing to insert.
   */

  private Drawing drawing;
  private Path[] paths;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public Insert(){}
  
  /**
   * Construct a drawing by filling a closed path.
   * @param path the closed path to fill.
   * @param color the color with which the path has to be filled.
   */
  private Insert(Drawing drawing, Path[] paths) {
    this.drawing = drawing;
    this.paths = paths;
  }
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams) {
    return visitor.visitInsert(drawing, paths, optionalParams);
  }

  @Override
  public Insert createInsert(Drawing drawing, Path[] paths) {
    return new Insert(drawing, paths);
  }

}
