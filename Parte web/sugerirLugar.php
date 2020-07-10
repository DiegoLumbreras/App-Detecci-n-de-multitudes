<?php
include 'conexion.php';
//recibir datos y alamacenarlos en variables
$nombre = $_POST["nombre"];
$longlat = $_POST["localizacion"]


$insert = "INSERT INTO lugaresSujeridos(nombre,longlat) VALUES ('$nombre','$longlat')";
$resultado = mysqli_query($conexion,$insert);
