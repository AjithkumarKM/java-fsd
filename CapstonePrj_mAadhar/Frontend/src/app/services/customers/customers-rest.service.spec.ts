import { TestBed } from '@angular/core/testing';

import { CustomersRestService } from './customers-rest.service';

describe('CustomersRestService', () => {
  let service: CustomersRestService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomersRestService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
