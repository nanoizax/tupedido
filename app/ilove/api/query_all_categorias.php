<?php
/**
 * Obtiene el detalle de un alumno especificado por
 * su identificador "idalumno"
 */

require 'query.php';

if ($_SERVER['REQUEST_METHOD'] == 'GET') {

   
        // Tratar retorno
        $retorno = Query::categorias_agro();


        if ($retorno) {

            $alumno["estado"] = 1;		// cambio "1" a 1 porque no coge bien la cadena.
            $alumno["oficinas"] = $retorno;
            // Enviar objeto json del alumno
            print json_encode($alumno);
        } else {
            // Enviar respuesta de error general
            print json_encode(
                array(
                    'estado' => '2',
                    'mensaje' => 'No se obtuvo el registro'
                )
            );
        }

    
}