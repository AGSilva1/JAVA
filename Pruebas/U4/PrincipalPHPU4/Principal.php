<?php
include("Alumno.php");
//print("Hola");

$curso = [];
$sumageneral = 0;

$clase = new Alumno("Agustin","1-9",3);
$curso[0] = $clase;

$clase = new Alumno("Damaris","1-8",3);
$curso[1] = $clase;

$clase = new Alumno("Erika","1-7",3);
$curso[2] = $clase;

$clase = new Alumno("Jesus","1-6",3);
$curso[3] = $clase;

$clase = new Alumno("Qarla","1-5",3);
$curso[4] = $clase;

$clase = new Alumno("Nahuel","1-4",3);
$curso[5] = $clase;

for($i=0;$i<count($curso);$i++){
    for($j=0;$j<3;$j++){
    $curso[$i]->agregarnotas($j, rand(1,60)/10+1);   
    }
    $sumageneral += $curso[$i]->promedio();
    print($curso[$i]->libroclases()."<br/>");
}

print("Promedio Curso: " . number_format(($sumageneral/5),1));




