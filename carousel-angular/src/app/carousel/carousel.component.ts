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
  slides: string [] = ['./assets/slides/slide1.png', './assets/slides/slide2.png', './assets/slides/slide3.png', './assets/slides/slide4.png', './assets/slides/slide5.png', './assets/slides/slide6.png', './assets/slides/slide7.png', './assets/slides/slide8.png', './assets/slides/slide9.png', './assets/slides/slide10.png', './assets/slides/slide11.png', './assets/slides/slide12.png', './assets/slides/slide13.png', './assets/slides/slide14.png', './assets/slides/slide15.png', './assets/slides/slide16.png', './assets/slides/slide17.png', './assets/slides/slide18.png', './assets/slides/slide19.png', './assets/slides/slide20.png', './assets/slides/slide21.png', './assets/slides/slide22.png', './assets/slides/slide23.png' ]
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
