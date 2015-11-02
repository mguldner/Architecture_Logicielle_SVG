package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.tools.TextTool;
import managers.ColorManager;
import utils.Point2D;
import utils.UsefulFunctions;

public class VisitorSvg extends Visitor{
  
  public static int numberOfPathsDef = 0;

  @Override
  public String visitPen(int thickness, int[] rgbColorCode, Object[] optionnalParams) {
    return "stroke-width=\"" + thickness + "\" " 
        + "stroke=\"rgb(" + rgbColorCode[0] + ","
        + rgbColorCode[1] + ","
        + rgbColorCode[2]
            + ")\"";
  }

  @Override
  public String visitTextTool(String fontName, int fontSize, int fontStyle,
      int[] rgbColorCode, Object[] optionalParams) {
    return "font-family=\"" + fontName + "\" "
        + "font-size=\"" + fontSize + "\" "
        + "style=\"stroke:rgb(" + rgbColorCode[0] + ","
        + rgbColorCode[1] + ","
        + rgbColorCode[2]
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
  public String visitLoop(Drawing[] drawings, String change, Object[] changeparams, 
      Object[] optionalParams) {
    String svgCode = "";
    if (change == "rotation") {
      for (int i = 0; i < drawings.length; i++) {
        svgCode += "<g transform=\"rotate(" + (double)changeparams[0] * i + " 0 0)\">";
        svgCode += drawings[i].render(this, optionalParams);
        svgCode += "</g>";
      }
    }
    if (change == "translation") {
      for (int i = 0; i < drawings.length; i++) {
        svgCode += "<g transform=\"translate(" + (double)changeparams[0] * i + " " 
            + (double)changeparams[1] * i + ")\">";
        svgCode += drawings[i].render(this, optionalParams);
        svgCode += "</g>";
      }
    } 
    if (change == "scaling") {
      for (int i = 0; i < drawings.length; i++) {
        svgCode += "<g transform=\"scale(" + (double)changeparams[0] * i + " " 
            + (double)changeparams[1] * i + ")\">";
        svgCode += drawings[i].render(this, optionalParams);
        svgCode += "</g>";
      }
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
  public String visitFill(Path path, ColorManager color,
      Object[] optionalParams) {
    String svgCode = "<path ";
    int[] rgbColor = color.getRgbCode();
    svgCode += path.render(this, optionalParams) + " ";
    svgCode += "fill=\"rgb(" + rgbColor[0] + "," 
      + rgbColor[1] + "," + rgbColor[2] + ")\" ";
    svgCode += "/>\n";
    return svgCode;
  }

  @Override
  public String visitInsert(Drawing drawing, Path[] paths, Object[] optionalParams) {
    String svgCode = "<defs>\n";
    svgCode += "<clipPath id=\"path" + numberOfPathsDef + "\">\n";
    for (int i = 0; i < paths.length; i++) {
      svgCode += "<path " + paths[i].render(this, optionalParams) + "/>\n";
      svgCode += "</clipPath>\n";
    }
    svgCode += "</defs>\n";
    
    String drawSvgCode = (String)drawing.render(this, optionalParams);
    String modifiedDrawSvgCode = drawSvgCode.substring(0, drawSvgCode.length() - 4);
    modifiedDrawSvgCode += " clip-path=\"url(#path" + numberOfPathsDef + ")\" />\n";
    svgCode += modifiedDrawSvgCode;
    numberOfPathsDef++;
    return svgCode;
  }

  @Override
  public String visitLabel(String text, Point2D position, TextTool textTool,
      Object[] optionalParams) {
    String svgCode = "<text x=\"" + position.getX() + "\" y=\"" + position.getY() + "\" ";
    svgCode += textTool.render(this, optionalParams);
    svgCode += ">" + text + "</text>";
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
