package application;
	
import java.util.ArrayList;
import java.util.Iterator;

import Obj.Bullet;
import Obj.SpaceShip;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;



public class Main extends Application {
	public static boolean a=true;
    @Override
    public void start(Stage theStage) 
    {
    	
    	
        theStage.setTitle( "Space Adventure!" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 700, 900 );
        root.getChildren().add( canvas );

        ArrayList<String> input = new ArrayList<String>();
        ArrayList<Bullet> bulletcount = new ArrayList<Bullet>();
        
        theScene.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    
                    
                    
                    if ( !input.contains(code) && code=="SPACE" && a) {
                        input.add( code );
                        a=false;
                    }
                    else if ( !input.contains(code) ) {
                    	input.add( code );
                    }
                }
            });

        theScene.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    
                    input.remove( code );
                    if(code=="SPACE")a=true;
                }
            });

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Font theFont = Font.font( "Helvetica", FontWeight.BOLD, 24 );
        gc.setFont( theFont );
        gc.setFill( Color.GREEN );
        gc.setStroke( Color.BLACK );
        gc.setLineWidth(1);
        
        theStage.show();
        
        LongValue lastNanoTime = new LongValue( System.nanoTime() );

        IntValue score = new IntValue(0);
        
        SpaceShip spaceship = new SpaceShip();
        
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;
                
                // game logic
               
                spaceship.setVelocity(0,0);
                if (input.contains("LEFT"))
                	spaceship.addVelocity(-250,0);
                if (input.contains("RIGHT"))
                	spaceship.addVelocity(250,0);
                if (input.contains("UP"))
                	spaceship.addVelocity(0,-250);
                if (input.contains("DOWN"))
                	spaceship.addVelocity(0,250);
                if (input.contains("SPACE")) {
                	Bullet a=spaceship.shoot();
                	bulletcount.add(a);
                	input.remove( "SPACE" );
                }
                	
                
    
                spaceship.update(elapsedTime);
                
                for(Bullet b:bulletcount) {
                	b.update(elapsedTime);
                }
                
                gc.clearRect(0, 0, 700,900);
                spaceship.render( gc );
                for(int i=0;i<bulletcount.size();i++) {
                	bulletcount.get(i).render(gc);
                	
                }
              

                String pointsText = "Score : " + (100 * score.value);
                gc.fillText( pointsText, 50, 50 );
                gc.strokeText( pointsText, 50, 50 );
            }
        }.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
