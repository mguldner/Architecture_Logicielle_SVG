package dataStructure.actions;

import dataStructure.Action;
import dataStructure.Path;
import dataStructure.Tool;

public class Draw extends Action {
	/**
	 * Variables
	 */
	private Path path;
	private Tool tool;
	
	/**
	 * Constructors
	 */
	public Draw(Path path, Tool tool) {
		// TODO Auto-generated constructor stub
		this.path = path;
		this.tool = tool;
	}

	@Override
	public String applySvgAction() {
		// TODO Auto-generated method stub
		String svgCode = "<path ";
		svgCode += path.generateSvgPath() + " ";
		svgCode += tool.applySvgTool();
		svgCode += "/>\n";
		System.out.println(svgCode);
		return svgCode;

	}

	@Override
	public void applyJavaAction() {
		// TODO Auto-generated method stub

	}

}
