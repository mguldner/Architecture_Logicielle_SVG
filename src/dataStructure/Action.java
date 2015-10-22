package dataStructure;
/**
 * 
 * This abstract class allows the user to easily add new types of actions 
 * (basic types being Draw, Fill, Insert and Labelise)
 * 
 * If the user wants to add a new "export" mode (basic export modes are 
 * to SVG and to Java), they need to declare new abstract and non-abstract 
 * methods:
 * <code>
 * 	public abstract void applyNewExportModeAction();
 * 	public void generateNewExportModeDrawing() {
		this.applyNewExportModeAction();
	}
 * </code>
 * The <code>applyNewExportModeAction</code> method will have to be implemented 
 * for all types of actions.
 * 
 */
public abstract class Action implements Drawing {
	/**
	 * These abstracts methods are implemented by each type of action.
	 * They are necessary to interpret the logical drawing in a given export mode
	 */
	public abstract void applySvgAction();
	public abstract void applyJavaAction();

	public void generateSvgDrawing() {
		this.applySvgAction();
	}

	public void generateJavaDrawing() {
		this.applyJavaAction();
	}

}
