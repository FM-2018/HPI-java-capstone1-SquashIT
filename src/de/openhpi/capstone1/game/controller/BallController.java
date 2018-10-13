package de.openhpi.capstone1.game.controller;

import de.openhpi.capstone1.game.model.Ball;
import de.openhpi.capstone1.game.model.GameField;
import de.openhpi.capstone1.game.model.Paddle;

public class BallController implements Controller {
	
	private Ball ball;
	private Paddle paddle;
	private GameField gameField;
	private float framesTillSpeedUp;
	
	public BallController(Ball ball, Paddle paddle, GameField gameField, float secondsTillSpeedUp, float frameRate) {
		this.ball = ball;
		this.paddle = paddle;
		this.gameField = gameField;
		framesTillSpeedUp = frameRate * secondsTillSpeedUp;
	}
	
	private boolean paddleCollision(Paddle paddle, float ballX, float ballY, float ballRadius) {
		float paddleTopBound = paddle.getY() - paddle.getHeight()/2;
		float paddleLeftBound = paddle.getX() - paddle.getWidth()/2;
		float paddleBottomBound = paddle.getY() + paddle.getHeight()/2;
		float paddleRightBound = paddle.getX() + paddle.getWidth()/2;
		
		boolean ballOnHorizPaddleLine = (ballY + ballRadius > paddleTopBound) && (ballY - ballRadius < paddleBottomBound);
		boolean ballOnVertPaddleLine = (ballX + ballRadius > paddleLeftBound) && (ballX - ballRadius < paddleRightBound);
				
		return (ballOnHorizPaddleLine && ballOnVertPaddleLine);
	}
	
	@Override
	public void handleEvent() {
		float nextBallX = ball.getX() + ball.velocityX;
		float nextBallY = ball.getY() + ball.velocityY;
		
		float leftXLimit = gameField.getLeftBound() + ball.getRadius();
		float rightXLimit = gameField.getRightBound() - ball.getRadius();
		float topYLimit = gameField.getTopBound() + ball.getRadius();
		
		// TODO: when ball collides with paddle, it'll only change its y velocity, even though it should bounce off to the side 
		
		// CHECK WHETHER BALL WILL COLLIDE WITH ANYTHING AND PERFORM ACTIONS. ELSE JUST MOVE.
		if ( ( nextBallX < leftXLimit || nextBallX > rightXLimit ) && nextBallY < topYLimit) {
			// Ball collides with corner.
			// TODO: this may cause the ball to take a step too far, since both bounce methods also make a movement for the other coordinate respectively
			float distanceTillBounceX = ball.getX() - gameField.getLeftBound() - ball.getRadius();
			float distanceTillBounceY = ball.getY() - gameField.getRightBound() - ball.getRadius();
			ball.bounceX(distanceTillBounceX);
			ball.bounceY(distanceTillBounceY);
		} else if (nextBallX < leftXLimit) {
			float distanceTillBounce = ball.getX() - gameField.getLeftBound() - ball.getRadius();
			ball.bounceX(distanceTillBounce);
		} else if (nextBallX > rightXLimit) {
			float distanceTillBounce = gameField.getRightBound() - ball.getX() - ball.getRadius();
			ball.bounceX(distanceTillBounce);
		} else if (nextBallY < topYLimit) {
			float distanceTillBounce = ball.getY() - gameField.getTopBound() - ball.getRadius();
			ball.bounceY(distanceTillBounce);
		} else if (paddleCollision(paddle, nextBallX, nextBallY, ball.getRadius())) {
			float distanceTillBounce = paddle.getY() - paddle.getHeight()/2 - ball.getY() - ball.getRadius();
			ball.bounceY(distanceTillBounce);
		} else {
			ball.move();
		}
		
		// INCREASE BALL VELOCITY GRADUALLY SO THAT AFTER X FRAMES IT HAS INCREASED BY ONE
		if (ball.velocityX >= 0) {
			ball.velocityX += 1.0f/framesTillSpeedUp;
		} else {
			ball.velocityX -= 1.0f/framesTillSpeedUp;
		}
		
		if (ball.velocityY >= 0) {				
			ball.velocityY += 1.0f/framesTillSpeedUp;
		} else {
			ball.velocityY -= 1.0f/framesTillSpeedUp;
		}

	}

}
