<?php

header('Content-Type: application/json; charset=utf-8');

require_once 'config/conexion.php';

$metodo = $_SERVER['REQUEST_METHOD'];

try {
    //METODO GET BUSCAR AL ALUMNO
    if ($metodo === 'GET') {

        $matricula = filter_var(
            $_GET['matricula'] ?? null,
            FILTER_VALIDATE_INT
        );

        if (!$matricula || $matricula < 1) {
            http_response_code(400);

            echo json_encode([
                'ok' => false,
                'mensaje' => 'Debes enviar una matrícula válida.'
            ], JSON_UNESCAPED_UNICODE);

            exit;
        }

        // Buscar alumno
        $stmt = $pdo->prepare(
            'SELECT matricula, nombre, correo
             FROM alumnos
             WHERE matricula = ?'
        );

        $stmt->execute([$matricula]);

        $alumno = $stmt->fetch();

        if (!$alumno) {
            http_response_code(404);

            echo json_encode([
                'ok' => false,
                'mensaje' => 'No existe un alumno con esa matrícula.'
            ], JSON_UNESCAPED_UNICODE);

            exit;
        }

        echo json_encode([
            'ok' => true,
            'alumno' => [
                'matricula' => (int)$alumno['matricula'],
                'nombre' => $alumno['nombre'],
                'correo' => $alumno['correo']
            ]
        ], JSON_UNESCAPED_UNICODE);

        exit;
    }

    // METODO POST PAR REGISTRAR AL ALUMNO
    if ($metodo === 'POST') {

        // Leer JSON
        $datos = json_decode(
            file_get_contents('php://input'),
            true
        );

        // También permite form-data
        if (!is_array($datos)) {
            $datos = $_POST;
        }

        $matricula = filter_var(
            $datos['matricula'] ?? null,
            FILTER_VALIDATE_INT
        );

        $idCurso = filter_var(
            $datos['id_cursos'] ?? null,
            FILTER_VALIDATE_INT
        );

        if (
            !$matricula ||
            !$idCurso ||
            $matricula < 1 ||
            $idCurso < 1
        ) {
            http_response_code(400);

            echo json_encode([
                'ok' => false,
                'mensaje' => 'Envía matricula e id_cursos como números válidos.'
            ], JSON_UNESCAPED_UNICODE);

            exit;
        }


        //VERIFICA SI YA ESTABA INSCRITO
        $stmt = $pdo->prepare(
            'SELECT matricula, nombre, correo
             FROM alumnos
             WHERE matricula = ?'
        );

        $stmt->execute([$matricula]);

        $alumno = $stmt->fetch();

        if (!$alumno) {
            http_response_code(404);

            echo json_encode([
                'ok' => false,
                'mensaje' => 'No existe un alumno con esa matrícula.'
            ], JSON_UNESCAPED_UNICODE);

            exit;
        }

        //checa si el curso existe
        $stmt = $pdo->prepare(
            'SELECT id_cursos, nombre, cupo
             FROM cursos
             WHERE id_cursos = ?'
        );

        $stmt->execute([$idCurso]);

        $curso = $stmt->fetch();

        if (!$curso) {
            http_response_code(404);

            echo json_encode([
                'ok' => false,
                'mensaje' => 'No existe ese curso.'
            ], JSON_UNESCAPED_UNICODE);

            exit;
        }
        // Verificar si ya está inscrito
        $stmt = $pdo->prepare(
            'SELECT COUNT(*)
             FROM inscripcion
             WHERE matricula = ?
             AND id_cursos = ?'
        );

        $stmt->execute([
            $matricula,
            $idCurso
        ]);

        $yaInscrito = $stmt->fetchColumn();

        if ($yaInscrito > 0) {
            http_response_code(409);

            echo json_encode([
                'ok' => false,
                'mensaje' => 'El alumno ya está inscrito en ese curso.'
            ], JSON_UNESCAPED_UNICODE);

            exit;
        }
        // Verificar cupo

        if ($curso['cupo'] !== null) {

            $stmt = $pdo->prepare(
                'SELECT COUNT(*)
                 FROM inscripcion
                 WHERE id_cursos = ?'
            );

            $stmt->execute([$idCurso]);

            $inscritos = $stmt->fetchColumn();

            if ($inscritos >= $curso['cupo']) {

                http_response_code(409);

                echo json_encode([
                    'ok' => false,
                    'mensaje' => 'El curso ya no tiene lugares disponibles.'
                ], JSON_UNESCAPED_UNICODE);

                exit;
            }
        }
        // Registrar inscripción
        $fecha = date('Y-m-d');

        $stmt = $pdo->prepare(
            'INSERT INTO inscripcion
            (fecha, matricula, id_cursos)
            VALUES (?, ?, ?)'
        );

        $stmt->execute([
            $fecha,
            $matricula,
            $idCurso
        ]);

        $idInscripcion = $pdo->lastInsertId();

        // Respuesta

        http_response_code(201);

        echo json_encode([
            'ok' => true,
            'mensaje' => 'Inscripción registrada correctamente.',
            'id_inscripcion' => (int)$idInscripcion,
            'fecha' => $fecha,
            'alumno' => [
                'matricula' => (int)$alumno['matricula'],
                'nombre' => $alumno['nombre'],
                'correo' => $alumno['correo']
            ],
            'curso' => [
                'id_cursos' => (int)$curso['id_cursos'],
                'nombre' => $curso['nombre']
            ]
        ], JSON_UNESCAPED_UNICODE);

        exit;
    }

    // Método no permitido

    http_response_code(405);

    echo json_encode([
        'ok' => false,
        'mensaje' => 'Método no permitido. Usa GET o POST.'
    ], JSON_UNESCAPED_UNICODE);


} catch (PDOException $e) {

    http_response_code(500);

    echo json_encode([
        'ok' => false,
        'mensaje' => 'Error al procesar la solicitud.'
    ], JSON_UNESCAPED_UNICODE);
}
?>