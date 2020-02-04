import { TestBed } from '@angular/core/testing';

import { InvesterServicesService } from './invester-services.service';

describe('InvesterServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: InvesterServicesService = TestBed.get(InvesterServicesService);
    expect(service).toBeTruthy();
  });
});
