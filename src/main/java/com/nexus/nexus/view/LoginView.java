package com.nexus.nexus.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginView {

    private Stage stage;

    public LoginView(Stage stage) {
        this.stage = stage;
    }

    public void show() {
        // --- Logo box ---
        Label logoLabel = new Label("N");
        logoLabel.setFont(Font.font(20));
        logoLabel.setTextFill(Color.WHITE);

        StackPane logoBox = new StackPane(logoLabel);
        logoBox.setPrefSize(45, 45);
        logoBox.setStyle(
                "-fx-background-color: #007AFF;" +
                        "-fx-background-radius: 12;" +
                            "-fx-font-weight: bold;"
        );

        // --- App name ---
        Label appName = new Label("Nexus");
        appName.setFont(Font.font(20));
        appName.setStyle("-fx-font-weight: bold;");

        Label appSub = new Label("Your smart study planner");
        appSub.setStyle("-fx-text-fill: #888888; -fx-font-size: 13;");

        // --- Username field ---
        Label userLabel = new Label("USERNAME");
        userLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #888888;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setPrefHeight(38);
        usernameField.setStyle(
                "-fx-background-radius: 8;" +
                        "-fx-border-radius: 8;" +
                        "-fx-border-color: #DEDEDE;" +
                        "-fx-border-width: 1;" +
                        "-fx-font-size: 14;"
        );

        // --- Password field ---
        Label passLabel = new Label("PASSWORD");
        passLabel.setStyle("-fx-font-size: 11; -fx-text-fill: #888888;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefHeight(38);
        passwordField.setStyle(
                "-fx-background-radius: 8;" +
                        "-fx-border-radius: 8;" +
                        "-fx-border-color: #DEDEDE;" +
                        "-fx-border-width: 1;" +
                        "-fx-font-size: 14;"
        );

        // --- Login button ---
        Button loginBtn = new Button("Sign in");
        loginBtn.setPrefWidth(Double.MAX_VALUE);
        loginBtn.setPrefHeight(38);
        loginBtn.setStyle(
                "-fx-background-color: #007AFF;" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 8;" +
                        "-fx-font-size: 14;" +
                        "-fx-font-weight: bold;"
        );

        // --- Register button ---
        Button registerBtn = new Button("Create account");
        registerBtn.setPrefWidth(Double.MAX_VALUE);
        registerBtn.setPrefHeight(38);
        registerBtn.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: #DEDEDE;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-font-size: 14;"
        );

        // --- Card layout ---
        VBox card = new VBox(10);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(40, 32, 40, 32));
        card.setMaxWidth(340);
        card.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 16;" +
                        "-fx-border-radius: 16;" +
                        "-fx-border-color: #EEEEEE;" +
                        "-fx-border-width: 1;"
        );
        card.getChildren().addAll(
                logoBox, appName, appSub,
                userLabel, usernameField,
                passLabel, passwordField,
                loginBtn, registerBtn
        );

        // --- Root layout ---
        StackPane root = new StackPane(card);
        root.setStyle("-fx-background-color: #F5F5F7;");
        root.setPadding(new Insets(40));

        // --- Scene and Stage ---
        Scene scene = new Scene(root, 500, 600);
        stage.setTitle("Nexus");
        stage.setScene(scene);
        stage.show();
    }
}