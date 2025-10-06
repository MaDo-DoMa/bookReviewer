
export interface Book {
  id: number;
  title: string;
  author: string;
  publisher?: string;
  price?: number;
  publicationDate?: string;

  _links?: {
    self: {href: string};
    book: {href: string};
    reviews: {href: string};
  }

}
