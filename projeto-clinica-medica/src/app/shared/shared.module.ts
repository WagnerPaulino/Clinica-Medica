import { DashboardComponent } from './../view/dashboard/dashboard.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatSnackBarModule,
  MatSelectModule,
  MatFormFieldModule,
  MatInputModule,
  MatIconModule,
  MatSidenavModule,
  MatListModule,
  MatButtonModule,
  MatToolbarModule,
  MatCheckboxModule,
  MatDialogModule} from '@angular/material';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

const ANGULAR_MATERIAL = [
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatListModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatSelectModule,
    MatSnackBarModule,
    MatCheckboxModule,
    MatDialogModule
];

const ANGULAR = [
  CommonModule,
  HttpClientModule,
  RouterModule,
  FormsModule
];

@NgModule({
  imports: [
    ANGULAR_MATERIAL,
    ANGULAR
  ],
  declarations: [
    DashboardComponent
  ],
  exports: [
    ANGULAR_MATERIAL,
    ANGULAR,
    DashboardComponent
  ],
  providers: []
})
export class SharedModule { }
