public abstract class DocumentFactory {
    
    // The Factory Method
    public abstract Document createDocument();
    
    // An optional common workflow method that uses the factory method
    public void processNewDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
        doc.close();
    }
}