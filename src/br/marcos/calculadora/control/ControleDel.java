//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ControleDel implements ActionListener {

	private int tam = 0;
	private JTextField painelP;
	private String guarda = "";

	public ControleDel(JTextField visorP) {
		this.painelP = visorP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		guarda = painelP.getText();
		tam = guarda.length();
		if (tam > 0) {
			painelP.setText(guarda.substring(0, tam - 1));
		}
	}
}
