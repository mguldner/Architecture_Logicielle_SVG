package datastructure.actions;

import datastructure.Action;
import datastructure.Path;
import datastructure.Tool;
import factories.actions.DrawFactory;
import visitors.Visitor;

/**
 * This class is the representation of one type of Action.
 * This action draws a path with a tool.
 */
public class Draw implements Action, DrawFactory{
  /*==============================*/
  /*========== Variables =========*/
  /*==============================*/
  /**
   * path: Path to follow.
   * tool: Tool to use.
   */
  private Path path;
  private Tool tool;

  
  /*=================================*/
  /*========== Constructors =========*/
  /*=================================*/
  public Draw(){}
  
  private Draw(Path path, Tool tool) {
    this.path = path;
    this.tool = tool;
  }
  
  public Path getPath() {
    return this.path;
  }
  
  public Tool getTool() {
    return tool;
  }
  
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/
  @Override
  public String render(Visitor visitor, Object[] optionalParams) {
    return visitor.visitDraw(this.getPath(), this.getTool(), optionalParams);
  }

  @Override
  public Draw createDraw(Path path, Tool tool) {
    return new Draw(path, tool);
  }

}
