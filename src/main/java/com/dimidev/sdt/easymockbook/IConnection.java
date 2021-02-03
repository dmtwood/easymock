package com.dimidev.sdt.easymockbook;

public interface IConnection {
    boolean insert(Book boek);
    Book selectByID(int i);
    boolean open();
    boolean close();
}
