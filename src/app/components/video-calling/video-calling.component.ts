import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VideoCallingService } from '../../services/video-calling.service';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-video-calling',
  templateUrl: './video-calling.component.html',
  styleUrls: ['./video-calling.component.css']
})
export class VideoCallingComponent implements OnInit {

  constructor(
    private router: Router,
    private videoCallingService: VideoCallingService,
    private logger: NGXLogger
  ) { }

  ngOnInit(): void {
    this.initiateVideoCall();
  }

  private initiateVideoCall(): void {
    this.logger.debug('Initiating video call...');
    this.videoCallingService.startCall().subscribe(
      response => {
        this.logger.debug('Video call started successfully', response);
      },
      error => {
        this.logger.error('Error starting video call', error);
      }
    );
  }
}
