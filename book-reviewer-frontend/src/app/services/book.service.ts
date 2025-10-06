import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Book } from '../models/book';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  private apiUrl = '/api/books';

  constructor(private http: HttpClient) { }

  getBooks(): Observable<any> {
    console.log('---BookService.getBooks() called');
    return this.http.get(this.apiUrl);
  }

  addBook(newBook: any): Observable<any>{
    console.log(`Sending POST request to ${this.apiUrl} with book:`, newBook);
    return this.http.post(this.apiUrl, newBook);
  }
}
