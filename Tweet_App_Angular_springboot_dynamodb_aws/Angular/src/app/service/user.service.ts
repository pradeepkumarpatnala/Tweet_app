import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  baseurl:String="http://18.116.87.13:8087/api/v1.0/userService/"
  userId:String;
  user:User;
  usernameGlobal:String;
  constructor( private httpClient: HttpClient) { }
  setuserIdGloabal(id:String){
    this.userId=id;
  }
  setusernameGloabal(username:String){
    this.usernameGlobal=username;
  }
  getuserIdGlobal(){
    return this.userId;
  }
  getusernameGlobal(){
    return this.usernameGlobal;
  }

  signupUser(user:User):Observable<void>{
   //  return this.httpClient.post<void>('http://localhost:3000/user',user);
   return this.httpClient.post<void>(this.baseurl+'register',user);
  }

  checkUserExists(Username:String):Observable<User[]>{
 
    return this.httpClient.get<User[]>(this.baseurl+'checkUserExists?username='+Username);
  }
  loginuser( username: string, password: string):Observable<User[]>{
     return this.httpClient.get<User[]>(this.baseurl+'login?username='+username+'&password='+password);
  
  }

  forgetPassword(user:User):Observable<void>{
    return this.httpClient.put<void>(this.baseurl+'forgotPassword',user);
  }
}
