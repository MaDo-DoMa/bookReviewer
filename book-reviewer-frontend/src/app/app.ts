// src/app/app.ts (Zamiast app.component.ts)

import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { BookService } from './services/book.service';
import { BookListComponent } from './components/book-list/book-list';
import { BookFormComponent } from './components/book-form/book-form';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule, BookListComponent, BookFormComponent],
  // set templateUrl or template (templateUrl need file app.html)

  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent implements OnInit { // we still name class AppComponent
  connectionStatus: string = 'a connection attempt is in progress with http://localhost/api/books...';
  books: any;
  error: any;

  // service injection
  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    // key call
    this.bookService.getBooks().subscribe({
      next: (data) => {
        this.books = data;
        this.connectionStatus = 'Call dane!. We get data.';
      },
      error: (err) => {
        this.error = err;
        this.connectionStatus = 'Error: there was an error while getting backend.!';
        console.error('HTTP error', err);
      }
    });
  }
}
