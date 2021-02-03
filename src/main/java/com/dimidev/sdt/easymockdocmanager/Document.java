package com.dimidev.sdt.easymockdocmanager;


import java.util.Objects;

public class Document {
    private String titel;
    private String path;

    public Document() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Document(String titel) {
        super();
        this.titel = titel;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titel == null) ? 0 : titel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return getTitel().equals(document.getTitel());
    }

}