# Architecture_Logicielle_SVG
This project aims to create a drawing library in Java.  
It is a school project of the Ecole des Mines de Nantes.  
[Mozilla's SVG documentation](https://developer.mozilla.org/en-US/docs/Web/SVG) was chosen as a base for the implementation of the SVG export mode.

## Prerequisites
- This project is developed with [Java 8](https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html), so you need to have it installed on your computer.
- This project's code is checked with [Checkstyle](https://github.com/checkstyle/checkstyle) and its [Eclipse plug-in](http://eclipse-cs.sourceforge.net).  
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

## Use the library
In order to use this library, just edit the `Main.main`'s `main` function.
