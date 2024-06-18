package com.dicsstartup.devformfx;

import javafx.scene.paint.Color;

import java.time.LocalDate;

public class Usuario {
    String name,last_name,password,rol,comments;
    Boolean loginPersist;
    Color color;
    LocalDate date_birday;
    Double level;
    App.Lenguaje lenguage;
    public Usuario() {
    }

    public Usuario(String name, String last_name, String password, String rol, App.Lenguaje lenguage, String comments, boolean loginPersist, Color color, LocalDate date_birday, double level) {
        this.name = name;
        this.last_name = last_name;
        this.password = password;
        this.rol = rol;
        this.lenguage = lenguage;
        this.comments = comments;
        this.loginPersist = loginPersist;
        this.color = color;
        this.date_birday = date_birday;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public App.Lenguaje getLenguage() {
        return lenguage;
    }

    public void setLenguage(App.Lenguaje lenguage) {
        this.lenguage = lenguage;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isLoginPersist() {
        return loginPersist;
    }

    public void setLoginPersist(boolean loginPersist) {
        this.loginPersist = loginPersist;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public LocalDate getDate_birday() {
        return date_birday;
    }

    public void setDate_birday(LocalDate date_birday) {
        this.date_birday = date_birday;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", password='" + password + '\'' +
                ", rol='" + rol + '\'' +
                ", lenguage='" + lenguage + '\'' +
                ", comments='" + comments + '\'' +
                ", loginPersist=" + loginPersist +
                ", color=" + color +
                ", date_birday=" + date_birday +
                ", level=" + level +
                '}';
    }
}
