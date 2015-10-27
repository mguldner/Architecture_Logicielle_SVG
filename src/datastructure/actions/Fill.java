package datastructure.actions;

import datastructure.Action;
import datastructure.Path;
import managers.ColorManager;
import visitors.Visitor;


/**
 * This class is the representation of one type of Action.
 * This action draws a path with a tool.
 */
public class Fill extends Action {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * path: Path to follow.
   * tool: Tool to use.
   */
  private Path path;
  private ColorManager color;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  /**
   * Construct a drawing by filling a closed path.
   * @param path the closed path to fill.
   * @param color the color with which the path has to be filled.
   */
  public Fill(Path path, ColorManager color) {
    if (!path.isClosed()) {
      throw new Error("Path is not closed : unable to fill");
    }
    this.path = path;
    this.color = color;
  }
  
  public Fill(Path path) {
    this(path, new ColorManager());
  }
    
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitFill(path, color, optionalParams);
  }

}
