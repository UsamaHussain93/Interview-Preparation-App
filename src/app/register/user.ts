import { AccountType } from "./AccountType";

export class User {
    
    username?: string;
    password?: string;
    accountType?:AccountType;
    email?:string;

    constructor(username?:string, password?:string, accountType?:AccountType,email?:string) {
    this.username=username;
    this.password=password;
    this.accountType=accountType;
    }
    getaccountType(){
        return this.accountType;
    }
    getUsername() {
        return this.username;
    }

    getPassword() {
        return this.password;
    }
    getEmail(){
        return this.email;
    }

   
}