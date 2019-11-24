package com.example.lab07;

public class Journee {

    private int m_image;

    private String m_nom;

    private String m_message;

    //constructeur
    Journee(String nom, int image, String message){

        m_image = image;

        m_nom=nom;

        m_message=message;
    }


    public int getImage() {
        return m_image;
    }

    public void setImage(int image) {
        this.m_image = image;
    }

    public String getNom() {
        return m_nom;
    }

    public void setNom(String nom) {
        this.m_nom = nom;
    }

    public String getM_message() {
        return m_message;
    }

    public void setM_message(String m_message) {
        this.m_message = m_message;
    }
}
