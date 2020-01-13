import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ProveedorDTO } from '../../dto/proveedor.dto';
import { Router } from '@angular/router';

@Component({
    selector: 'gestionar-proveedor',
    templateUrl: './gestionar-proveedor.html',
    styleUrls: ['./gestionar-proveedor.css']
})
export class GestionarProveedorComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarProveedorForm: FormGroup;

    /**
     * Atributo que contendra la lista de proveedores creados
     */
    public listaProveedores: Array<ProveedorDTO>;

    /**
     * Atributo que contendra la informacion del proveeedor
     */
    public proveedor: ProveedorDTO;

    public idProveedor: number = 0;
    submitted: boolean;

    /**
     * Constructor
     * @param fb 
     * @param router 
     * @author Leo
     */
    constructor(private fb: FormBuilder,
        private router: Router) {
        this.gestionarProveedorForm = this.fb.group({
            id: [null],
            direccion: [null],
            estado: [null],
            fechaCreacion: [null],
            persona: [null],
            montoCredito: [null]
        });
    }

    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.proveedor = new ProveedorDTO();
        this.listaProveedores = new Array<ProveedorDTO>();
    }

    /**
     * Metodo encargado de crear o actualizar un Proveedor
     */
    public crearActualizarProveedor(): void {
        this.submitted = true;
        if (this.gestionarProveedorForm.invalid) {
            return;
        }
        this.idProveedor++;
        this.proveedor = new ProveedorDTO();
        this.proveedor.id = this.idProveedor;
        this.proveedor.estado = this.gestionarProveedorForm.controls.estado.value;

        this.listaProveedores.push(this.proveedor);
        this.limpiarFormulario();

    }

    /**
     * Metodo que permite consultar un proveedor de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del proveedor seleccionado
     */
    public consultarProveedor(posicion: number): void {
        let proveedor = this.listaProveedores[posicion];
        this.gestionarProveedorForm.controls.id.setValue(proveedor.id);
        this.gestionarProveedorForm.controls.id.disable();

    }


    limpiarFormulario() {
        throw new Error("Method not implemented.");
        this.submitted = false;
        this.gestionarProveedorForm.controls.id.setValue(null);
    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Leo
     */
    get f() { 
        return this.gestionarProveedorForm.controls;
    }

}