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
  slides: string [] = ['./assets/slides/slide1.png', './assets/slides/slide2.png', './assets/slides/slide3.png' ]
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
