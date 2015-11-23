package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.tools.TextTool;
import exports.ExportSvg;
import managers.ColorManager;
import utils.Point2D;
import java.util.HashMap;

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
    
    svgCode += "\" fill=\"none\"";

    return svgCode;
  }

  @Override
  public String visitBezierPath(Point2D[] points, boolean closed,
      Object[] optionalParams) {
    String svgCode = "d=\"";
    
    svgCode += "M" + points[0].getX() + " " + points[0].getY() + " "
        + "C" + points[1].getX() + " " + points[1].getY() + ", "
        + points[2].getX() + " " + points[2].getY() + ", "
        + points[3].getX() + " " + points[3].getY();
    
    if (closed) {
      svgCode += " Z";
    }
    
    svgCode += "\" fill=\"none\"";
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
    String pathCode = (String)path.render(this, optionalParams);
    String pathCodeChanged = pathCode.substring(0, pathCode.length() - 12);
    svgCode += pathCodeChanged + " fill=\"rgb(" + rgbColor[0] + "," 
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
    ExportSvg.export(svgCode);
  }
  
  @Override
  public String visitSequence(Drawing[] drawings, Object[] optionalParams) {
    String svgCode = "";
    for (int i = 0; i < drawings.length; i++) {
      svgCode += drawings[i].render(this, optionalParams);
    }
    return svgCode;
  }

  public String visitAlternative(Drawing[] drawings, boolean firstWanted,
      Object[] optionalParams) {
    String svgCode = "";

    if (firstWanted) {
      svgCode += drawings[0].render(this, optionalParams);
    } else {
      svgCode += drawings[1].render(this, optionalParams);
    }
    return svgCode;
  }

  @Override
  public String visitLoop(Drawing drawing, int numIterations,
      HashMap<String, Double[]> changeParams, Object[] optionalParams) {
    String svgCode = "";
    
    for (int i = 0 ; i < numIterations ; i++) {
      if (changeParams.containsKey("rotation")) {
        Double[] value = changeParams.get("rotation");
        svgCode += "<g transform=\"rotate(" + value[0] * i 
            + " 0 0)\">";
        svgCode += drawing.render(this, optionalParams) + "</g>";
      }
      if (changeParams.containsKey("translation")) {
        Double[] value = changeParams.get("translation");
        svgCode += "<g transform=\"translate(" + value[0] * i + " " 
            + value[1] * i + ")\">";
        svgCode += drawing.render(this, optionalParams) + "</g>";
      }
      if (changeParams.containsKey("scale")) {
        Double[] value = changeParams.get("scale");
        svgCode += "<g transform=\"scale(" + value[0] * i + " " 
            + value[1] * i + ")\">";
        svgCode += drawing.render(this, optionalParams) + "</g>";
      }
    }
    return svgCode;
  }

}
