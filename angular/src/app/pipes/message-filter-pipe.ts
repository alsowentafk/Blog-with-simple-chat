import {Pipe, PipeTransform} from '@angular/core';
import {Message} from "../models/Message";

@Pipe({
  name: 'messageFilter'
})
export class MessageFilterPipe implements PipeTransform {
  transform(messagesList: Message[], userId: string = '') {
    if (!userId.trim()) {
      return messagesList;
    }
    return messagesList.filter(message => {
      return message.user_id.user_id.toString().toLowerCase().indexOf(userId.toLowerCase()) != -1;
    })
  }
}
