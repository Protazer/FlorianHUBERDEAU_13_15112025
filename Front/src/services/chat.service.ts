import {Observable, Subject} from 'rxjs';
import {Stomp} from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ChatService {

  private stompClient: any;
  private messageSubject = new Subject<any>();

  constructor(private http: HttpClient) {}

  getCurrentSession(): Observable<any> {
    return this.http.get('/api/session/current');
  }

  getMessagesHistory(sessionId: number): Observable<any[]> {
    return this.http.get<any[]>(`/api/messages/${sessionId}`);
  }
  closeSession(id: number): Observable<any> {
    return this.http.post(`/api/session/${id}/close`, {});
  }

  connect(sessionId: number) {
    const socket = new SockJS('/chat-websocket');
    this.stompClient = Stomp.over(socket);

    this.stompClient.connect({}, () => {

      // messages
      this.stompClient.subscribe(`/topic/messages/${sessionId}`, (msg: { body: string; }) => {
        this.messageSubject.next(JSON.parse(msg.body));
      });

      // status
      this.stompClient.subscribe(`/topic/session/${sessionId}/status`, (msg: { body: any; }) => {
        this.messageSubject.next({ type: 'STATUS', value: msg.body });
      });
    });
  }

  getMessages(): Observable<any> {
    return this.messageSubject.asObservable();
  }

  sendMessage(msg: any) {
    this.stompClient.send('/app/send', {}, JSON.stringify(msg));
  }
}
