package kz.aitu.oop.practice.practice2;

import java.sql.*;
import java.util.Scanner;

class TrainManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/train", "root", "");
            Statement statement = connection.createStatement();
            // interact with the user via console
            while (true) {
                System.out.println("1. Create train");
                System.out.println("2. Add carriages or passenger");
                System.out.println("3. Remove carriages or passenger");
                System.out.println("4. Delete train");
                System.out.println("5. Get train information");
                System.out.println("6. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter train id");
                        String trainId = scanner.next();
                        System.out.println("Enter number of carriages");
                        int carriageNum = scanner.nextInt();
                        System.out.println("Enter point A");
                        String pointA = scanner.next();
                        System.out.println("Enter point B");
                        String pointB = scanner.next();
                        System.out.println("Enter max capacity");
                        int maxCapacity = scanner.nextInt();
                        System.out.println("Enter number of passengers");
                        int passengerNum = scanner.nextInt();
                        // create train and insert into the database
                        statement.executeUpdate("INSERT INTO train (id, carriage_num, point_a, point_b, max_capacity, passenger_num) VALUES ('" + trainId + "', " + carriageNum + ", '" + pointA + "', '" + pointB + "', " + maxCapacity + ", " + passengerNum + ")");
                        break;
                    }
                    case 2 -> {
                        System.out.println("Enter train id");
                        String trainId = scanner.next();
                        System.out.println("Enter number of carriages to add");
                        int carriageNum = scanner.nextInt();
                        System.out.println("Enter number of passengers to add");
                        int passengerNum = scanner.nextInt();
                        statement.executeUpdate("UPDATE train SET carriage_num = carriage_num + " + carriageNum + ", passenger_num = passenger_num + " + passengerNum + " WHERE id = '" + trainId + "'");
                        break;
                    }
                    case 3 -> {
                        System.out.println("Enter train id");
                        String trainId = scanner.next();
                        System.out.println("Enter number of carriages to remove");
                        int carriageNum = scanner.nextInt();
                        System.out.println("Enter number of passengers to remove");
                        int passengerNum = scanner.nextInt();
                        statement.executeUpdate("UPDATE train SET carriage_num = carriage_num - " + carriageNum + ", passenger_num = passenger_num - " + passengerNum + " WHERE id = '" + trainId + "'");
                        break;
                    }
                    case 4 -> {
                        System.out.println("Enter train id");
                        String trainId = scanner.next();
                        statement.executeUpdate("DELETE FROM train WHERE id = '" + trainId + "'");
                        break;
                    }
                    case 5 -> {
                        System.out.println("Enter train id");
                        String trainId = scanner.next();
                        ResultSet resultSet = statement.executeQuery("SELECT * FROM train WHERE id = '" + trainId + "'");
                        while (resultSet.next()) {
                            System.out.println("Id: " + resultSet.getString("id"));
                            System.out.println("Number of carriages: " + resultSet.getInt("carriage_num"));
                            System.out.println("Point A: " + resultSet.getString("point_a"));
                            System.out.println("Point B: " + resultSet.getString("point_b"));
                            System.out.println("Max capacity: " + resultSet.getInt("max_capacity"));
                            System.out.println("Number of passengers: " + resultSet.getInt("passenger_num"));
                        }
                    }
                    case 6 -> {
                        System.exit(0);
                        break;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}