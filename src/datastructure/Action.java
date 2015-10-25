package datastructure;

import java.awt.Graphics2D; 

/**
 * This abstract class allows the user to easily add new types of actions 
 * (basic types being Draw, Fill, Insert and Labelise).
 * If the user wants to add a new "export" mode (basic export modes are 
 * to SVG and to Java), they need to declare new abstract and non-abstract 
 * methods:
 * <code>
 *   public abstract void applyNewExportModeAction();
 *   public void generateNewExportModeDrawing() {
    this.applyNewExportModeAction();
  }
 * </code>
 * The <code>applyNewExportModeAction</code> method will have to be implemented 
 * for all types of actions.
 * 
 */
public abstract class Action extends Drawing {
  /*============================================*/ 
  /*==============  Shared Methods =============*/
  /*============================================*/
  
  
  /*===============================================================*/
  /*============ Methods dedicated to each export mode ============*/
  /*===============================================================*/

  /*
   * These abstracts methods are implemented by each type of action.
   * They are necessary to interpret the logical drawing in a given export
   * mode. 
   */
  /**
   * Generates the svg code of the wanted element.
   * @return the svg element code
   */
  public abstract String applySvgAction();
  /**
   * Applies the Java code of the given action to the graphic g.
   * @param graph is a graphic element
   */
  public abstract void applyJavaAction(Graphics2D graph);
  

  /*
   * These methods are just meant to have more meaningful methods names
   */
  @Override
  public String generateSvgCode() {
    return this.applySvgAction();
  }
  
  @Override
  public void generateJavaCode(Graphics2D graph) {
    this.applyJavaAction(graph);
  }

}
