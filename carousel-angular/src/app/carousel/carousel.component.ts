import { Component, HostListener } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-carousel',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './carousel.component.html',
  styleUrl: './carousel.component.css'
})
export class CarouselComponent{
  slides: string [] = ['./assets/slides/slide1.svg', './assets/slides/slide2.svg', './assets/slides/slide3.svg', './assets/slides/slide4.svg', './assets/slides/slide5.svg', './assets/slides/slide6.svg', './assets/slides/slide7.svg', './assets/slides/slide8.svg', './assets/slides/slide9.svg', './assets/slides/slide10.svg', './assets/slides/slide11.svg', './assets/slides/slide12.svg', './assets/slides/slide13.svg', './assets/slides/slide16.svg', './assets/slides/slide14.svg', './assets/slides/slide15.svg', './assets/slides/slide18.svg', './assets/slides/slide17.svg', './assets/slides/slide19.svg', './assets/slides/slide20.svg', './assets/slides/slide21.svg', './assets/slides/slide22.svg', './assets/slides/slide23.svg' ]
  i=0;

  getSlide() {
      return this.slides[this.i];
  }

  getPrev() {
      this.i = this.i===0 ? 0 : this.i - 1;
  }
 
  getNext() {
      this.i = this.i===this.slides.length - 1 ? this.i : this.i + 1;
  }

  @HostListener('document:keydown', ['$event'])
  keyEvent(event: KeyboardEvent): void {
    if (event.code === 'ArrowRight') {
      this.getNext();
    }
    if (event.code === "ArrowLeft") {
      this.getPrev();
    }
  }

}
