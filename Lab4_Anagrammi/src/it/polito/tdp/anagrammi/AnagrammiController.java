package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.AnagrammiModel;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.*;

public class AnagrammiController {

	AnagrammiModel m = new AnagrammiModel();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagramma;

    @FXML
    private TextFlow txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagramma(ActionEvent event) {
    	
    	if(!txtParola.getText().matches("[a-zA-Z]*")){
    		return;}
    	String parola = txtParola.getText().toLowerCase();
    	
    	List<String> anagrammiParola= new ArrayList<String>(m.doAnagramma(parola));
    	List<Parola> paroleCorretteFinali = new ArrayList <Parola>(m.cerca(anagrammiParola));
    
    	Text richText = new Text("");

		for (Parola p : paroleCorretteFinali) {
			if (p.getCorretta() == true) {
				richText = new Text(p.getParola() + " ");
			} else {
				richText = new Text(p.getParola() + " ");
				richText.setFill(Color.RED);
			}
			richText.toString();
			txtResult.getChildren().add(richText);
		}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.getChildren().clear();
    	txtParola.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}
