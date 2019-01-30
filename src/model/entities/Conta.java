package model.entities;

import model.exceptions.DomainException;

public class Conta {

	private Integer numero;
	private String titular;
	private Double saldo;
	private Double limiteSaque;

	public Conta(Integer numero, String titular, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public void deposito(double montante) {
		saldo += montante;
	}

	public void saque(double montante) {

		if (montante > limiteSaque) {
			throw new DomainException("O valor do saque excede o limite");
		}
		if (montante > saldo) {
			throw new DomainException("Não há saldo suficiente para realizar o saque");
		}

		saldo -= montante;

	}
}