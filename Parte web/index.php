

<!DOCTYPE html>
<html>
<head>
	<title>Introducción formularios web</title>
	<meta charset="utf-8"/>
	<meta name="description" content="Un formulario sirve para enviar datos a otra página que los recoge para usarlos o almacenarlos."/>

	<style>
     @import '/estilo.css';
     table, th, td{
       border: 1px  solid black;
       border-collapse: collapse;
     }
     
    th, td {
      padding 10px;
    }
    th{
      text-align : left;
    }
    
	</style>

</head>
<body background = "imagenes/googl.jpg">

<form action="registrar.php" target="" method="post" name="nuevoubicacion" >

	<label for="nombre">Nombre del lugar</label>
	<input type="text" name="nombre" id="nombre" placeholder="Nombre del lugar"/>

	<label for="longlat">Longitud y latitud</label>
	<input type="text" name="longlat" id="longlat" placeholder="longitud y latitud"/>

  <label for="estado">Status</label>
	<input type="text" name="estado" id="estado" placeholder="Status"/>
	
	<label for="estado">Cantidad de Población</label>
	<input type="text" name="cantidad" id="cantidad" placeholder="# Personas"/>
	
	
	<input type="submit" name="guardar" value="Guardar nuevo lugar"/>
</form>
<center>
  
    
<table>
  <tr>
		<th>Id</th>
    <th>Nombre</th>
    <th>Longitud Y Latitud</th>
    <th>Estado</th>
  </tr>

	<?php 
		include 'conexion.php';
		$sql="SELECT * from lugares";
		$result=mysqli_query($conexion,$sql);

		while($mostrar=mysqli_fetch_array($result)){
		 ?>
	<tr>
			<td><?php echo $mostrar['id'] ?></td>
			<td><?php echo $mostrar['nombre'] ?></td>
			<td><?php echo $mostrar['longlat'] ?></td>
			<td><?php echo $mostrar['estado'] ?></td>
			<td><button>Editar</button></td>
			<td><button>Borrar</button></td>
		</tr>
	<?php 
	}
	 ?>
</table>
  </center>

</body>
</html>




