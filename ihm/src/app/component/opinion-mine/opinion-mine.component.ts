import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-opinion-mine',
  templateUrl: './opinion-mine.component.html',
  styleUrls: ['./opinion-mine.component.css']
})
export class OpinionMineComponent implements OnInit {

  form: FormGroup;

  formRate = 0;
  formOpinion = '';
  formTitle = '';

  constructor(
    private dialogRef: MatDialogRef<OpinionMineComponent>,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {
    this.formTitle = data.title;
    this.formOpinion = data.opinion;
    this.formRate = data.rate;
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      title: this.formTitle,
      opinion: this.formOpinion,
      rate: this.formRate,
    });
  }

  onRatingChanged(rating) {
    this.formRate = rating;
  }

  save(saveOpinion: string, saveRating: number) {
    this.dialogRef.close({
      newOpinion: saveOpinion,
      newRate: saveRating
    });
  }

  close() {
    this.dialogRef.close({
      newOpinion: this.data.opinion,
      newRate: this.data.rate
    });
  }
}

export interface DialogData {
  title: string;
  opinion: string;
  rate: number;
}
