<?php
include("Persona.php");
include("Notas.php");
class Alumno extends Persona
{
    
    private Notas $misnotas;
    
    public function __construct(string $nom, string $rut, int $cantidad)
    {
        $this->nombre = $nom;
        $this->asignaRut($rut);
        $this->validaRut();
        $this->misnotas = new Notas($cantidad);
    }
    
    public function libroclases(){
        return $this->obtieneDatos() . " " . $this->misnotas->diceNotas();
    }
    
    public function agregarnotas(int $i, float $nota){
        $this->misnotas->addNota($i, $nota);
    }
    
    public function promedio(){
        return $this->misnotas->promedio();
    }
}

