import { Component, OnInit } from '@angular/core';
import { VideoDisplayService } from 'src/app/services/video-display.service';
import { VideoCallDetails } from 'src/app/models/video-call-details.model';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-video-display',
  templateUrl: './video-display.component.html',
  styleUrls: ['./video-display.component.css']
})
export class VideoDisplayComponent implements OnInit {
  approvalStatus: string = '';
  approvalSubstatus: string = '';
  remarks: string = '';

  constructor(private videoDisplayService: VideoDisplayService, private logger: NGXLogger) { }

  ngOnInit(): void {
    this.videoDisplayService.getVideoCallDetails().subscribe(
      (data: VideoCallDetails) => {
        this.approvalStatus = data.approvalStatus.toUpperCase();
        this.approvalSubstatus = data.approvalSubstatus.toUpperCase();
        this.remarks = data.remarks;
      },
      (error) => {
        this.logger.error('Error fetching video call details', error);
      }
    );
  }
}
