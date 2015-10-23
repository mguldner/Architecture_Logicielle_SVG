package dataStructure.paths;

import dataStructure.Path;
import utils.Point2D;

public class PolygonalPath extends Path {

	@Override
	public Point2D[] generatePath() {
		return this.getPoints();
	}

}
