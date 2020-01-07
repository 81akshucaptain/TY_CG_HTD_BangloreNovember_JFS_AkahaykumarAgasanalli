import { Directive, ElementRef, Renderer2, HostListener, HostBinding } from '@angular/core';

// CUSTOME  DIRECTIVE

@Directive({
  selector: '[appColor]'
})
export class ColorDirective {

@HostBinding('style.background') backgroundColor: string;

  constructor(private el: ElementRef, private renderer: Renderer2) {
    // // this.el.nativeElement.style.background = 'red';
    // // this.el.nativeElement.style.fontsize = '30px';

    // CUSTOME HTML ELEMENTS

    // let h1 = this.renderer.createElement('h1');
    // let text = this.renderer.createText('hello jacky custome directive');
    // this.renderer.appendChild(h1, text);
    // this.renderer.appendChild(this.el.nativeElement, h1);
  }
  @HostListener('mouseenter')
  x() {
    // this.el.nativeElement.style.background = '#ccc';
    this.backgroundColor = 'green';
    this.el.nativeElement.style.color = 'blue';
    this.el.nativeElement.style.fontSize = '35px';
  }

  @HostListener('mouseleave')
  y() {
    this.el.nativeElement.style.background = 'lightblue';
    this.el.nativeElement.style.color = 'yellow';
    this.el.nativeElement.style.fontSize = '10px';
  }
}















