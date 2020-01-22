import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filteCustomer'
})
export class FilteCustomerPipe implements PipeTransform {


  transform(customers: Customers[], search: string): Customers[] {
    if (search === undefined) {
      return customers;
    } else {
      return customers.filter((customer, index) => {
        return customer.name.toLowerCase().includes(search.toLowerCase());
      });
    }
  }

}

