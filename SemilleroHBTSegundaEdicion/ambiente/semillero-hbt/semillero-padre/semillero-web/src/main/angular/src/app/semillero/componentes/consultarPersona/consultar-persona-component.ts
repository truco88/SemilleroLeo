import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';


/**
 * Componente Consultar Persona
 */
@Component({
    selector: 'consultar-persona',
    templateUrl: './consultar-persona-component.html'
})

export class ConsultarPersonaComponent implements OnInit{

    ngOnInit(): void {
        throw new Error("Method not implemented.");
    }

    public consultarPersonaForm: FormGroup;

    /**
     * constructor del componente
     * @param fb 
     * @param router 
     */
    constructor(private fb: FormBuilder, private router: Router, private activateRoute: ActivatedRoute) {
        this.consultarPersonaForm = this.fb.group({
            id: [null, Validators.required],
            nombre: [null],
            numeroIdentificacion: [null]
        });

    }
}
