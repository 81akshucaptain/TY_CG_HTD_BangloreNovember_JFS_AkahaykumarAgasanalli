import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterContracts'
})
export class FilterContractsPipe implements PipeTransform {

  transform(contracts: Contracts[], search: number): Contracts[] {
    if (search === undefined) {
      return contracts;
    } else {
      return contracts.filter((customer, index) => {
        return customer.contractId === search;
      });
    }
  }

}

