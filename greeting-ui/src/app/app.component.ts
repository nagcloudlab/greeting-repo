import {HttpClient} from '@angular/common/http';
import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'greeting-ui';

  message: string = ""

  constructor(private httpClient: HttpClient) {
  }

  handleGreeting(lang: string) {
    this.httpClient.get(`http://65.2.11.246:8181/api/greet/${lang}`,{responseType:'text'})
      .subscribe({
        next: (response: any) => {
          this.message = response
        }
      })
  }

}
