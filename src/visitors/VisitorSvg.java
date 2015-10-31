package visitors;

import java.awt.Graphics2D;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import utils.Point2D;

public class VisitorSvg extends Visitor{
  @Override
  public String visitPen(int thickness, int[] rgbColorCode, Object[] optionnalParams) {
    return "stroke-width=\"" + thickness + "\" " 
            + "stroke=\"rgb(" + rgbColorCode[0] + ","
            + rgbColorCode[1] + ","
            + rgbColorCode[2]
            + ")\"";
  }

  @Override
  public String visitTextTool(String fontName, int fontSize, String fontStyle,
      int[] rgbColorCode, Object[] optionalParams) {
    return "font-family=\"" + fontName + "\" "
        + "font-size=\"" + fontSize + "\" "
        + "stroke=\"rgb(" + rgbColorCode[0] + ","
        + rgbColorCode[1] + ","
        + rgbColorCode[2] + ","
        + ")\""; 
  }

  @Override
  public String visitPolygonalPath(Point2D[] points, boolean closed,
      Object[] optionalParams) {
    String svgCode = "d=\"";
    
    svgCode += "M" + points[0].getX() + " " + points[0].getY();
    for (int i = 1; i < points.length; i++) {
      svgCode += " L" + points[i].getX() + " " + points[i].getY();
    }
    
    if (closed) {
      svgCode += " Z";      
    }
    
    svgCode += "\"";
    return svgCode;
  }

  @Override
  public String visitOperator(Drawing[] drawings, Object[] optionalParams) {
    String svgCode = "";
    for (int i = 0; i < drawings.length; i++) {
      svgCode += drawings[i].render(this, optionalParams);
    }
    return svgCode;
  }

  @Override
  public String visitDraw(Path path, Tool tool, Object[] optionalParams) {
    String svgCode = "<path ";
    svgCode += path.render(this, optionalParams) + " ";
    svgCode += tool.render(this, optionalParams);
    svgCode += "/>\n";
    return svgCode;
  }

  @Override
  public void visitExport(Drawing drawing, int height, int width) {
    String svgCode = "<svg height=\"" + height 
        + "\" width=\"" + width 
        + "\" xmlns=\"http://www.w3.org/2000/svg\">\n";
    svgCode += drawing.render(new VisitorSvg(), null);
    svgCode += "</svg>";
    System.out.println(svgCode);
  }
}
