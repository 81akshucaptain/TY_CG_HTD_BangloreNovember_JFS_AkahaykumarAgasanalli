import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InvesterServicesService {
  url = 'http://localhost:8080';
  investerEmailDefualt;
  constructor(
    private http: HttpClient
  ) { }
  searchInvester(investerEmail): Observable<any> {
    return this.http.get<any>(`${this.url}/search-invester-by-email?investerEmail=${investerEmail}`);
  }
  updateInvesterDetails(investerToUpdate): Observable<any> {
    return this.http.put<any>(`${this.url}/update-invester`, investerToUpdate);
  }
  loginUser(InvesterCredentials): Observable<any> {
    return this.http.post<any>(`${this.url}/login`, InvesterCredentials);
  }
  registerInvester(investerBean): Observable<any> {
    return this.http.post<any>(`${this.url}/add-invester`, investerBean);
  }
  viewMyStockInfo(investerID): Observable<any> {
    console.log('HELLOOO IM IN INVESTER SERVICES......::::', investerID);
    return this.http.get<any>(`${this.url}/search-stock-Info-by-ivesterid?investerID=${investerID}`);
  }
  viewStocks(): Observable<any> {
    return this.http.get<any>(`${this.url}/get-allstocks`);
  }
  addInvesterStockPurchases(investerStockInfoBean): Observable<any> {
    return this.http.post<any>(`${this.url}/add-stock-info`, investerStockInfoBean);
  }
  updateStocksBackToStockTable(updateStockBySelling): Observable<any> {
    console.log('JACKYY IM THE VALUE: ', updateStockBySelling);

    return this.http.post<any>(`${this.url}/delete-InvesterStockInfo`, updateStockBySelling);
  }

}
