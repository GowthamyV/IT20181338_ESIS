import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { RegisterService } from 'src/app/_services/register.service';
import { NzModalService } from 'ng-zorro-antd/modal';
import { SuccessModalComponent } from '../success-modal/success-modal.component';
import { NzMessageService } from 'ng-zorro-antd/message';
const myModal = document.getElementById('myModal');
const myInput = document.getElementById('myInput');

myModal?.addEventListener('shown.bs.modal', () => {
  myInput?.focus();
});
@Component({
  selector: 'app-resgister',
  templateUrl: './resgister.component.html',
  styleUrls: ['./resgister.component.scss'],
})
export class ResgisterComponent implements OnInit {
  submitForm!: FormGroup;
  isSuccess = false;
  constructor(
    private fb: FormBuilder,
    private registerService: RegisterService,
    private nzModalService: NzModalService,
    private message: NzMessageService
  ) {}
  ngOnInit(): void {
    this.submitForm = this.fb.group({
      firstName: [''],
      lastName: [''],
      userName: [null, Validators.required],
      password: [''],
      email: [''],
      mobileNumber: [null, Validators.required],
      address: [null, Validators.required],
    });
  }

  openSuccess() {
    const modal = this.nzModalService.create({
      nzContent: SuccessModalComponent,
      nzFooter: null,
      nzKeyboard: false,
      nzClosable: true,
      nzMaskClosable: false,
      nzCentered: true,
    });
    setTimeout(() => modal.close(), 2000);
  }
  createMessage(type: string, value: any): void {
    this.message.create(type, `Required `);
  }
  validate() {
    Object.values(this.submitForm.controls).forEach((control) => {
      if (control.invalid) {
        control.markAsDirty();
        control.updateValueAndValidity({ onlySelf: true });
        console.log('cont', control);

        // this.createMessage('error', control);
      }
    });
  }
  register() {
    if (!this.submitForm.valid) {
      this.validate();
      return;
    }
    this.registerService.register(this.submitForm.value).subscribe({
      next: (value) => {
        this.openSuccess();

        this.submitForm.reset();
      },
    });
  }
}
