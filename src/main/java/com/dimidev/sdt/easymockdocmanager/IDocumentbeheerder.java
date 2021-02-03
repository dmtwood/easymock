package com.dimidev.sdt.easymockdocmanager;

public interface IDocumentbeheerder {
    void addMedewerker(IMedewerker medewerker);

    void addDocument(Document document);

    boolean removeDocument(Document document);

}

