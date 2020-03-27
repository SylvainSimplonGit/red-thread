import { Component, OnInit, Input, Output, EventEmitter, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class StarRatingComponent implements OnInit {

  @Input('rating') private rating: number;
  @Input('starCount') private starCount: number;
  @Input('readOnly') private readOnly: boolean;
  @Output() private ratingUpdated = new EventEmitter();

  public ratingArr = [];
  public readonly = true;

  constructor(
  ) { }

  ngOnInit(): void {
    for (let index = 0; index < this.starCount; index++) {
      this.ratingArr.push(index);
    }
    this.readonly = this.readOnly;
  }

  showIcon(index: number) {
    if (this.rating >= index + 1) {
      return 'star';
    } else if (this.rating >= index + 0.5) {
      return 'star_half';
    } else {
      return 'star_border';
    }
  }

  onClick(rating: number) {
    this.ratingUpdated.emit(rating);
    return false;
  }
}
