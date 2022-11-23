// Creates a Ball object whose position and velocity can be changed, and can be
// drawn to StdDraw
// To test:
// Compile: javac-introcs Ball.java
// Run: java-introcs Ball

import java.awt.Color;

public class Ball {
    private double ballXCoordinate;
    private double ballYCoordinate;
    private double ballXVelocity;
    private double ballYVelocity;

    // Construct Ball object
    public Ball() {
        ballXCoordinate = 0.0;
        ballYCoordinate = 0.0;
        ballXVelocity = 0.8;
        // Set Y velocity to random number between -0.25 and 0.25
        ballYVelocity = ((Math.random() * 2) - 1) / 4;
    }

    // Return x-coordinate of ball
    public double getBallXCoordinate() {
        return ballXCoordinate;
    }

    // Return y-coordinate of ball
    public double getBallYCoordinate() {
        return ballYCoordinate;
    }

    // Multiply ball x-velocity by -1
    public void reverseBallXVelocity() {
        ballXVelocity *= -1.0;
    }

    // Multiply ball y-velocity by -1
    public void reverseBallYVelocity() {
        ballYVelocity *= -1.0;
    }

    // Replace ball's x-velocity with given new velocity
    public void updateBallXVelocity(double newVelocity) {
        ballXVelocity = newVelocity;
    }

    // Replace ball's y-velocity with given new velocity
    public void updateBallYVelocity(double newVelocity) {
        ballYVelocity = newVelocity;
    }

    // Update the ball's position based on its velocity
    public void updateBallPosition() {
        ballXCoordinate += ballXVelocity;
        ballYCoordinate += ballYVelocity;
    }

    // Return ball's x velocity
    public double getBallXVelocity() {
        return ballXVelocity;
    }

    // Return ball's y velocity
    public double getBallYVelocity() {
        return ballYVelocity;
    }

    // Draw the ball of radius 0.5 in orange at the given coordinate
    public void draw() {
        StdDraw.setPenColor(Color.ORANGE);
        StdDraw.filledCircle(ballXCoordinate, ballYCoordinate, 0.5);
    }

    // Test methods
    public static void main(String[] args) {
        Ball ball = new Ball();
        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);
        ball.draw(); // test drawing (ball of radius 1 should be at (0,0))
        // Test getBallXCoordinate and getBallYCoordinate and updateBallPosition
        StdOut.println(ball.getBallXCoordinate()); // should print 0.0
        StdOut.println(ball.getBallYCoordinate()); // should print 0.0
        ball.updateBallPosition();
        ball.draw(); // test drawing (ball should be at (0.8, (random # between -0.25
        //                                                    and 0.25))
        StdOut.println(ball.getBallXCoordinate()); // should print 0.8
        StdOut.println(ball.getBallYCoordinate()); // should print random double
        //                                          between -0.25 and 0.25
        // Test reverseBallVelocity by calling it, updating the ball's x and y
        // coordinates, and printing the new coordinates
        ball.reverseBallXVelocity();
        ball.reverseBallYVelocity();
        ball.updateBallPosition();
        ball.updateBallPosition();
        StdOut.println(ball.getBallXCoordinate()); // should be -0.8
        StdOut.println(ball.getBallYCoordinate()); // should be the negative of
        //                                              previous random double
        ball.draw(); // test drawing (ball should be at (-0.8, the negative of
        //                                      of the random double from before)

    }
}
