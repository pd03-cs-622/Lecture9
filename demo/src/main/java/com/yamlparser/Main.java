package com.yamlparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;


public class Main {
    // public class contact {
    //     private String email;
    //     private String phone;
    // }

    // public class employees {
    //     private String name;
    //     private String role;
    //     private contact contact;
    // }

    // public class departments {
    //     private String name;
    //     private String head;
    //     private employees employees;
    // }

    public static void YamlParser() {
        try {
            InputStream inputStream = new FileInputStream(new File("data/test.yaml"));
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(inputStream);
            List<String> departments = data.get("departments");
            List<String> marketing = departments.get(2);

            System.out.println(marketing);

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    public static void main(String[] args) {
        YamlParser();
    }
}