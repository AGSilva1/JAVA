<?php

class Notas
{
    
    private  $nota;
    private int $cantidad;

    public function __construct(int $cant)
    {
        $this->cantidad = $cant;
        $this->nota= array();
    }
    
    public function addNota(int $i, float $nota){
        
        if ($i< $this->cantidad && $i >=0) {
            $this->nota[$i] = $nota;
        }
        
    }
    
    public function promedio(){
        $suma = 0;
        
        for ($i = 0; $i < $this->cantidad; $i++) {
            $suma += $this->nota[$i];
        }
        return number_format($suma/$this->cantidad,1);
    }
    
    public function diceNotas(){
        $s = "Notas: ";
        for($i=0;$i<$this->cantidad;$i++){
            $s .= " " . $this->nota[$i];
        }
        $s .= ". Prom. " . number_format(floatval($this->promedio()),1);
        return $s;
    }
}

