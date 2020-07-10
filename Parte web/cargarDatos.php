<?php
include 'conexion.php';

$consulta = "select * from lugares";
$resultado = $conexion -> query($consulta)

while($fila = $resultado->fetch_array()){
  $producto[] = array_map('utf8_encode',$fila);
}

echo json_encode($producto);
$resultado-> close();

