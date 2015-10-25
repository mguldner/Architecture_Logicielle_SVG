package datastructure.actions;

import datastructure.Action;
import datastructure.Path;
import datastructure.Tool;

import java.awt.Graphics2D;

/**
 * This class is the representation of one type of Action.
 * This action draws a path with a tool.
 */
public class Draw extends Action {
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
  public Draw(Path path, Tool tool) {
    this.path = path;
    this.tool = tool;
  }
  
  
  /*========================================*/
  /*============ Shared Methods ============*/
  /*========================================*/

  
  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/
  
  /*=================================================*/
  /*================== SVG export ===================*/
  /*=================================================*/
  @Override
  public String applySvgAction() {
    String svgCode = "<path ";
    svgCode += path.generateSvgPath() + " ";
    svgCode += tool.applySvgTool();
    svgCode += "/>\n";
    return svgCode;
  }

  /*=================================================*/
  /*================== Java export ==================*/
  /*=================================================*/
  @Override
  public void applyJavaAction(Graphics2D graph) {
    // TODO Auto-generated method stub
    tool.applyJavaTool(graph);
    path.generateJavaPath(graph);
  }

}
