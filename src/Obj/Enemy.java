package Obj;

import javafx.scene.image.Image;

public class Enemy extends Entity implements shootable {

	
	@Override
    public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }
    @Override
    public void setImage(String filename) {
  
        Image i = new Image(filename,100,100,false,false);
        setImage(i);
    }
	@Override
	public Bullet shoot() {
		// TODO Auto-generated method stub
		
	}
}
