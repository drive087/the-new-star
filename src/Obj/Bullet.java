package Obj;

import com.sun.prism.paint.Color;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends Entity {
	protected Bullet bullet;
	public Bullet() {
        setImage("bullet.png");
	
		
	
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
  
        Image i = new Image(filename,25,25,false,false);
        ImageView iv = new ImageView(i);
        iv.setRotate(270);
        SnapshotParameters params = new SnapshotParameters();

        Image rotatedImage = iv.snapshot(params, null);
        setImage(rotatedImage);
    }
}
