package datastructure.actions;

import datastructure.Action;
import datastructure.Path;
import factories.actions.FillFactory;
import managers.ColorManager;
import visitors.Visitor;


/**
 * This class is the representation of one type of Action.
 * This action fill the inside of a closed path with a color.
 */
public class Fill<T> implements Action<T>, FillFactory {
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * path: Path to follow.
   * color: Color to use.
   */
  private Path path;
  private ColorManager color;
  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public Fill(){}
  /**
   * Construct a drawing by filling a closed path.
   * @param path the closed path to fill.
   * @param color the color with which the path has to be filled.
   */
  private Fill(Path path, ColorManager color) {
    if (!path.isClosed()) {
      throw new Error("Path is not closed : unable to fill");
    }
    this.path = path;
    this.color = color;
  }
  
  private Fill(Path path) {
    this(path, new ColorManager());
  }
    
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public Visitor<T> render(Visitor<T> visitor, Object[] optionalParams) {
    return visitor.visitFill(path, color, optionalParams);
  }

  @Override
  public Fill createFill(Path path, ColorManager color) {
    return new Fill(path, color);
  }

  @Override
  public Fill createFill(Path path) {
    return new Fill(path);
  }

}
