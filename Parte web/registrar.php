<?php
include 'conexion.php';
//recibir datos y alamacenarlos en variables
$nombre = $_POST["nombre"];
$longlat = $_POST["longlat"];
$estado =$_POST["estado"];
$cantidad =$_POST["cantidad"];

//Consulta para insertar los datos
$insert = "INSERT INTO lugares(nombre,longlat,estado,cantidad) VALUES ('$nombre','$longlat','$estado','$cantidad')";


$resultado = mysqli_query($conexion,$insert);
if (!$resultado){
  echo '<script>
  alert("Error al registrar");
  </scrip>';
  echo "<script>window.location='index.php'</script>";
}else{
  echo '<script>
  alert("Registro exitoso");
  </scrip>';
    echo "<script>window.location='index.php'</script>";
}

mysqli_close($conexion);

header("location:index.php");
//echo 'Hola como estas';