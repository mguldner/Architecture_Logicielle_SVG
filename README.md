# Architecture_Logicielle_SVG
This project aims to create a drawing library in Java.  
It is a school project of the Ecole des Mines de Nantes.  
[Mozilla's SVG documentation](https://developer.mozilla.org/en-US/docs/Web/SVG) was chosen as a base for the implementation of the SVG export mode.

## Prerequisites
- This project is developed with [Java 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html), so you need to have it installed on your computer.
- This project's code is checked with [Checkstyle](https://github.com/checkstyle/checkstyle) and its [Eclipse plug-in](https://github.com/checkstyle/checkstyle).  
We chose to follow the [Google Standards](https://google-styleguide.googlecode.com/svn-history/r130/trunk/javaguide.html).  
Please check your code with it before each pull request.
- In order to help your understanding of the project's structure, we created several class diagrams with [ObjectAid](http://www.objectaid.com/). It is obviously not mandatory to have the project working, but highly recommended.

## Installation

### How to fast install with Eclipse
1. Open Eclipse and import the project going  
`File > Import > Git > Project from Git > Clone URI`
2. In the `URI` field, paste `https://github.com/mguldner/Architecture_Logicielle_SVG.git`
3. Click `Next` and configure the project as you prefer
4. Select the `Import existing Eclipse projects` as wizard
5. Click `Finish`

### How to install within a custom folder with Git + Eclipse
1. Go into the folder you want to create your project
2. Git clone the repository:
  * With SSH: `git clone git@github.com:mguldner/Architecture_Logicielle_SVG.git`
  * By HTTPS: `git clone https://github.com/mguldner/Architecture_Logicielle_SVG.git`
3. Open Eclipse and import the project going  
`File > Import > Git > Projects from Git > Existing local repository > Add > Browse`
4. Select your project in the result field and click Finish

## Improve your library

### How to add an action
To create a new action, you only have to follow these two steps:  
1. Create a class in `datastructure.actions` that extends `Action`.
2. Write the corresponding code for each export mode, following the example of the `Draw` class.

### How to add a new operator
To create a new operator, please follow these easy steps:  
1. Create a class in `datastructure.operators` that extends `Operator`.
2. Write the code of the `applyFunction` method.
3. Write the corresponding code for each export mode, following the example of the `Sequence` class.

### How to add a new path
To create a new path:
1. Create a class in `datastructure.paths` that extends `Path`.
2. Write the corresponding code for each export mode, following the example of the `PolygonalPath` class.

### Tools
Every tool has in common to have a color, represented by a RGB code (stored in an array).  
Depending your habits, it could be interesting to define your tools with another type of color code (hexadecimal...).
In this case, you will need to create a new class for each representation you need.

#### Add a new representation to an existing tool
1. If the chosen tool already has a sub-package, go to step 2.  
Else, create a new package `datastructure.tools.YOUR_TOOL_NAMEs`.
2. Create a class in `datastructure.tools.YOUR_TOOL_NAMEs` that extends `YOUR_TOOL_NAME`.
3. Write the constructors you need, following the example of `Pen` and `HexaPen`.

#### Add a new tool
To create a new tool:
1. Create a class in `datastructure.tools` that extends `Tool` with its own variables and constructors.
2. Write the corresponding code for each export mode, following the example of the `Pen` class.

### Export modes
Depending on the type of export you want, the method will be different.

#### Export with non-Java render engine
The principle here is to generate a string that will contain the whole encoded drawing. This string will be exported to a file.
1. In the `Drawing` class, add a `public void generateExportModeDrawing` method that will get the string and will export it.
2. Still in `Drawing`, add a `public abstract String generateExportModeCode()` method that will generate the string.
3. Implement all the needed methods following the example of the `SVG` export.

#### Export with Java rendering
The principle here is to apply Java functions.
1. In the `Drawing` class, add a `public void generateExportModeDrawing` method that will create the window and display the drawing.
2. Still in `Drawing`, add a `public abstract void generateExportModeCode()` method that will be called by the above function and will trigger every drawing-dedicated methods.
3. Implement all the needed methods following the example of the `Java` export.