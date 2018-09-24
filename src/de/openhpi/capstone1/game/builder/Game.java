package de.openhpi.capstone1.game.builder;

import java.util.concurrent.ThreadLocalRandom;

import de.openhpi.capstone1.game.controller.BallController;
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
	
	private BallController ballController;
	
	
	public Game(PApplet display) {
		this.display = display;
		System.out.println(display.frameRate);
	}
	
	@Override
	public void update() {
		ballController.handleEvent();
		updateViews();
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
		int GAME_FIELD_X = display.width/2;
		int GAME_FIELD_WIDTH = display.width*8/10;
		int GAME_FIELD_DISTANCE_TOP = display.height*2/10;
		int GAME_FIELD_BALL_DEATH_LINE = display.height + 20; // ball is considered dead once it's 20 pixels below window 
		
		int PADDLE_Y_POS = display.height - 30; // 30 pixels above the bottom of the pit
		int PADDLE_WIDTH = GAME_FIELD_WIDTH/8;
		int PADDLE_HEIGHT = 10;
		int PADDLE_BOUND_LEFT =  GAME_FIELD_X - GAME_FIELD_WIDTH/2 + PADDLE_WIDTH/2; // minimum x value which the paddle may have
		int PADDLE_BOUND_RIGHT = GAME_FIELD_X + GAME_FIELD_WIDTH/2 - PADDLE_WIDTH/2;  // maximum x value which the paddle may have
		
		int BALL_RADIUS = 8;
		int INIT_BALL_VELOCITY_X = ThreadLocalRandom.current().nextInt(1, 3+1); // randomize ball's velocities
		int INIT_BALL_VELOCITY_Y = ThreadLocalRandom.current().nextInt(1, 3+1);
		
		this.gameField = new GameField(GAME_FIELD_X, GAME_FIELD_WIDTH, GAME_FIELD_DISTANCE_TOP, GAME_FIELD_BALL_DEATH_LINE);
		this.paddle = new Paddle(display.width/2, PADDLE_Y_POS, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_BOUND_LEFT, PADDLE_BOUND_RIGHT);
		this.ball = new Ball(display.width/2, display.height/2, BALL_RADIUS, INIT_BALL_VELOCITY_X, INIT_BALL_VELOCITY_Y);
	}
	
	@Override
	public void buildViews(PApplet display) {
		views = new AbstractView[] {
				new GameFieldView(display, gameField),
				new PaddleView(display, paddle),
				new BallView(display, ball)
		};
	}
	
	@Override
	public void buildControllers() {
		float PADDLE_STEP_WIDTH = paddle.getWidth()/2;
		
		int SECONDS_TILL_BALL_SPEED_UP = 10;
		
		paddleControlStratLeft = new PaddleControllerStrategyLeft(paddle, PADDLE_STEP_WIDTH);
		paddleControlStratRight = new PaddleControllerStrategyRight(paddle, PADDLE_STEP_WIDTH);
		
		ballController = new BallController(ball, paddle, gameField, SECONDS_TILL_BALL_SPEED_UP, (int) display.frameRate);
	}

}
