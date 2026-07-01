package com.nexus.nexus;

import com.nexus.nexus.db.DatabaseManager;
import com.nexus.nexus.view.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        DatabaseManager.createTables();
        new LoginView(stage).show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}