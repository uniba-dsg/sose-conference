package de.uniba.dsg.reviews;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.esotericsoftware.yamlbeans.YamlWriter;
import com.opencsv.CSVReader;

public class Library {
    private static final Logger log = Logger.getLogger(Library.class.getName());

    static Map<String, Entry> entries = new HashMap<>();
    static List<Member> noDoi = new ArrayList<>();

    public void doYaml(String filePath) {
        try (Reader in = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
             CSVReader reader = new CSVReader(in, ';')) {
            log.info("Processing file: " + filePath);

            // header
            reader.readNext();

            String[] record;

            while ((record = reader.readNext()) != null) {
                String name = record[0].trim();
                String surname = record[1].trim();
                String uni = record[2].trim();
                String country = record[3].trim();
                String site = record[5].trim();

                Member m = new Member();
                m.setName(name);
                m.setSurname(surname);
                m.setTitle(uni + ", " + country);
                m.setPc(true);
                Obj links = new Obj();
                links.name = "site";
                links.link = site;
                Map kv = new HashMap<String, String>();
                kv.put("name", "site");
                kv.put("link", site);
                m.setSocial(Arrays.asList(kv));

                noDoi.add(m);
            }

            YamlWriter writer = new YamlWriter(new OutputStreamWriter(new FileOutputStream("output.yml"), StandardCharsets.UTF_8));
            writer.write(noDoi);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
