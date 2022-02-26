//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ControleNums implements ActionListener {

	private char numero = 0;
	private JTextField painelP;
	private String guarda = "";

	public ControleNums(JTextField visorP, char numero) {
		this.painelP = visorP;
		this.numero = numero;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		guarda = painelP.getText();
		painelP.setText(guarda + numero);
	}
}
