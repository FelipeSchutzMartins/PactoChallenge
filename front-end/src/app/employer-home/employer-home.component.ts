import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; 
import { EmployerService } from '../_services/employer.service';
import { StorageService } from '../_services/storage.service';
import { EventBusService } from '../_shared/event-bus.service';
import { EventData } from '../_shared/event.class';

@Component({
  selector: 'app-employer-home',
  templateUrl: './employer-home.component.html',
  styleUrl: './employer-home.component.css'
})

export class EmployerHomeComponent implements OnInit {
  positions: any;
  currentTutorial = null;
  currentIndex = -1;
  title = '';

  page = 1;
  count = 0;
  pageSize = 15;

  constructor(private employerService: EmployerService, private router: Router, private storageService: StorageService, private eventBusService : EventBusService) { }

  ngOnInit(): void {
    this.retrievePositions();
  }

  getRequestParams(page: any): any {
    let params = {
      'page': page - 1,
      'size': this.pageSize
    };
    return params;
  }

  retrievePositions(): void {
    const params = this.getRequestParams(this.page);

    this.employerService.listAll(params).subscribe({
      next: data => {
        const { content, totalElements } = data;
        this.positions = content;
        this.count = totalElements;
        console.log(data);
      },
      error: err => {
        if (err.status == 403) {
          this.eventBusService.emit(new EventData("logout", ""));
          this.storageService.clean()
          this.router.navigate(['/login'])
        }
      }
    });
  }

  handlePageChange(event: any): void {
    this.page = event;
    this.retrievePositions();
  }
}
