import {Component, OnInit} from '@angular/core';
import {ChatService} from '../../services/chat.service';
import {FormsModule} from '@angular/forms';
import {NgClass, NgForOf, NgIf} from '@angular/common';


@Component({
  selector: 'app-chat',
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    NgClass,
  ],
  templateUrl: './chat.component.html',
  styleUrl: './chat.component.scss'
})
export class ChatComponent implements OnInit {

  messages: any[] = [];
  currentSessionId!: number;
  newMessage = '';
  sessionClosed = false;
  userName = 'User' + Math.floor(Math.random() * 1000);

  constructor(private chatService: ChatService) {}

  ngOnInit() {
    this.chatService.getCurrentSession().subscribe(session => {
      this.currentSessionId = session.id;

      this.chatService.getMessagesHistory(this.currentSessionId).subscribe(history => {
        this.messages = history;
      });

      this.chatService.connect(this.currentSessionId);

      this.chatService.getMessages().subscribe(msg => {
        console.log("messages :", msg);
        if (msg.type === 'STATUS' && msg.value === 'CLOSED') {
          this.sessionClosed = true;
          return;
        }
        this.messages.push(msg);
      });
    });
  }

  send() {
    if (!this.sessionClosed) {
      this.chatService.sendMessage({
        content: this.newMessage,
        sender: this.userName,
        sessionId: this.currentSessionId
      });
      this.newMessage = '';
    }
  }

  closeSession() {
    this.chatService.closeSession(this.currentSessionId).subscribe();
  }
}
