package sample;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public AnchorPane pan;

    public Label win;

    int x=300;
    int y =50;
    int [] lx ={150, 300, 450, 290, 310, 290, 310,};
    int [] ly ={150, 50, 150, 350, 350, 125, 125};
    ArrayList<Circle> cl = new ArrayList<Circle>();
    Circle c = new Circle();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int i = 0; i < lx.length; i++) {
            Circle c = new Circle();
            c.setFill(Color.BLACK);
            c.setRadius(5);
            c.setStroke(Color.BLACK);
            c.setStrokeType(StrokeType.INSIDE);
            c.setLayoutX(lx[i]);
            c.setLayoutY(ly[i]);
            c.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    c.setFill(Color.RED);

                    {
                        Line l1 = new Line(x, y, c.getLayoutX(),c.getLayoutY());
                        x=(int)c.getLayoutX();
                        y=(int)c.getLayoutY();
                        pan.getChildren().add(l1);}

                }
            });
            cl.add(c);
        }
        pan.getChildren().addAll( cl);
    }
}
