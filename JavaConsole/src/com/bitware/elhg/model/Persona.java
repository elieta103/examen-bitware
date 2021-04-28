package com.bitware.elhg.model;

import java.util.UUID;

public class Persona {
	private String nombre;
	private int edad;
	private String nss;
	private char sexo;
	private double peso;
	private double altura;

	public Persona() {
		generaNss();
	}

	public Persona(String nombre, int edad, String nss, char sexo, double peso, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
		generaNss();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNss() {
		return nss;
	}

	private void setNss(String nss) {
		this.nss = nss;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public int calcularIMC(){
		double imc;
		int valor=0;
		imc = getPeso() / Math.pow(getAltura(), 2);
			if(comprobarSexo(getSexo())) {
				if(getSexo() == Util.MASCULINO) {
					if(imc>25) {
						valor = Util.SOBRE_PESO;
					}else if(imc>=20 && imc<=25) {
						valor = Util.PESO_IDEAL;
					}else if(imc<20) {
						valor = Util.FALTA_PESO;
					}
				}else {
					if(imc>24) {
						valor = Util.SOBRE_PESO;
					}else if(imc>=19 && imc<=24) {
						valor = Util.PESO_IDEAL;
					}else if(imc<19) {
						valor = Util.FALTA_PESO;
					}					
				}
			}
						
		return valor;
	}

	public boolean esMayorDeEdad() {
		boolean mayorEdad;
		mayorEdad = (getEdad()>=18) ? true: false;
		return mayorEdad;
	}
	
	private boolean comprobarSexo(char sexo) {	
			if(sexo == Util.MASCULINO || sexo == Util.FEMENINO) {
				return true;
			}
		return false;
	}
	
	
	@Override
	public String toString() {
		String sexoStr= (sexo==Util.MASCULINO)?" Masculino":" Femenino";
		return "Nombre : " + nombre + "\nEdad : " + edad + " a�os \nNSS : " + nss + "\n Sexo : " + sexoStr + "\n Peso : " + peso
				+ " Kg\n Altura : " + altura + " mts\n";
	}
	
	private void generaNss() {
		UUID nss = UUID.randomUUID();
	    String nssStr = nss.toString().substring(0, 8);	
	    setNss(nssStr);
	}
}
