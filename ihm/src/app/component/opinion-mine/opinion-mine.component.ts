import { Component, Inject, OnInit } from '@angular/core';
// import { MatTableDataSource } from '@angular/material/table';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

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

  constructor(
    private dialogRef: MatDialogRef<OpinionMineComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData
  ) {
    // this.title = data.title;
    // this.myOpinion = data.opinion;
    // this.opinionsMine = data.opinionMine;
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
