package model;

import controler.Animation;

public class Ball {

	// Taille de la balle
	public static double WIDTH = 0.35; // 35 cm
	public static double HEIGHT = WIDTH;
	public static double RADIUS = WIDTH/2;
	
	// Masse de la balle
	public static double MASS = 1.0;
	
	// données physiques
	public double x; // position
	public double y;
	public double vx; // vitesse
	public double vy;
	public double ax, ay; // acceleration
	public double x0, y0; // position initiale
	public double vx0; // vitesse initiale
	public double vy0;
	public double fx, fy; // force
	public double t; // temps relatif

	public Ball() {
		fx = 0; // force
		fy = MASS * Animation.GRAVITATION;
		ax = fx / MASS; // acceleration initiale
		ay = fy / MASS; 
		vx0 = vx = 1; // vitesse initiale 1 m/s
		vy0 = vy = 0;
		x0 = x = (Panel.XMIN + Panel.XMAX)/2; // position initiale
		y0 = x = (Panel.YMIN + Panel.YMAX)/2;
		t = 0;
	}
	
	public void step(){
		// TO DO
	}

	
}
