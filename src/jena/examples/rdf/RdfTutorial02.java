package jena.examples.rdf;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.*;

/** Tutorial 2 - Resources as property values */
public class RdfTutorial02 extends Object {

    public static void main(String[] args) {
        // some definitions
        String personURI = "http://somewhere/JohnSmith";
        String givenName = "John";
        String familyName = "Smith";
        String fullName = givenName + " " + familyName;

        // create an empty model
        Model model = ModelFactory.createDefaultModel();

        // create the resource
        // and add the properties in cascading style
        Resource johnSmith = model.createResource(personURI)
                .addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N,
                        model.createResource()
                                .addProperty(VCARD.Given, givenName)
                                .addProperty(VCARD.Family, familyName));

        // Write RDF model to the console in RDF/XML format
        model.write(System.out, "RDF/XML");

        // Optional: Debugging - print the model size
        System.out.println("Model size: " + model.size() + " statements.");
    }
}

