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

  myOpinionForm: FormGroup;

  constructor(
    private dialogRef: MatDialogRef<OpinionMineComponent>,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {
    this.myOpinionForm = this.formBuilder.group({
      opinion: data.opinion
    });

  }

  ngOnInit(): void {
  }

  close() {
    this.dialogRef.close();
  }
}

export interface DialogData {
  title: string;
  opinion: string;
}
