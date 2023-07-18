<?php

class Persona
{
    protected string $nombre;
    private int $numero;
    private string $digitoVerificador;
    private int $validado;
    public function __construct(string $nombre)
    {
        $this->nombre = $nombre;
        $this->numero = 0;
        $this->validado = 0;
        $this->digitoVerificador = '?';
    }
    
    public function ObtieneNumero(){
        $mirut = "";
        $mirut = $this->numero ."-". $this->digitoVerificador;
        return $mirut;
    }
    
    public function asignaRut(string $rut){
        $rut = strtoupper($rut);
        $rut = str_replace(".","",$rut);
        $rut = str_replace("-","",$rut);
        $this->numero = intval(substr($rut,0,strlen($rut)-1));
        $this->digitoVerificador = substr($rut, -1);
        $this->validado = 0;
    }
    
    public function validaRut(){
        $M=0;
        $S=1;
        $T=$this->numero;
        for (;$T!=0;$T/=10) $S=($S+$T%10*(9-$M++%6))%11;
        $this->validado = chr($S!=0?$S+47:75) == $this->digitoVerificador?1:2;
        
    }
    
    public function obtieneDatos(){
        $datos = "";
        $datos .= $this->nombre . " " . $this->ObtieneNumero();
        if($this->validado > 0){
            $datos .= "(".($this->validado==2?"no ":" ")."Valido)";
        }
        return $datos;
    }
}

