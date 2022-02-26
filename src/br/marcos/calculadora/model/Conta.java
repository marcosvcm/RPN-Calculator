//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.model;

public class Conta {
	public static Numero soma(Pilha pilha) {
		Numero resultado = new Numero(0);
		if (pilha.size() < 2) {
			System.out.println("Faltam dados na memória.");
			resultado = null;
		} else {
			Numero n1 = pilha.pop();
			Numero n2 = pilha.pop();
			resultado.setNumero(n1.getReal() + n2.getReal(), n1.getImg() + n2.getImg());
			pilha.push(resultado);
		}
		return resultado;
	}

	public static Numero sub(Pilha pilha) {
		Numero resultado = new Numero(0);
		if (pilha.size() < 2) {
			System.out.println("Faltam dados na memória.");
			resultado = null;
		} else {
			Numero n2 = pilha.pop();
			Numero n1 = pilha.pop();
			resultado.setNumero(n1.getReal() - n2.getReal(), n1.getImg() - n2.getImg());
			pilha.push(resultado);
		}
		return resultado;
	}

	public static Numero mult(Pilha pilha) {
		Numero resultado = new Numero(0);
		if (pilha.size() < 2) {
			System.out.println("Faltam dados na memória.");
			resultado = null;
		} else {
			Numero n1 = pilha.pop();
			Numero n2 = pilha.pop();
			resultado.setNumero(n1.getReal() * n2.getReal() - n1.getImg() * n2.getImg(),
					n1.getReal() * n2.getImg() + n2.getReal() * n1.getImg());
			pilha.push(resultado);
		}
		return resultado;
	}

	private static Numero mult(Numero n1, Numero n2) {
		Numero resultado = new Numero(0);
		resultado.setNumero(n1.getReal() * n2.getReal() - n1.getImg() * n2.getImg(),
				n1.getReal() * n2.getImg() + n2.getReal() * n1.getImg());
		return resultado;
	}

	public static Numero div(Pilha pilha) {
		Numero resultado = new Numero(0);
		if (pilha.size() < 2) {
			System.out.println("Faltam dados na memória.");
			resultado = null;
		} else {
			Numero n2 = pilha.pop();
			Numero n1 = pilha.pop();
			if (n2.getReal() == 0) {
				System.out.println("Divisão por zero.");
				resultado = new Numero(n1.getReal() / n2.getReal());
			} else if (!n2.ecomplex() && !n1.ecomplex()) {
				resultado = new Numero(n1.getReal() / n2.getReal());
				pilha.push(resultado);
			} else {
				n1 = mult(n1, n2.conjugado());
				n2 = mult(n2, n2.conjugado());
				resultado = new Numero(n1.getReal() / n2.getReal(), n1.getImg() / n2.getReal());
				pilha.push(resultado);
			}
		}
		return resultado;
	}

	public static Numero modulo(Pilha pilha) {
		Numero resultado = new Numero(0);
		if (pilha.size() < 1) {
			System.out.println("Faltam dados na memória.");
			resultado = null;
		} else {
			Numero n1 = pilha.pop();
			resultado.setNumero(Math.sqrt(Math.pow(n1.getReal(), 2) + Math.pow(n1.getImg(), 2)));
			pilha.push(resultado);
		}
		return resultado;
	}

	public static Numero exponencial(Pilha pilha) {
		Numero resultado = new Numero(0);
		if (pilha.size() < 2) {
			System.out.println("Faltam dados na memória.");
			resultado = null;
		} else {
			Numero n2 = pilha.pop();
			Numero n1 = pilha.pop();
			double a, b, c, d;
			Numero nn1, nn2, nn3, nn4;
			a = Math.sqrt(Math.pow(n1.getReal(), 2) + Math.pow(n1.getImg(), 2));
			if (n1.getReal() == 0) {
				b = Math.PI / 2;
			} else {
				b = Math.atan(n1.getImg() / n1.getReal());
			}
			c = n2.getReal();
			d = n2.getImg();
			nn1 = new Numero(Math.pow(a, c) * Math.exp(-b * d));
			nn3 = new Numero(Math.cos(d * Math.log(a)), Math.sin(d * Math.log(a)));
			nn2 = new Numero(Math.cos(b * c), Math.sin(b * c));
			nn4 = mult(nn2, nn3);
			resultado = mult(nn1, nn4);
			pilha.push(resultado);
		}
		return resultado;
	}
}
