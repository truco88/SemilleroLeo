import { Component, OnInit } from '@angular/core';

/**
 * @description Componente bienvenida, el cual contiene la imagen de bienvenida al semillero
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
  selector: 'bienvenida',
  templateUrl: './bienvenida-component.html',
})
export class BienvenidaComponent implements OnInit{

  constructor(){
    console.log("entro en el conastructor del componente Bienvenida");
    
  }

  ngOnInit(): void {
    console.log("entro en el evento Oninit del componente Bienvenida");
  }

}