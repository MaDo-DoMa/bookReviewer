// src/app/services/book.service.spec.ts
import { TestBed } from '@angular/core/testing';
import { BookService } from './book.service';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

describe('BookService', () => {
  let service: BookService;
  let httpMock: HttpTestingController; // Mock for HttpClient

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [BookService]
    });

    // we push service and mock
    service = TestBed.inject(BookService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  // check if there are no past demands
  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    // check if service is make correctly
    expect(service).toBeTruthy();
  });

  it('should send a GET request to /api/books when getBooks is called', () => {
    // 1. make test method
    const dummyResponse = {
      _embedded: { books: [{ id: 1, title: 'Test Book', author: 'Test Author' }] }
    };

    // subscribe method to create http challenge
    service.getBooks().subscribe(response => {
      // verify if answear is correct
      expect(response).toEqual(dummyResponse);
    });

    // verify challenge <Mock>
    // HttpTestingController checks if challenge get was made to this addres
    const req = httpMock.expectOne('/api/books');

    // verify if challenge was get method
    expect(req.request.method).toBe('GET');

    // 3. response to this
    // we answear for this challenge to subscriber can get information
    req.flush(dummyResponse);
  });
});
