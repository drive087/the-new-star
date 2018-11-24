package Obj;

import javafx.scene.image.Image;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;

public abstract class Entity
{
	public static ArrayList<Bullet> bullet = new ArrayList<>();
	public static ArrayList<Enemy> enemy = new ArrayList<>();

    protected Image image;
    protected double positionX;
    protected double positionY;    
    protected double velocityX;
    protected double velocityY;
    protected GraphicsContext gc;
    protected double width;
    protected double height;

    public Entity()
    {
        positionX = 0;
        positionY = 0;    
        velocityX = 0;
        velocityY = 0;
       
    }
    
    public abstract void setImage(Image i);

    public abstract void setImage(String filename);
    public Image getImage() {
    	return image;
    }

    public void setPosition(double x, double y)
    {
        positionX = x;
        positionY = y;
    }

    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }
    public double getVelocityX() {
    	return velocityX;
    }
    public double getVelocityY() {
    	return velocityY;
    }
    public double getPositionX() {
    	return positionX;
    }
    public double getPositionY() {
    	return positionY;
    }
    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time)
    {
        positionX += velocityX * time;
        positionY += velocityY * time;
      
    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, positionX, positionY );
        
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Entity s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
    
 


}
