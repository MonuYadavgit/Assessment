<?php
    $hostname = "localhost : 8889";
    $username = "root";
    $password = "root";
    try {
        $connection = new PDO("mysql:host=$hostname;dbname=php_db", $username, $password);
        // set the PDO error mode to exception
        $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        //echo "Database connected successfully";
    } catch(PDOException $e) {
        echo "Database connection failed: " . $e->getMessage();
    }
?>