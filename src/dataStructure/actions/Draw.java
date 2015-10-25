package dataStructure.actions;

import dataStructure.Action;
import dataStructure.Path;
import dataStructure.Tool;

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
