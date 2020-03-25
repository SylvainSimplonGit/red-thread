import { Component, Inject, OnInit } from '@angular/core';
// import { MatTableDataSource } from '@angular/material/table';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-opinion-mine',
  templateUrl: './opinion-mine.component.html',
  styleUrls: ['./opinion-mine.component.css']
})
export class OpinionMineComponent implements OnInit {

  // form: FormGroup;
  // title: string;
  // myOpinion: string;
  // opinionsList: [];
  // displayedColumns: string[] = ['movieBuff', 'rating', 'comment'];
  // dataSource = new MatTableDataSource(this.opinionsMine);

  // @ViewChild(MatSort, {static: false}) sort: MatSort;

  myOpinionForm: FormGroup;
  //   opinion: data.opinion
  // });

  constructor(
    private dialogRef: MatDialogRef<OpinionMineComponent>,
    private formBuilder: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {
    // this.title = data.title;
    // this.myOpinion = data.opinion;
    // this.opinionsMine = data.opinionMine;

    this.myOpinionForm = this.formBuilder.group({
      opinion: data.opinion
    });

  }

  ngOnInit(): void {
    // this.dataSource.sort = this.sort;
  }

  // save() {
  //   this.dialogRef.close();
  // }

  close() {
    this.dialogRef.close();
  }
}

export interface DialogData {
  title: string;
  opinion: string;
}
