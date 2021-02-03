package com.dimidev.sdt.easymockbook;

public class BookDAO  {
    private IConnection connection;

    public BookDAO(IConnection connection) {
        super();
        this.connection = connection;
    }

    public boolean insert(Book boek){

        return connection.insert(boek);
    }
    public Book selectByID(int i){
        return connection.selectByID(i);
    }
}
