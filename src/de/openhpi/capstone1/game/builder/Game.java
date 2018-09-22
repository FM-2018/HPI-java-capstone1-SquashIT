package de.openhpi.capstone1.game.builder;

import de.openhpi.capstone1.game.controller.PaddleControllerStrategyLeft;
import de.openhpi.capstone1.game.controller.PaddleControllerStrategyRight;
import de.openhpi.capstone1.game.model.Ball;
import de.openhpi.capstone1.game.model.GameField;
import de.openhpi.capstone1.game.model.Paddle;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.BallView;
import de.openhpi.capstone1.game.view.GameFieldView;
import de.openhpi.capstone1.game.view.PaddleView;
import processing.core.PApplet;
import processing.core.PConstants;

public class Game extends InteractiveComponent {
	/*
	 * NOTE: Whenever I use fractions to calculate an integer, this 
	 * may cause a slight imprecision, since decimal points end up being ignored.
	 * TODO: replace integers with floats again
	 */
	
	private PApplet display;
	private GameField gameField;
	private Paddle paddle;
	private Ball ball;
	
	private PaddleControllerStrategyRight paddleControlStratRight;
	private PaddleControllerStrategyLeft paddleControlStratLeft;
	
	public Game(PApplet display) {
		this.display = display;
	}
	
	@Override
	public void handleEvent() {
		switch (display.key) {
			case ' ':
				// TODO: handle ball reset or balldepot logic if ever implemented
				break;
			case PConstants.CODED: // key is coded a special way; need to check keyCode instead
				switch (display.keyCode) {
					case PConstants.LEFT:
						paddleControlStratLeft.handleEvent();
						break;
					case PConstants.RIGHT:
						paddleControlStratRight.handleEvent();
						break;
				}
		}
	}
	
	@Override
	public void buildModels() {
		int GAME_WINDOW_X = display.width/2;
		int GAME_WINDOW_WIDTH = display.width*8/10;
		int GAME_WINDOW_DISTANCE_TOP = display.height*2/10;
		
		int PADDLE_Y_POS = display.height - 30; // 30 pixels above the bottom of the pit
		int PADDLE_WIDTH = GAME_WINDOW_WIDTH/8;
		int PADDLE_HEIGHT = 10;
		int PADDLE_BOUND_LEFT =  GAME_WINDOW_X - GAME_WINDOW_WIDTH + PADDLE_WIDTH/2; // minimum x value which the paddle may have
		int PADDLE_BOUND_RIGHT = GAME_WINDOW_X + GAME_WINDOW_WIDTH - PADDLE_WIDTH/2;  // maximum x value which the paddle may have
		
		int BALL_RADIUS = 5;
		int INIT_BALL_VELOCITY_X = 3; // TODO: randomize ball velocity? or rather randomize ball position?
		int INIT_BALL_VELOCITY_Y = 3;
		
		this.gameField = new GameField(GAME_WINDOW_X, GAME_WINDOW_WIDTH, GAME_WINDOW_DISTANCE_TOP);
		this.paddle = new Paddle(display.width/2, PADDLE_Y_POS, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_BOUND_LEFT, PADDLE_BOUND_RIGHT);
		this.ball = new Ball(display.width/2, display.height/2, BALL_RADIUS, INIT_BALL_VELOCITY_X, INIT_BALL_VELOCITY_Y);
	}
	
	@Override
	public void buildViews(PApplet display) {
		// TODO: add try/catch block in case buildViews is called before buildModels
		views = new AbstractView[] {
				new GameFieldView(display, gameField),
				new PaddleView(display, paddle),
				new BallView(display, ball)
		};
	}
	
	@Override
	public void buildControllers() {
		// TODO: add try/catch block in case builControllers is called before buildModels
		int PADDLE_STEP_WIDTH = paddle.getWidth()/2;
		
		paddleControlStratLeft = new PaddleControllerStrategyLeft(paddle, PADDLE_STEP_WIDTH);
		paddleControlStratRight = new PaddleControllerStrategyRight(paddle, PADDLE_STEP_WIDTH);
	}

}
