package de.openhpi.capstone1.game.builder;

import java.util.concurrent.ThreadLocalRandom;

import de.openhpi.capstone1.game.controller.BallController;
import de.openhpi.capstone1.game.controller.PaddleControllerStrategyLeft;
import de.openhpi.capstone1.game.controller.PaddleControllerStrategyRight;
import de.openhpi.capstone1.game.controller.TimerController;
import de.openhpi.capstone1.game.model.Ball;
import de.openhpi.capstone1.game.model.BallDepot;
import de.openhpi.capstone1.game.model.GameField;
import de.openhpi.capstone1.game.model.Paddle;
import de.openhpi.capstone1.game.model.Timer;
import de.openhpi.capstone1.game.view.AbstractView;
import de.openhpi.capstone1.game.view.BallDepotView;
import de.openhpi.capstone1.game.view.BallView;
import de.openhpi.capstone1.game.view.GameFieldView;
import de.openhpi.capstone1.game.view.PaddleView;
import de.openhpi.capstone1.game.view.TimerView;
import processing.core.PApplet;
import processing.core.PConstants;

public class Game extends InteractiveComponent {
	
	private boolean gameActive;
	
	private PApplet display;
	private GameField gameField;
	private Paddle paddle;
	private BallDepot ballDepot;
	private Ball ball;
	private Timer timer;
	
	private PaddleControllerStrategyRight paddleControlStratRight;
	private PaddleControllerStrategyLeft paddleControlStratLeft;
	
	private BallController ballController;
	
	private TimerController timerController;
	
	
	public Game(PApplet display) {
		this.display = display;
		System.out.println(display.frameRate);
	}
	
	@Override
	public void update() {
		if (gameActive) {
			timerController.handleEvent();
			ballController.handleEvent();			
			
//			if (ball.getY() > gameField.getBallDeathLine()) {
//				// TODO  Ball has died. Perform action!
//				ballController = null;
//				ballView = null;
//				ball = null;
//				
//		}
		
		}
		
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
		float GAME_FIELD_X = display.width/2;
		float GAME_FIELD_WIDTH = display.width*8/10;
		float GAME_FIELD_DISTANCE_TOP = display.height*2/10;
		float GAME_FIELD_BALL_DEATH_LINE = display.height + 20; // ball is considered dead once it's 20 pixels below window 
		
		float PADDLE_Y_POS = display.height - 30; // 30 pixels above the bottom of the pit
		float PADDLE_WIDTH = GAME_FIELD_WIDTH/8;
		float PADDLE_HEIGHT = 10;
		float PADDLE_BOUND_LEFT =  GAME_FIELD_X - GAME_FIELD_WIDTH/2 + PADDLE_WIDTH/2; // minimum x value which the paddle may have
		float PADDLE_BOUND_RIGHT = GAME_FIELD_X + GAME_FIELD_WIDTH/2 - PADDLE_WIDTH/2;  // maximum x value which the paddle may have
		
		float BALL_RADIUS = 8;
		float INIT_BALL_VELOCITY_X = ThreadLocalRandom.current().nextInt(1, 3+1); // randomize ball's velocities
		float INIT_BALL_VELOCITY_Y = ThreadLocalRandom.current().nextInt(1, 3+1);
		
		float TIMER_X = 10;
		float TIMER_Y = 35;
		float TIMER_SIZE = 32;
		
		float BALL_DEPOT_X = (GAME_FIELD_X - GAME_FIELD_WIDTH/2)/2;
		float BALL_DEPOT_Y = display.height/2 + display.height*0.15f;
		float BALL_DEPOT_WIDTH = (GAME_FIELD_X - GAME_FIELD_WIDTH/2) * 0.8f;
		float BALL_DEPOT_HEIGHT = (display.height - GAME_FIELD_DISTANCE_TOP) / 2;
		
		this.gameField = new GameField(GAME_FIELD_X, GAME_FIELD_WIDTH, GAME_FIELD_DISTANCE_TOP, GAME_FIELD_BALL_DEATH_LINE);
		this.paddle = new Paddle(display.width/2, PADDLE_Y_POS, PADDLE_WIDTH, PADDLE_HEIGHT, PADDLE_BOUND_LEFT, PADDLE_BOUND_RIGHT);
		this.ball = new Ball(display.width/2, display.height/2, BALL_RADIUS, INIT_BALL_VELOCITY_X, INIT_BALL_VELOCITY_Y);
		this.ballDepot = new BallDepot(BALL_DEPOT_X, BALL_DEPOT_Y, BALL_DEPOT_WIDTH, BALL_DEPOT_HEIGHT, new Ball[] {new Ball(BALL_RADIUS), new Ball(BALL_RADIUS), new Ball(BALL_RADIUS)});
		this.timer = new Timer(TIMER_X, TIMER_Y, TIMER_SIZE);
	}
	
	@Override
	public void buildViews(PApplet display) {
		views = new AbstractView[] {
				new GameFieldView(display, gameField),
				new PaddleView(display, paddle),
				new BallView(display, ball),
				new TimerView(display, timer),
				new BallDepotView(display, ballDepot)
		};
	}
	
	@Override
	public void buildControllers() {
		gameActive = true;
		
		float PADDLE_STEP_WIDTH = paddle.getWidth()/2;
		
		int SECONDS_TILL_BALL_SPEED_UP = 10;
		
		paddleControlStratLeft = new PaddleControllerStrategyLeft(paddle, PADDLE_STEP_WIDTH);
		paddleControlStratRight = new PaddleControllerStrategyRight(paddle, PADDLE_STEP_WIDTH);
		
		ballController = new BallController(ball, paddle, gameField, SECONDS_TILL_BALL_SPEED_UP, display.frameRate);
		
		timerController = new TimerController(timer, display.frameRate);
	}

}
