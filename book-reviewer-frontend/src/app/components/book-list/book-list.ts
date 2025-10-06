import {Component, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BookService} from '../../services/book.service';
import {Book} from '../../models/book';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './book-list.html',
  styleUrl: './book-list.css'
})

export class BookListComponent implements OnInit {
  //book list <in structure HATEOAS>
  books: Book[] = [];
  loading: boolean = true;
  error: any;

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.bookService.getBooks().subscribe({
      next: (response) => {
        //spring data rest resend inside data of object _embedded
        this.books = response._embedded.books;
        this.loading = false;
      },
      error: (err) => {
        this.error = err;
        this.loading = false;
        console.error('Error fetching books', err);
      }
    });
  }
}
