package com.nexus.nexus;

import com.nexus.nexus.db.DatabaseManager;
import com.nexus.nexus.db.SubjectRepository;
import com.nexus.nexus.model.Subject;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.createTables();

        Subject math = new Subject("Mathematics", "#007AFF");
        Subject physics = new Subject("Physics", "#FF9500");

        SubjectRepository.add(math);
        SubjectRepository.add(physics);

        List<Subject> subjects = SubjectRepository.getAll();
        for (Subject s : subjects) {
            System.out.println("id=" + s.getId() + " name=" + s.getName() + " color=" + s.getColorHex());
        }
    }
}