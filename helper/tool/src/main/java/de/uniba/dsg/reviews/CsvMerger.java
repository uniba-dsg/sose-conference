package de.uniba.dsg.reviews;

import java.util.Arrays;
import java.util.List;

public class CsvMerger {
    public static void main(String[] args) {
        Library library = new Library();
        /*
        SheetName	#HeaderRows	Title	Authors	Year	DOI	Link
            Scopus	1	2	1	3	12	13
            ACM	1	7	3	19	12
            Springer	1	1	7	8	6	9
            IEEE-1	2	1	2	6	14	16
            TODO header rows must be removed right now!
         */
        Mapping scopus = new Mapping(1, 0, 2, 11, 12);
        Mapping acm = new Mapping(6, 2, 18, 11, 11);
        Mapping springer = new Mapping(0, 6, 7, 5, 8);
        Mapping ieee = new Mapping(0, 1, 5, 13, 15);
        List<Mapping> mappings = Arrays.asList(scopus, acm, ieee, springer);

        //library.fromCsvFiles(Arrays.asList("scopus.csv", "acm.csv", "ieeexplore.csv", "springerlink.csv"), mappings);
        library.doYaml("pc.csv");

        //library.parseRelevance("stefan.csv", 0);
        //library.parseRelevance("christoph.csv", 1);
        //library.parseRelevance("joerg.csv", 2);

        //library.toCsvFile("consolidated.csv");
    }
}
