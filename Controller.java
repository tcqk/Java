package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {
    //<editor-fold desc="Variables">
    private final int MAX = 59;
    private final int MIN = 1;
    private int textNum1;
    private int textNum2;
    private int textNum3;
    private int textNum4;
    private int textNum5;
    //</editor-fold>

    //<editor-fold desc="FXML Annotations">
    @FXML
    TextField name;
    @FXML
    Pane pane;
    @FXML
    Pane alertpane;
    @FXML
    Label alert;
    @FXML
    Label label1;
    @FXML
    Label label2;
    @FXML
    Label label3;
    @FXML
    Label label4;
    @FXML
    Label label5;
    @FXML
    TextField setNum1;
    @FXML
    TextField setNum2;
    @FXML
    TextField setNum3;
    @FXML
    TextField setNum4;
    @FXML
    TextField setNum5;
    @FXML
    Label checklabel;
    //</editor-fold>
    DB db = new DB();

    /**
     * Alert button action
     * @param event
     */
    @FXML
    private void alertClick(ActionEvent event) { alertWindow();}

    /**
     * Main button action
     * @param event
     */
    @FXML
    private void click(ActionEvent event){fullResult();}

    /**
     * Randomizer
     * @return
     */
    private ArrayList<Integer> randomArr(){
        ArrayList<Integer> my = new ArrayList<>();
        for (int i = 1; i <= MAX; i++){
            my.add(i);
        }
        Random random = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++){
            arr.add(my.remove(random.nextInt(my.size())));
        }

        return arr;
    }

    /**
     * Check if input is correct
     * @return
     */
    private ArrayList<Integer> calculate(){
        try {
            textNum1 = Integer.parseInt(setNum1.getText());
            textNum2 = Integer.parseInt(setNum2.getText());
            textNum3 = Integer.parseInt(setNum3.getText());
            textNum4 = Integer.parseInt(setNum4.getText());
            textNum5 = Integer.parseInt(setNum5.getText());
        } catch (Exception e) {
            alertWindow("Fill empty spaces!");
            System.err.println(e);
            return null;
        }

        Set<Integer> numbers = new HashSet<Integer>();
        numbers.add(textNum1);
        numbers.add(textNum2);
        numbers.add(textNum3);
        numbers.add(textNum4);
        numbers.add(textNum5);

        ArrayList<Integer> userNumbers = new ArrayList<Integer>(numbers);
        for (Integer numb : userNumbers) {
            if (numb < MIN || numb > MAX){
                alertWindow("Out of bounds or\r\nwrong symbols!");
                return null;
            }
        }

        if (numbers.size() != 5){
            alertWindow("Set different numbers!");
            return null;
        }

        return userNumbers;
    }

    /**
     * Sets an alert window.
     * @param out
     */
    private void alertWindow(String out){
        alertpane.setVisible(true);
        alert.setText(out);
        pane.setOpacity(0.3);
        pane.setDisable(true);
    }

    /**
     *Do main task
     * @param i
     */
    private void sett(ArrayList<Integer> i){
            Set<Integer> check = new HashSet<>();
            check.addAll(i);
            if (calculate() != null){
            check.addAll(calculate());
            int score = 0;

            switch(check.size()){
                case 10:
                    checklabel.setText("You guess 0 numbers!");
                    score = 0;
                    break;
                case 9:
                    checklabel.setText("You guess 1 number!");
                    score = 1;
                    break;
                case 8:
                    checklabel.setText("You guess 2 numbers!");
                    score = 2;
                    break;
                case 7:
                    checklabel.setText("You guess 3 numbers!");
                    score = 3;
                    break;
                case 6:
                    checklabel.setText("You guess 4 numbers!");
                    score = 4;
                    break;
                case 5:
                    checklabel.setText("You guess 5 numbers!");
                    score = 5;
                    break;

            }
            db.addRes(name.getText(), score);
                }
}
    public void initialize(URL url, ResourceBundle resourceBundle){
        System.out.println("Krasav4ik!");
//        DB db = new DB();
    }

    private void alertWindow() {
        alertpane.setVisible(false);
        pane.setOpacity(1);
        pane.setDisable(false);
    }

    private void fullResult() {
        ArrayList<Integer> ranRes = randomArr();
        sett(ranRes);

        label1.setText(""+ranRes.get(0));
        label2.setText(""+ranRes.get(1));
        label3.setText(""+ranRes.get(2));
        label4.setText(""+ranRes.get(3));
        label5.setText(""+ranRes.get(4));
    }
}