import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { PruebaEntidadObservacionesModule } from './observaciones/observaciones.module';
import { PruebaEntidadEstacionModule } from './estacion/estacion.module';
import { PruebaEntidadLineaModule } from './linea/linea.module';
import { PruebaEntidadIntervaloOfertadoModule } from './intervalo-ofertado/intervalo-ofertado.module';
import { PruebaEntidadRelacionFechaTipodiaModule } from './relacion-fecha-tipodia/relacion-fecha-tipodia.module';
import { PruebaEntidadTablaTrenesModule } from './tabla-trenes/tabla-trenes.module';
import { PruebaEntidadIntervaloMinModule } from './intervalo-min/intervalo-min.module';
import { PruebaEntidadIntervaloMaxModule } from './intervalo-max/intervalo-max.module';
import { PruebaEntidadDatosModule } from './datos/datos.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        PruebaEntidadObservacionesModule,
        PruebaEntidadEstacionModule,
        PruebaEntidadLineaModule,
        PruebaEntidadIntervaloOfertadoModule,
        PruebaEntidadRelacionFechaTipodiaModule,
        PruebaEntidadTablaTrenesModule,
        PruebaEntidadIntervaloMinModule,
        PruebaEntidadIntervaloMaxModule,
        PruebaEntidadDatosModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class PruebaEntidadEntityModule {}
