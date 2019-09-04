package com.senati.model;

public class Usuario {
	private int idusuario;
	private String nombre_usu;
	private String clave;
	public Usuario(int idusuario, String nombre_usu, String clave) {
		super();
		this.idusuario = idusuario;
		this.nombre_usu = nombre_usu;
		this.clave = clave;
	}
	public Usuario() {
		super();
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre_usu() {
		return nombre_usu;
	}
	public void setNombre_usu(String nombre_usu) {
		this.nombre_usu = nombre_usu;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	@Override
	public String toString() {
		return "Usuario [idusuario=" + idusuario + ", nombre_usu=" + nombre_usu + ", clave=" + clave + "]";
	}
}
