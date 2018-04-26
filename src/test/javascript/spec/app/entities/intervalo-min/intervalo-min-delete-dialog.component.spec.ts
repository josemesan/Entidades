/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { PruebaEntidadTestModule } from '../../../test.module';
import { IntervaloMinDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/intervalo-min/intervalo-min-delete-dialog.component';
import { IntervaloMinService } from '../../../../../../main/webapp/app/entities/intervalo-min/intervalo-min.service';

describe('Component Tests', () => {

    describe('IntervaloMin Management Delete Component', () => {
        let comp: IntervaloMinDeleteDialogComponent;
        let fixture: ComponentFixture<IntervaloMinDeleteDialogComponent>;
        let service: IntervaloMinService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [PruebaEntidadTestModule],
                declarations: [IntervaloMinDeleteDialogComponent],
                providers: [
                    IntervaloMinService
                ]
            })
            .overrideTemplate(IntervaloMinDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(IntervaloMinDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(IntervaloMinService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
