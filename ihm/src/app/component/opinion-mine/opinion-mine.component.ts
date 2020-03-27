import {Component, Inject, OnInit, Output} from '@angular/core';
// import { MatTableDataSource } from '@angular/material/table';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-opinion-mine',
  templateUrl: './opinion-mine.component.html',
  styleUrls: ['./opinion-mine.component.css']
})
export class OpinionMineComponent implements OnInit {

  // myOpinionForm: FormGroup;
  form: FormGroup;

  formRate = 3;
  formOpinion = '';
  formTitle = '';

  // rate;
  // opinion;
  // title;

  constructor(
    private dialogRef: MatDialogRef<OpinionMineComponent>,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
    // @Inject(MAT_DIALOG_DATA) data
  ) {
    // this.myOpinionForm = this.formBuilder.group({
    //   opinion: data.opinion,
    //   rating: data.rating
    // });
    console.log('opinion-mine');
    console.log(data);
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
    console.log('Mon nouveau vote : ' + rating);
    this.formRate = rating;
  }

  save(saveOpinion: string, saveRating: number) {
    // this.dialogRef.close(this.form.value);
    this.dialogRef.close({
      newOpinion: saveOpinion,
      newRate: saveRating
    });
    console.log('save');
    // console.log(this.form.value);
    console.log('opinion : ' + saveOpinion);
    console.log('rating : ' + saveRating);
    // this.opinion = opinion;
    // this.rate = rating;
  }

  close() {
    this.dialogRef.close();
  }
}

export interface DialogData {
  title: string;
  opinion: string;
  rate: number;
}
