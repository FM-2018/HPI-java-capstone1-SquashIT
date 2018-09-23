package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Ball;
import de.openhpi.capstone1.game.model.GameField;
import de.openhpi.capstone1.game.model.Paddle;

public class BallController implements Controller {
	
	Ball ball;
	Paddle paddle;
	GameField gameField;
	
	public BallController(Ball ball, Paddle paddle, GameField gameField) {
		this.ball = ball;
		this.paddle = paddle;
		this.gameField = gameField;
	}
	
	private boolean paddleCollision(Paddle paddle, int ballX, int ballY) {
		int paddleTopBound = paddle.getY() - paddle.getHeight()/2;
		int paddleLeftBound = paddle.getX() - paddle.getWidth()/2;
		int paddleBottomBound = paddle.getY() + paddle.getHeight()/2;
		int paddleRightBound = paddle.getX() + paddle.getWidth()/2;
		
		boolean ballOnHorizPaddleLine = (ballY > paddleTopBound) && (ballY < paddleBottomBound);
		boolean ballOnVertPaddleLine = (ballX > paddleLeftBound) && (ballX < paddleRightBound);
				
		return (ballOnHorizPaddleLine && ballOnVertPaddleLine);
	}
	
	@Override
	public void handleEvent() {
		int nextBallX = ball.getX() + ball.velocityX;
		int nextBallY = ball.getY() + ball.velocityY;
		
		// CHECK WHETHER BALL WILL COLLIDE WITH ANYTHING
		
		// TODO: what if ball collides with corner?
		// TODO: when ball collides with paddle, it'll only change its y velocity, even though it should bounce off to the side 
		
		if (nextBallX < gameField.getLeftBound()) {
			int distanceTillBounce = ball.getX() - gameField.getLeftBound();
			ball.bounceX(distanceTillBounce);
		} else if (nextBallX > gameField.getRightBound()) {
			int distanceTillBounce = gameField.getRightBound() - ball.getX();
			ball.bounceX(distanceTillBounce);
		} else if (nextBallY < gameField.getTopBound()) {
			int distanceTillBounce = ball.getY() - gameField.getTopBound();
			ball.bounceY(distanceTillBounce);
		} else if (paddleCollision(paddle, nextBallX, nextBallY)) {
			int distanceTillBounce = paddle.getY() -paddle.getHeight()/2 - ball.getY();
			ball.bounceY(distanceTillBounce);
		} else {
			ball.move();
		}

	}

}
