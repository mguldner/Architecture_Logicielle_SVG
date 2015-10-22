package dataStructure;
/**
 * 
 * This interface is the base of all the model structure.
 * The structure is defined as a tree, tree that has leaves (actions) and subtrees (operators).
 *
 */
public interface Drawing {
	public void generateSvgDrawing();
	public void generateJavaDrawing();
}
