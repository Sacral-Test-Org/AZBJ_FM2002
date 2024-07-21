import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NGXLogger } from 'ngx-logger';

@Component({
  selector: 'app-video-display',
  templateUrl: './video-display.component.html',
  styleUrls: ['./video-display.component.css']
})
export class VideoDisplayComponent implements OnInit {
  videoURL: string;
  baseVideoLink: string = 'https://example.com/videos/';

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private logger: NGXLogger
  ) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const applicationNumber = params['applicationNumber'];
      const productId = params['productId'];
      const pbExistCount = params['pbExistCount'];
      const agentCode = params['agentCode'];

      if (applicationNumber) {
        if (productId === '321' && pbExistCount === '0' && !this.isAxisBankAgent(agentCode)) {
          this.constructVideoURL(applicationNumber);
        } else {
          this.logger.error('Eligibility criteria not met.');
        }
      } else {
        this.logger.error('Application number is null.');
      }
    });
  }

  isAxisBankAgent(agentCode: string): boolean {
    return agentCode === 'AXIS_BANK_AGENT';
  }

  constructVideoURL(applicationNumber: string): void {
    try {
      this.videoURL = `${this.baseVideoLink}${applicationNumber}_VIDEOPIVC_JL`;
      this.displayVideo(this.videoURL);
    } catch (error) {
      this.logger.error('Error constructing video URL:', error);
    }
  }

  displayVideo(videoURL: string): void {
    // Logic to display the video using the constructed URL
    this.videoURL = videoURL;
  }
}
