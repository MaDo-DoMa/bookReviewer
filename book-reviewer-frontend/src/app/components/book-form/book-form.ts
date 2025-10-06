import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { BookService} from '../../services/book.service';

@Component({
  selector: 'app-book-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './book-form.html',
  styleUrl: './book-form.css'
})
export class BookFormComponent {
  book: any = {
    title: '',
    author: '',
    publisher: '',
    price: null,
    publicationDate: ''
  };

  successMessage: string = '';
  errorMessage: string = '';

  constructor(private bookService: BookService) { }

  saveBook(){
    this.successMessage = '';
    this.errorMessage = '';

    this.bookService.addBook(this.book).subscribe({
      next: (response) => {
        this.book = {title: '', author: '', publisher: '', price: null, publicationDate: ''};
      },
      error: (err) =>{
        this.errorMessage = 'Error adding book: ${err.status} - ${err.statusText}';
        console.error('Error on POST:',err);
      }
    });
  }

}
