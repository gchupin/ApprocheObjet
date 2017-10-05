package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class Animation implements ActionListener {

	// Quelques constantes
	public static double GRAVITATION = 9.80665; // acceleration de la gravitation

	private ViewFrame viewFrame;
	private ViewBall viewBall;
	private Panel panel;
	private Ball ball;
	// Objet permettant de provoquer une animation à temps réguliers
	private AnimationTimer timer;


	public Animation(String title, Ball modelBall) {
		this.ball = modelBall;
		panel = new Panel();
		viewBall = new ViewBall();
		viewFrame = new ViewFrame(title, Panel.WIDTH, Panel.HEIGHT,
				Panel.XMIN, Panel.YMIN, Panel.XMAX, Panel.YMAX,
				Panel.SCALE, Panel.MARGIN, viewBall);
		timer = new AnimationTimer(this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.step();
		viewBall.setXY(ball.x, ball.y, 
				Ball.WIDTH, Ball.HEIGHT, 
				Panel.SCALE, Panel.MARGIN);
		viewFrame.panel.repaint();
	}

	public void step() {
		ball.vx = ball.vx0 + ball.ax * ball.t;
		ball.vy = ball.vy0 + ball.ay * ball.t;
		double t2 = ball.t*ball.t;
		ball.x = ball.x0 + ball.vx0 * ball.t + (ball.ax * t2) / 2;
		ball.y = ball.y0 + ball.vy0 * ball.t + (ball.ay * t2) / 2;
		if(ball.x >= Panel.XMAX - Ball.WIDTH || ball.x <= Panel.XMIN){
			ball.vx0 = -ball.vx;
			ball.vy0 = ball.vy ;
			ball.x0 = ball.x;
			ball.y0 = ball.y;
			ball.t = 0;
		}
		if(ball.y >= Panel.YMAX - Ball.HEIGHT || ball.y <= Panel.YMIN){
			ball.vx0 = ball.vx;
			ball.vy0 = -ball.vy;
			ball.x0 = ball.x;
			ball.y0 = ball.y;
			ball.t = 0;
		}
		ball.t += AnimationTimer.MSSTEP;
	}


}
