<?php
/**
 * Actualiza un alumno especificado por su identificador
 */
require 'query.php';
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    // Decodificando formato Json
    $body = json_decode(file_get_contents("php://input"), true);
    // Actualizar alumno
    $retorno = Query::UpdateUsuarios(
        $body['nombre'],
        $body['dni'],
        $body['telefono'],
        $body['password'],
        $body['id']

    );
    if ($retorno) {
        $json_string = json_encode(array("estado" => 1,"mensaje" => "Datos guardados correcta"));
        echo $json_string;
    } else {
        $json_string = json_encode(array("estado" => 2,"mensaje" => "No se actualizo el registro"));
        echo $json_string;
    }
}
?>