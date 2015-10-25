package utils;

public class Point2D {
	/*==============================*/
	/*========== Variables =========*/
	/*==============================*/
	private int x;
	private int y;

	
	/*=================================*/
	/*========== Constructors =========*/
	/*=================================*/
	public Point2D() {
		this.x = 0;
		this.y = 0;
	}
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	/*============================*/
	/*========== Getters =========*/
	/*============================*/
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	
	/*============================*/
	/*========== Setters =========*/
	/*============================*/
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
}
