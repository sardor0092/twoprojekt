import { Injectable } from "@angular/core";

@Injectable({ providedIn: 'root' })
export class MessageTexts{
    static errorMessage = "Xatolik ro'y berdi tarmoq bilan uzilish mavjud qayta urinib ko'ring";
    static successMessage = "Muvvaqiyatli qo'shildi";
    static loginError   = "Login yoki parol oldindan mavjud";
}