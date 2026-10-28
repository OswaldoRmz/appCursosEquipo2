<?php

$host = "localhost";
$baseDatos = "cursos_bd1";
$usuario = "root";
$contrasena = "";

try {
    $pdo = new PDO("mysql:host=$host;dbname=$baseDatos;charset=utf8mb4", $usuario, $contrasena);

    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $pdo->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);

} catch (PDOException $e) {
    http_response_code(500);
    header("Content-Type: application/json; charset=utf-8");

    echo json_encode(["error" => "Error de conexión con la base de datos"]);

    exit;
}
?>