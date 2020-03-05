<?php

/**
 * Representa el la estructura de las Alumnoss
 * almacenadas en la base de datos
 */
require 'Database.php';

class Query
{
    function __construct()
    {
    }

    /**
     * Retorna en la fila especificada de la tabla 'Alumnos'
     *
     * @param $idAlumno Identificador del registro
     * @return array Datos del registro
     */
     
     //Tiendas JSON----------------------------------
     
     
    //SELECT ---------------------------------------
    
    public static function SliderPrincipal()
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT *
                             FROM ilove_pager_home ORDER BY id DESC";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    
    public static function getProductos()
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT *
                             FROM ilove_producto ORDER BY id DESC";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    public static function getOfertas()
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT *
                             FROM ilove_producto WHERE oferta = 1 ORDER BY id DESC";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    public static function getRecomendados()
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT *
                             FROM ilove_producto WHERE recomendados = 1 ORDER BY id DESC";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    public static function getAllProductos()
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT DISTINCT u.id as id_1, u.nombre as nombre_1, u.img as img_1, u.precio as precio_1, u.descripcion as descripcion_1, d.id as id_2, d.nombre as nombre_2, d.img as img_2, d.precio as precio_2, d.descripcion as descripcion_2 FROM productos u INNER JOIN productos d ORDER BY RAND() ";


        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute();
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    public static function getProyecto($texto)
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT * from urr_proyecto WHERE id_proyecto = ?";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($texto));
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    
    
    
    
    //SELECT WHERE -------------------------------------------------------------
    
    public static function getLogin($texto,$clave)
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT *
                             FROM clientes
                             WHERE email = ? AND pass = ? ";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($texto,$clave));
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
    public static function getBuscarProducto($texto)
    {
        // Consulta de la tabla usuarios

        $consulta = "SELECT * from ilove_producto WHERE nombre LIKE '%' ? '%' OR direccion LIKE '%' ? '%' ";

        try {
            // Preparar sentencia
            $comando = Database::getInstance()->getDb()->prepare($consulta);
            // Ejecutar sentencia preparada
            $comando->execute(array($texto,$texto));
            // Capturar primera fila del resultado
            $row = $comando->fetchAll(PDO::FETCH_ASSOC);
            return $row;

        } catch (PDOException $e) {
            // Aquí puedes clasificar el error dependiendo de la excepción
            // para presentarlo en la respuesta Json
            return -1;
        }
    }
    
   
    //INSERT --------------------------------------

    public static function insertUsuarios(
        $nombre,
        $email,
        $telefono,
        $password,
        $direccion
    )
    
    {
        // Sentencia INSERT
        $comando = "INSERT INTO clientes ( 
            nombres,
            email,
            telefono,
            pass,
            direccion)
            VALUES( ?,?,?,?,?)";

        // Preparar la sentencia
        $sentencia = Database::getInstance()->getDb()->prepare($comando);

        return $sentencia->execute(
            array(
                $nombre,
                $email,
                $telefono,
                $password,
                $direccion
                )
        );

    }
     
     
    
    
    //UPDATE---------------------------------------

    public static function UpdateUsuarios(
        $nombre,
        $dni,
        $telefono,
        $password,
        $id
    )
    {
        // Sentencia UPDATE
        $comando = "UPDATE usuarios SET nombre = ? , dni = ? , telefono = ?, password = ? WHERE id = ?";

        // Preparar la sentencia
        $sentencia = Database::getInstance()->getDb()->prepare($comando);

        return $sentencia->execute(
            array(
                $nombre,
                $dni,
                $telefono,
                $password,
                $id
                )
        );

    }
    
   
    
}

?>