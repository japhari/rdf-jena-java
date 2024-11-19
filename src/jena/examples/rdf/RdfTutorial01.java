package jena.examples.rdf;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

public class RdfTutorial01 extends Object {
    // some definitions
    static String personURI = "http://somewhere/JohnSmith";
    static String fullName = "John Smith";

    public static void main(String[] args) {
        System.out.println("Starting RDF Tutorial...");  // Debug statement

        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        Resource johnSmith = model.createResource(personURI);

        // add the property
        johnSmith.addProperty(VCARD.FN, fullName);

        // Write the RDF model to the console in RDF/XML format
        model.write(System.out, "RDF/XML");

        System.out.println("Finished writing RDF model.");  // Debug statement
    }
}
