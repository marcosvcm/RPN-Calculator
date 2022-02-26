//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.model;

public class Numero {
	private double num = 0;
	private double numj = 0;

	public boolean ecomplex() {
		if (numj != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void setImg(double numero) {
		this.numj = numero;
	}

	public void setNumero(double real, double imaginario) {
		this.num = real;
		this.numj = imaginario;
	}

	public void setNumero(double real) {
		this.num = real;
	}

	public Numero(double real, double imaginario) {
		this.setNumero(real, imaginario);
	}

	public Numero(double real) {
		this.setNumero(real);
	}

	public double getReal() {
		return num;
	}

	public double getImg() {
		return numj;
	}

	public Numero conjugado() {
		Numero n1 = new Numero(num, -numj);
		return n1;
	}

	public Numero inverso() {
		Numero n1 = new Numero(-num, -numj);
		return n1;
	}

	public String texto() {
		String retorna = "" + num;
		if (ecomplex()) {
			if (numj >= 0) {
				retorna += " +" + numj + "j";
			} else {
				retorna += " " + numj + "j";
			}
		}
		return retorna;
	}

	public void imprime() {
		System.out.println(texto());
	}
}
