import { Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { DatosComponent } from './datos.component';
import { DatosDetailComponent } from './datos-detail.component';
import { DatosPopupComponent } from './datos-dialog.component';
import { DatosDeletePopupComponent } from './datos-delete-dialog.component';

export const datosRoute: Routes = [
    {
        path: 'datos',
        component: DatosComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'pruebaEntidadApp.datos.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'datos/:id',
        component: DatosDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'pruebaEntidadApp.datos.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const datosPopupRoute: Routes = [
    {
        path: 'datos-new',
        component: DatosPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'pruebaEntidadApp.datos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'datos/:id/edit',
        component: DatosPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'pruebaEntidadApp.datos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'datos/:id/delete',
        component: DatosDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'pruebaEntidadApp.datos.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
