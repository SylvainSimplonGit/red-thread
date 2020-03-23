import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { MatTableDataSource } from '@angular/material/table';
// import { MatSort } from '@angular/material/sort';

@Component({
  selector: 'app-opinion-list',
  templateUrl: './opinion-list.component.html',
  styleUrls: ['./opinion-list.component.css']
})
export class OpinionListComponent implements OnInit {

  // form: FormGroup;
  title: string;
  opinionsList: [];
  displayedColumns: string[] = ['movieBuff', 'rating', 'comment'];
  dataSource = new MatTableDataSource(this.opinionsList);

  // @ViewChild(MatSort, {static: false}) sort: MatSort;

  constructor(
    private dialogRef: MatDialogRef<OpinionListComponent>,
    @Inject(MAT_DIALOG_DATA) private data: any
  ) {
    this.title = data.title;
    this.opinionsList = data.opinionList;
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
