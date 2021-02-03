package com.dimidev.sdt.easymockbook;

public class Book {
    private int id;
    private String titel;
    private String auteur;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public String getAuteur() {
        return auteur;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    public Book() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Book(int id, String titel, String auteur) {
        super();
        this.id = id;
        this.titel = titel;
        this.auteur = auteur;
    }

}
/*
We are developing a DAO that can write a book (ID, title, author) to and read it from adatabase.

You must provide the DAO object with a connection object via its constructor.

We wish to test the DAO in isolation and therefore develop a mock connect object based on its interface.

The connection object interface contains the following methods:
•boolean insert(Boek boek)
•Boek selectByID(int i)
•boolean open()
•boolean close()

Implement the most important unit tests using EasyMock.
 */
