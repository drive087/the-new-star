package Obj;

import javafx.scene.image.Image;

public class SpaceShip extends Entity implements shootable {

	
	public SpaceShip() {
        setImage("spaceship.png");
		
		this.setPosition(300, 700);
	
	}
	
	@Override
    public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }
	@Override
    public void setImage(String filename) {
  
        Image i = new Image(filename,80,130,false,false);
        setImage(i);
    }

	@Override
	public Bullet shoot() {
		Bullet bullet=new Bullet();
		bullet.setPosition(this.getPositionX()+35, this.getPositionY()-10);
		bullet.setVelocity(0, -250);
		return bullet;
		
	}

	
	
}
