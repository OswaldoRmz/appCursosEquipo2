<?php

header("Content-Type: application/json; charset=utf-8");
require_once "config/conexion.php";

try {
    $consulta = $pdo->query("SELECT id_carrera, nombre, imagen_url FROM carrera ORDER BY id_carrera ASC"
    );

    echo json_encode($consulta->fetchAll());

} catch (PDOException $e) {
    http_response_code(500);

    echo json_encode([
        "error" => "No se pudieron obtener las carreras"
    ]);
}
?>