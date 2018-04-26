import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { PruebaEntidadSharedModule } from '../../shared';
import {
    ObservacionesService,
    ObservacionesPopupService,
    ObservacionesComponent,
    ObservacionesDetailComponent,
    ObservacionesDialogComponent,
    ObservacionesPopupComponent,
    ObservacionesDeletePopupComponent,
    ObservacionesDeleteDialogComponent,
    observacionesRoute,
    observacionesPopupRoute,
} from './';

const ENTITY_STATES = [
    ...observacionesRoute,
    ...observacionesPopupRoute,
];

@NgModule({
    imports: [
        PruebaEntidadSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        ObservacionesComponent,
        ObservacionesDetailComponent,
        ObservacionesDialogComponent,
        ObservacionesDeleteDialogComponent,
        ObservacionesPopupComponent,
        ObservacionesDeletePopupComponent,
    ],
    entryComponents: [
        ObservacionesComponent,
        ObservacionesDialogComponent,
        ObservacionesPopupComponent,
        ObservacionesDeleteDialogComponent,
        ObservacionesDeletePopupComponent,
    ],
    providers: [
        ObservacionesService,
        ObservacionesPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PruebaEntidadObservacionesModule {}
