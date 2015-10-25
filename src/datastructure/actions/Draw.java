package datastructure.actions;

import java.awt.Graphics2D;

import datastructure.Action;
import datastructure.Path;
import datastructure.Tool;

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
	public void applyJavaAction() {
		// TODO Auto-generated method stub
	}

}
