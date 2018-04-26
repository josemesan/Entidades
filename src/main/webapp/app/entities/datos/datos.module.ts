import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PruebaEntidadSharedModule } from '../../shared';
import {
    DatosService,
    DatosPopupService,
    DatosComponent,
    DatosDetailComponent,
    DatosDialogComponent,
    DatosPopupComponent,
    DatosDeletePopupComponent,
    DatosDeleteDialogComponent,
    datosRoute,
    datosPopupRoute,
} from './';

const ENTITY_STATES = [
    ...datosRoute,
    ...datosPopupRoute,
];

@NgModule({
    imports: [
        PruebaEntidadSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        DatosComponent,
        DatosDetailComponent,
        DatosDialogComponent,
        DatosDeleteDialogComponent,
        DatosPopupComponent,
        DatosDeletePopupComponent,
    ],
    entryComponents: [
        DatosComponent,
        DatosDialogComponent,
        DatosPopupComponent,
        DatosDeleteDialogComponent,
        DatosDeletePopupComponent,
    ],
    providers: [
        DatosService,
        DatosPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PruebaEntidadDatosModule {}
