import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'categoryFilter'
})
export class CategorySearchFilterPipe implements PipeTransform {
  transform(categoryList, searchString: string = '') {
    if (!searchString.trim()) {
      return categoryList;
    }
    return categoryList.filter(genre => {
      return genre.toLowerCase().indexOf(searchString.toLowerCase()) != -1;
    })
  }
}
