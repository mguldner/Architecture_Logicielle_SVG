package visitors;

import datastructure.Drawing;
import datastructure.Path;
import datastructure.Tool;
import datastructure.tools.TextTool;
import exports.ExportSvg;
import managers.ColorManager;
import utils.Point2D;
import java.util.HashMap;

public class VisitorSvg extends Visitor<String> {
  
  public static int numberOfPathsDef = 0;

  @Override
  public Visitor<String> visitPen(int thickness, int[] rgbColorCode, Object[] optionnalParams) {
    this.setResult("stroke-width=\"" + thickness + "\" " 
        + "stroke=\"rgb(" + rgbColorCode[0] + ","
        + rgbColorCode[1] + ","
        + rgbColorCode[2]
            + ")\"");
    return this;
  }

  @Override
  public Visitor<String> visitTextTool(String fontName, int fontSize, int fontStyle,
      int[] rgbColorCode, Object[] optionalParams) {
    this.setResult("font-family=\"" + fontName + "\" "
        + "font-size=\"" + fontSize + "\" "
        + "style=\"stroke:rgb(" + rgbColorCode[0] + ","
        + rgbColorCode[1] + ","
        + rgbColorCode[2]
        + ")\""); 
    return this;
  }

  @Override
  public Visitor<String> visitPolygonalPath(Point2D[] points, boolean closed,
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
    this.setResult(svgCode);
    return this;
  }

  @Override
  public Visitor<String> visitBezierPath(Point2D[] points, boolean closed,
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
    this.setResult(svgCode);
    return this;
  }
  
  @Override
  public Visitor<String> visitDraw(Path<String> path, Tool<String> tool, Object[] optionalParams) {
    this.setResult("<path " + path.render(this, optionalParams).getResult() + " " 
                   + tool.render(this, optionalParams).getResult() + "/>\n");
    return this;
  }

  @Override
  public Visitor<String> visitFill(Path<String> path, ColorManager color,
      Object[] optionalParams) {
    String svgCode = "<path ";
    int[] rgbColor = color.getRgbCode();
    String pathCode = path.render(this, optionalParams).getResult();
    String pathCodeChanged = pathCode.substring(0, pathCode.length() - 12);
    svgCode += pathCodeChanged + " fill=\"rgb(" + rgbColor[0] + "," 
      + rgbColor[1] + "," + rgbColor[2] + ")\" ";
    svgCode += "/>\n";
    this.setResult(svgCode);
    return this;
  }


  @Override
  public Visitor<String> visitInsert(Drawing<String> drawing, Path<String>[] paths,
                                     Object[] optionalParams) {
    String svgCode = "<defs>\n";
    svgCode += "<clipPath id=\"path" + numberOfPathsDef + "\">\n";
    for (int i = 0; i < paths.length; i++) {
      svgCode += "<path " + paths[i].render(this, optionalParams).getResult() + "/>\n";
      svgCode += "</clipPath>\n";
    }
    svgCode += "</defs>\n";
    
    String drawSvgCode = drawing.render(this, optionalParams).getResult();
    String modifiedDrawSvgCode = drawSvgCode.substring(0, drawSvgCode.length() - 4);
    modifiedDrawSvgCode += " clip-path=\"url(#path" + numberOfPathsDef + ")\" />\n";
    svgCode += modifiedDrawSvgCode;
    numberOfPathsDef++;
    this.setResult(svgCode);
    return this;
  }


  @Override
  public Visitor<String> visitLabel(String text, Point2D position, TextTool<String> textTool,
      Object[] optionalParams) {
    String svgCode = "<text x=\"" + position.getX() + "\" y=\"" + position.getY() + "\" ";
    svgCode += textTool.render(this, optionalParams).getResult();
    svgCode += ">" + text + "</text>";
    this.setResult(svgCode);
    return this;
  }

  @Override
  public void visitExport(Drawing<String> drawing, int height, int width) {
    String svgCode = "<svg height=\"" + height 
        + "\" width=\"" + width 
        + "\" xmlns=\"http://www.w3.org/2000/svg\">\n";
    svgCode += drawing.render(new VisitorSvg(), null).getResult();
    svgCode += "</svg>";
    ExportSvg.export(svgCode);
  }
  
  @Override
  public Visitor<String> visitSequence(Drawing[] drawings, Object[] optionalParams) {
    String svgCode = "";
    for (int i = 0; i < drawings.length; i++) {
      svgCode += drawings[i].render(this, optionalParams).getResult();
    }
    this.setResult(svgCode);
    return this;
  }

  public Visitor<String> visitAlternative(Drawing[] drawings, boolean firstWanted,
      Object[] optionalParams) {
    String svgCode = "";

    if (firstWanted) {
      svgCode += drawings[0].render(this, optionalParams).getResult();
    } else {
      svgCode += drawings[1].render(this, optionalParams).getResult();
    }
    this.setResult(svgCode);
    return this;
  }

  @Override
  public Visitor<String> visitLoop(Drawing<String> drawing, int numIterations,
      HashMap<String, Double[]> changeParams, Object[] optionalParams) {
    String svgCode = "";
    
    for (int i = 0 ; i < numIterations ; i++) {
      if (changeParams.containsKey("rotation")) {
        Double[] value = changeParams.get("rotation");
        svgCode += "<g transform=\"rotate(" + value[0] * i 
            + " 0 0)\">";
        svgCode += drawing.render(this, optionalParams).getResult() + "</g>";
      }
      if (changeParams.containsKey("translation")) {
        Double[] value = changeParams.get("translation");
        svgCode += "<g transform=\"translate(" + value[0] * i + " " 
            + value[1] * i + ")\">";
        svgCode += drawing.render(this, optionalParams).getResult() + "</g>";
      }
      if (changeParams.containsKey("scale") && i != 0) {
        Double[] value = changeParams.get("scale");
        svgCode += "<g transform=\"scale(" + value[0] * i + " " 
            + value[1] * i + ")\">";
        svgCode += drawing.render(this, optionalParams).getResult() + "</g>";
      }
    }
    this.setResult(svgCode);
    return this;
  }

}
