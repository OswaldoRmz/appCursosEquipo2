<?php
header('Content-Type: application/json; charset=utf-8');
require_once "config/conexion.php";

// Manejo seguro de la variable de conexion
if (!isset($conexion) && isset($conn)) {
    $conexion = $conn;
} elseif (!isset($conexion) && isset($pdo)) {
    $conexion = $pdo;
}

try {
    $id_carrera = isset($_GET['id_carrera']) ? intval($_GET['id_carrera']) : null;

    if ($id_carrera) {
        $sql = "SELECT c.id_cursos, c.nombre, c.descripcion, c.espacio, c.horas, c.dias, c.cupo, c.imagen_url, c.id_carrera, COUNT(i.id_inscripcion) AS inscritos FROM cursos c 
                LEFT JOIN inscripcion i ON c.id_cursos = i.id_cursos WHERE c.id_carrera = :id_carrera GROUP BY c.id_cursos";
        $stmt = $conexion->prepare($sql);
        $stmt->execute([':id_carrera' => $id_carrera]);
    } else {
        $sql = "SELECT c.id_cursos, c.nombre, c.descripcion, c.espacio, c.horas, c.dias, c.cupo, c.imagen_url, c.id_carrera, COUNT(i.id_inscripcion) AS inscritos 
                FROM cursos c LEFT JOIN inscripcion i ON c.id_cursos = i.id_cursos GROUP BY c.id_cursos";
        $stmt = $conexion->prepare($sql);
        $stmt->execute();
    }

    $cursos = $stmt->fetchAll(PDO::FETCH_ASSOC);
    echo json_encode($cursos, JSON_UNESCAPED_UNICODE);

} catch (PDOException $e) {
    echo json_encode(["error" => "Error al obtener los cursos: " . $e->getMessage()]);
}
?>