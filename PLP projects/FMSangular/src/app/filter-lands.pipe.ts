import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterLands'
})
export class FilterLandsPipe implements PipeTransform {

  transform(lands: Lands[], search: string): Lands[] {
    if (search === undefined) {
      return lands;
    } else {
      return lands.filter((land, index) => {
        return land.landLocation.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}

