package com.alkewallet.model;

public class cuenta {
	
	    private double saldo;

	    public cuenta() {
	        saldo = 100000;
	    }

	    public double getSaldo() {
	        return saldo;
	    }

	    public void depositar(double monto) {
	        if (monto > 0) {
	            saldo += monto;
	        }
	    }

	    public boolean retirar(double monto) {
	        if (monto > 0 && monto <= saldo) {
	            saldo -= monto;
	            return true;
	        }

	        return false;
	    }
	}


