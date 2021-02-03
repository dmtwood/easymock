package com.dimidev.sdt.easymockdocmanager;


import java.util.HashSet;
import java.util.Set;

public class Documentbeheerder implements IDocumentbeheerder {

    private Set<IMedewerker> medewerkers = new HashSet<IMedewerker>();

    private Set<Document> documents = new HashSet<Document>();

    public void addMedewerker(IMedewerker medewerker) {
        medewerkers.add(medewerker);
    }

    public void addDocument(Document document) {
        boolean documentChange = documents.contains(document);
        documents.add(document);
        if (documentChange) {
            notifyListenersDocumentChanged(document);
        } else {
            notifyListenersDocumentAdded(document);
        }
    }

    public boolean removeDocument(Document document) {
        if (!documents.contains(document) || !listenersAllowRemoval(document)) {
            return false;
        } else {
            documents.remove(document);
            notifyListenersDocumentRemoved(document);
            return true;
        }

    }

    private void notifyListenersDocumentAdded(Document document) {
        for (IMedewerker listener : medewerkers) {
            listener.documentAdded(document);
        }
    }

    private void notifyListenersDocumentChanged(Document document) {
        for (IMedewerker listener : medewerkers) {
            listener.documentChanged(document);
        }
    }

    private void notifyListenersDocumentRemoved(Document document) {
        for (IMedewerker listener : medewerkers) {
            listener.documentRemoved(document);
        }
    }

    private boolean listenersAllowRemoval(Document document) {
        boolean result = false;
        for (IMedewerker listener : medewerkers) {
            result = listener.voteForRemoval(document);
        }
        return result;
    }

}