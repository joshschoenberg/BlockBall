// Creates Paddle object whose position can be updated and can be drawn to StdDraw
// To test:
// Compile: javac-introcs Paddle.java
// Run: java-introcs Paddle

import java.awt.Color;

// Creates paddle object whose position can be manipulated
public class Paddle {
    private double paddleXCoordinate; // paddle's x coordinate
    private double paddleYCoordinate; // paddle's y coordinate
    // private final String paddleFilename = "paddle.png"; // paddle image filename

    // construct paddle
    public Paddle(double initialX, double initialY) {
        paddleXCoordinate = initialX;
        paddleYCoordinate = initialY;
    }


    // Update paddle's X coordinate
    public double getPaddleXCoordinate() {
        return paddleXCoordinate;
    }

    // return y coordinate of paddle
    public double getPaddleYCoordinate() {
        return paddleYCoordinate;
    }

    // Move paddle up
    public void movePaddleUp() {
        paddleYCoordinate += 0.3;
    }

    // Move paddle down
    public void movePaddleDown() {
        paddleYCoordinate -= 0.3;
    }

    // Move paddle right
    public void movePaddleRight() {
        paddleXCoordinate += 2;
    }

    // draw the paddle in black with half-width 0.5 and half-height 3.5
    public void draw() {
        StdDraw.setPenColor(Color.BLACK);
        // Paddle is drawn as filled black 1x7 rectangle
        StdDraw.filledRectangle(paddleXCoordinate, paddleYCoordinate, 0.5, 3.5);
    }

    // Test methods
    public static void main(String[] args) {
        Paddle paddle = new Paddle(0, 0);
        StdDraw.setXscale(-5, 5);
        StdDraw.setYscale(-5, 5);
        paddle.draw(); // test drawing (paddle should be at (0,0)
        // Test getBallXCoordinate and getBallYCoordinate and updateBallPosition
        StdOut.println(paddle.getPaddleXCoordinate()); // should be 0.0
        StdOut.println(paddle.getPaddleYCoordinate()); // should be 0.0
        paddle.movePaddleUp(); // moves paddle up by 0.3
        paddle.movePaddleRight();
        paddle.draw(); // test drawing (paddle should be at (2,0.3)
        StdOut.println(paddle.getPaddleXCoordinate()); // should be 2.0
        StdOut.println(paddle.getPaddleYCoordinate()); // should be 0.3
        // Test reverseBallVelocity by calling it, updating the ball's x and y
        // coordinates, and printing the new coordinates
        paddle.movePaddleDown(); // moves down to 0.0
        paddle.movePaddleDown(); // moves up to 0.3
        paddle.movePaddleUp(); // moves up to 0.6
        StdOut.println(paddle.getPaddleXCoordinate()); // should be 4.0
        StdOut.println(paddle.getPaddleYCoordinate()); // should be 0.6
        paddle.draw(); // test drawing (paddle should be at (4,0.6)

    }
}
