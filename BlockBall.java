// Implements game BlockBall where two users can move paddle objects, and ball
// bounces off paddles and horizontal walls until it passes one of the paddles
// Compile: javac-introcs BlockBall.java
// Run: java-introcs BlockBall
public class BlockBall {

    public static void main(String[] args) {
        double ballRadius = 0.5;
        double paddleHalfWidth = 0.5;
        double paddleHalfHeight = 3.5;
        // Enable Double Buffering
        StdDraw.enableDoubleBuffering();
        // Set scale so that the picture is 1024x512, with x-scale going from -20
        // to 20 and y scale going from -10 to 10
        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setXscale(-20, 20);
        StdDraw.setYscale(-10, 10);
        // Restart loop when point is won
        while (true) {
            // Create ball object
            Ball ball = new Ball();
            // Create paddle objects
            Paddle paddle1 = new Paddle(18.0, 0.0); // starting position at (18,0)
            Paddle paddle2 = new Paddle(-18.0, 0.0); // starting position at (-18,0)
            // Create main animation loop
            // Stop animation if ball gets past either paddle
            while (ball.getBallXCoordinate() < paddle1.getPaddleXCoordinate() &&
                    ball.getBallXCoordinate() > paddle2.getPaddleXCoordinate()) {
                // Continually update the paddles' positions based on the users' inputs
                // If w is pressed, move paddle 2 up
                if (StdDraw.isKeyPressed(87))
                    paddle2.movePaddleUp();
                // If s is pressed, move paddle 2 down
                if (StdDraw.isKeyPressed(83))
                    paddle2.movePaddleDown();
                // If ":" is pressed, move paddle 1 up
                if (StdDraw.isKeyPressed(59))
                    paddle1.movePaddleUp();
                // If "." is pressed, move paddle 1 down
                if (StdDraw.isKeyPressed(46))
                    paddle1.movePaddleDown();
                // Move ball one step
                ball.updateBallPosition();
                // If ball's x and y positions equals paddle 1's positions,
                // then reverse the x-velocity of the ball
                if ((ball.getBallXVelocity() > 0) && (
                        ball.getBallXCoordinate() + ballRadius > paddle1.getPaddleXCoordinate() -
                                paddleHalfWidth)
                        && (ball.getBallYCoordinate() - ballRadius < (paddle1.getPaddleYCoordinate()
                        +
                        paddleHalfHeight))
                        && (ball.getBallYCoordinate() + ballRadius > (paddle1.getPaddleYCoordinate()
                        - paddleHalfHeight))) {
                    // Reverse direction of ball
                    ball.reverseBallXVelocity();
                    // Change angle of ball's ricochet based on where on the paddle it hits
                    ball.updateBallYVelocity(
                            (ball.getBallYCoordinate() - paddle1.getPaddleYCoordinate()) / 5);
                    // Make sure that the speed is same by normalizing vector
                    double xVelocity = ball.getBallXVelocity();
                    double yVelocity = ball.getBallYVelocity();
                    double updatedXVelocity = xVelocity / Math.sqrt(xVelocity * xVelocity +
                                                                            yVelocity * yVelocity);
                    double updatedYVelocity = yVelocity / Math.sqrt(xVelocity * xVelocity
                                                                            + yVelocity
                            * yVelocity);
                    ball.updateBallXVelocity(updatedXVelocity);
                    ball.updateBallYVelocity(updatedYVelocity);
                }
                // If ball's x and y positions equals paddle 2's positions,
                // then reverse the x-velocity of the ball
                if ((ball.getBallXVelocity() < 0) && (
                        ball.getBallXCoordinate() - ballRadius < paddle2.getPaddleXCoordinate() +
                                paddleHalfWidth)
                        && (ball.getBallYCoordinate() - ballRadius < (paddle2.getPaddleYCoordinate()
                        +
                        paddleHalfHeight))
                        && (ball.getBallYCoordinate() + ballRadius > (paddle2.getPaddleYCoordinate()
                        - paddleHalfHeight))) {
                    // Reverse direction of ball
                    ball.reverseBallXVelocity();
                    // Change angle of ball's ricochet based on where on the paddle it hits
                    ball.updateBallYVelocity(
                            ((ball.getBallYCoordinate() - paddle2.getPaddleYCoordinate()) / 5));
                    // Make sure that the speed is same by normalizing vector
                    double xVelocity = ball.getBallXVelocity();
                    double yVelocity = ball.getBallYVelocity();
                    double updatedXVelocity = xVelocity / Math.sqrt(xVelocity * xVelocity +
                                                                            yVelocity * yVelocity);
                    double updatedYVelocity = yVelocity / Math.sqrt(xVelocity * xVelocity
                                                                            + yVelocity
                            * yVelocity);
                    ball.updateBallXVelocity(updatedXVelocity);
                    ball.updateBallYVelocity(updatedYVelocity);

                }
                // Update velocity of ball
                // If the ball's y position equals the bottom or top of the screen, reverse
                // the x-velocity and y-velocity of the ball
                if ((ball.getBallYVelocity() > 0 && (ball.getBallYCoordinate() > 10 - ballRadius))
                        || ((ball.getBallYVelocity() < 0) && ball.getBallYCoordinate()
                        < -10 + ballRadius)) {
                    ball.reverseBallYVelocity();
                }
                // Clear image
                StdDraw.clear();
                // Draw background
                StdDraw.picture(0.0, 0.0, "PingPongTable.png"); // show background
                // Show paddle 1
                paddle1.draw();
                // Show paddle 2
                paddle2.draw();
                // Draw ball
                ball.draw();
                // Show the image
                StdDraw.show();
                // Pause for 20ms
                StdDraw.pause(20);
            }
        }
    }
}
