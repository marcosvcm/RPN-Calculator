//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ControleClear implements ActionListener {

	private JTextField painelP;

	public ControleClear(JTextField visorP) {
		this.painelP = visorP;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		painelP.setText("");
	}
}
