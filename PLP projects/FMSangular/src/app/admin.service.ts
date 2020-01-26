import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { from, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  selectedCustomerToUpdate: Customers;
  selectedProductToUpdate: Products;
  selectedLandToUpdate: Lands;
  canScheduleTheContract1: boolean;
  canScheduleTheContract2: boolean;

  url = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  // LOGIN FRO USER
  loginUser(userCredentials): Observable<any> {
    return this.http.post<any>(`${this.url}/login`, userCredentials);
  }

  // CUSTOMER RELATED FUNCTIONS

  addCustomer(customerBean): Observable<any> {
    return this.http.post<any>(`${this.url}/add-customer`, customerBean);
  }
  viewCustomer(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-allcustomer`);
  }
  deleteCustomer(customerBean: Customers): Observable<any> {
    return this.http.delete<any>(`${this.url}/delete-customer/${customerBean.customerId}`);
  }
  updateCustomer(customerBeanToUpdate): Observable<any> {
    return this.http.put<any>(
      `${this.url}/update-customer/`, customerBeanToUpdate);
  }

  // PRODUCT RELATED FUNCTIONS

  addProduct(productBean): Observable<any> {
    return this.http.post<any>(`${this.url}/add-product`, productBean);
  }
  viewProduct(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-allproducts`);
  }
  deleteProduct(productBean: Products): Observable<any> {
    return this.http.delete<any>(`${this.url}/delete-product/${productBean.productId}`);
  }
  searchProduct(contract): Observable<any> {
    return this.http.get<any>(`${this.url}/search-product?productId=${contract.productId}`);
  }
  updateProduct(productBeanToUpdate): Observable<any> {
    return this.http.put<any>(
      `${this.url}/update-product`, productBeanToUpdate);
  }

  // LAND RELATED FUNCTIONS

  addLand(landBean): Observable<any> {
    return this.http.post<any>(`${this.url}/add-land`, landBean);
  }
  viewLand(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-alllands`);
  }
  deleteLand(landBean: Lands): Observable<any> {
    return this.http.delete<any>(`${this.url}/delete-land/${landBean.landId}`);
  }
  updateLand(landBeanToUpdate): Observable<any> {
    return this.http.put<any>(
      `${this.url}/update-land`, landBeanToUpdate);
  }
  // CONTRACTS RELATED FUNCTIONS
  viewContracts(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-allcontracts`);
  }
  updateContractStatus(contract): Observable<any> {
    return this.http.put<any>(`${this.url}/update-contract-status`, contract);
  }

}
