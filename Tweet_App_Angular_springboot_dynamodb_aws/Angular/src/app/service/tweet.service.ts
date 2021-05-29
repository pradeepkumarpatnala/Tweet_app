import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tweet } from '../model/tweet';
import { UserService } from './user.service';

@Injectable({
  providedIn: 'root'
})

export class TweetService {
  baseurl:String="http://18.116.87.13:8087/api/v1.0/tweetService/"
 
  constructor( private httpClient: HttpClient,private userService:UserService) { }

  getAllTweets():Observable<Tweet[]>{
     return this.httpClient.get<Tweet[]>(this.baseurl+'getAllTweets');
  }

  likeTweet(id:String):Observable<void>{
    return this.httpClient.put<void>(this.baseurl+'like?id='+id,null);
  }

  getTweetsOfUser():Observable<Tweet[]>{
    return this.httpClient.get<Tweet[]>(this.baseurl+'getAllTweetsOfUser?userId='+this.userService.getuserIdGlobal());
  }

  deleteTweetById(id:String):Observable<void>{
    return this.httpClient.delete<void>(this.baseurl+'delete?id='+id);
  }

  addTweet(tweet:Tweet):Observable<void>{
    tweet.userid=this.userService.getuserIdGlobal();
    return this.httpClient.post<void>(this.baseurl+'/add',tweet);
  }

  getTweetById(id:String):Observable<Tweet>{
    return this.httpClient.get<Tweet>(this.baseurl+'getTweetById?id='+id);
  }

  updateTweet(tweet:Tweet):Observable<void>{
    tweet.userid=this.userService.getuserIdGlobal();
    return this.httpClient.put<void>(this.baseurl+'update',tweet);
  }

  replyTweet(id:String,reply:String):Observable<void>{
    return this.httpClient.put<void>(this.baseurl+'reply?id='+id+'&&reply='+reply,null);
  }
}
