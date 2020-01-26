import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  selectedContractToUpdate: Contracts;
  cudtomerIdForValidation: number;

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  // FOR CUSTOMER
  searchCustomer(): Observable<any> {
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    return this.http.get<any>(`${this.url}/search-customer-by-email?email=${userDetails.user[0].userName}`);
  }
  addContract(contractBean): Observable<any> {
    return this.http.post<any>(`${this.url}/add-contract`, contractBean);
  }
  viewContract(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-allcontracts`);
  }
  viewContractById(): Observable<any> {
    let customerDetails = JSON.parse(localStorage.getItem('customerDetails'));
    return this.http.get<any>(`${this.url}//get-allcontracts-by-customer-id?cid=${customerDetails.customer[0].customerId}`);
  }
  deleteContract(contractBean: Contracts): Observable<any> {
    return this.http.delete<any>(`${this.url}/delete-contract/${contractBean.contractId}`);
  }
  updateContract(contractBeanToUpdate): Observable<any> {
    return this.http.put<any>(
      `${this.url}/update-contract`, contractBeanToUpdate);
  }
}