
import java.awt.*;
   
public class Polkadot
{
   private double myX;   // x and y coordinates of center
   private double myY;
   private double myDiameter;
   private Color myColor; 
   private double myRadius;
     // constructors
   public Polkadot()     //default constructor
   {
      myX = 200;
      myY = 200;
      myDiameter = 25;
      myColor = Color.RED;
      myRadius = myDiameter/2;
   }
   public Polkadot(double x, double y, double d, Color c)
   {
      myX = x;
      myY = y;
      myDiameter = d;
      myColor = c;
      myRadius = d/2;
   }
    // accessor methods
   public double getX() 
   { 
      return myX;
   }
		
		
   public double getY()      
   { 
      return myY;
   }
		
		
   public double getDiameter() 
   { 
      return myDiameter;
   }
		
		
   public Color getColor() 
   { 
      return myColor;
   }
		
		
   public double getRadius() 
   { 
      return myRadius;
   }
		
   // modifier methods
   public void setX(double x)
   {
      myX = x;
   } 
		
		
   public void setY(double y)
   {
      myY = y;
   } 
      
		/**
		 * Sets the new color to c.
		 * @param c the color
		 */
   public void setColor(Color c)
   {
      myColor = c;
   }
		
		
   public void setDiameter(double d)
   {
      myDiameter = d;
      myRadius = d/2;
   }
		
		
   public void setRadius(double r)
   {
      myRadius = r;
      myDiameter = 2*r;
   }
		
		
    //	 instance methods
   public void jump(int rightEdge, int bottomEdge)
   {
         // moves location to random (x, y) within the edges
      myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
      myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
   }
		
		
   public void draw(Graphics myBuffer) 
   {
      myBuffer.setColor(myColor);
      myBuffer.fillRect((int)(myX - myRadius), (int)(myY-myRadius), (int)myDiameter, (int)myDiameter);
   }
      
      
}
