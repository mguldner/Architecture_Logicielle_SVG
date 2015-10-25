package datastructure.actions;

import java.awt.Graphics2D;

import datastructure.Action;
import datastructure.Path;
import datastructure.Tool;

/**
 * This class is the representation of one type of Action.
 * This action draws a path with a tool.
 */
public class Draw extends Action {
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/
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
	public void applyJavaAction(Graphics2D g) {
		// TODO Auto-generated method stub
	  tool.applyJavaTool(g);
	  path.generateJavaPath(g);
	}

}
