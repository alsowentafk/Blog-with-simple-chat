import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'roomFilter'
})
export class RoomFilterPipe implements PipeTransform {
  transform(roomList, searchString: string = '') {
    if (!searchString.trim()) {
      return roomList;
    }
    return roomList.filter(room => {
      return room.name.toLowerCase().indexOf(searchString.toLowerCase()) != -1;
    })
  }
}
