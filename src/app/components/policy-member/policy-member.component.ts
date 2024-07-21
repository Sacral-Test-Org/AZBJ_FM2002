import { Component, OnInit } from '@angular/core';
import { PolicyMemberService } from 'src/app/services/policy-member.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-policy-member',
  templateUrl: './policy-member.component.html',
  styleUrls: ['./policy-member.component.css']
})
export class PolicyMemberComponent implements OnInit {
  constructor(private policyMemberService: PolicyMemberService) {}

  ngOnInit(): void {
    this.initializeDropdown();
  }

  addMember(): Observable<any> {
    const memberDetails = this.collectMemberDetailsFromForm();
    return this.policyMemberService.addMember(memberDetails);
  }

  deleteMember(memberId: number): Observable<any> {
    return this.policyMemberService.deleteMember(memberId);
  }

  validateMember(memberDetails: object): Observable<any> {
    return this.policyMemberService.validateMember(memberDetails);
  }

  declineMember(memberId: number): Observable<any> {
    return this.policyMemberService.declineMember(memberId);
  }

  loadMemberDetails(memberId: number): Observable<any> {
    return this.policyMemberService.loadMemberDetails(memberId);
  }

  validatePolicyMember(): void {
    this.policyMemberService.fetchPartnerList().subscribe(partnerList => {
      this.populatePartnerList(partnerList);
      this.focusOnAnnualIncomeField();
    });
  }

  onRelationSelect(relation: string): void {
    const coverCode = this.policyMemberService.getCoverCode(relation);
    this.assignCoverCode(coverCode);
    this.navigateToSumAssuredField();
  }

  initializeDropdown(): void {
    this.dropdownOptions = Array.from({ length: 13 }, (_, i) => i);
    this.selectedDropdownValue = 0;
  }

  onDropdownChange(event: Event): void {
    this.selectedDropdownValue = (event.target as HTMLSelectElement).value;
  }

  setFormStatus(): void {
    this.formStatus = 'N';
    this.questionFlag = false;
  }

  checkHniPolicies(): void {
    if (this.RV_STOP === 'N' && this.annuityFlag === 'N') {
      this.policyMemberService.queryHniPolicies().subscribe();
    }
  }

  navigateToQuestions(): void {
    this.router.navigate(['AZBJ_BBU_QUESTIONS']);
  }

  handlePM_AGE_PRF_IDInput(event: Event): void {
    const input = (event.target as HTMLInputElement).value.toUpperCase().slice(0, 20);
    if (this.validateAgeProof(input)) {
      this.navigateToPM_RELATION();
    } else {
      this.showValidationError('Invalid Age Proof ID');
    }
  }

  navigateToPM_RELATION(): void {
    this.focusOnField('PM_RELATION');
  }

  validateAndSetDefaultWeightChange(weightChange: number, globalLoadingStatus: string): void {
    if (weightChange == null) {
      weightChange = 0;
    }
    if (globalLoadingStatus === 'F') {
      this.policyMemberService.updateFormStatus('Y').subscribe();
    }
  }

  onAgeProofDoubleClick(): void {
    this.ageProofValidationComponent.showAgeProofList();
  }

  fetchAgeProofDetails(proofType: string): void {
    this.policyMemberService.getAgeProofDetails(proofType).subscribe(details => {
      if (details) {
        this.populateAgeProofDetails(details);
      } else {
        this.showValidationError('NA');
      }
    });
  }

  openConfirmationDialog(): void {
    if (confirm('Do You Want to Decline the Member?')) {
      this.deleteMember(this.selectedMemberId).subscribe(response => {
        this.handleDeleteResponse(response);
      });
    }
  }

  handleDeleteResponse(response: any): void {
    if (response.success) {
      alert('Member and related questions deleted successfully');
    } else {
      alert('Error deleting member');
    }
  }

  checkMemberRelation(): boolean {
    if (!this.selectedMemberRelation) {
      alert('Please select the member relation...!');
      return false;
    }
    return true;
  }

  assignCoverageDetails(coverCode: string, sumAssured: number, age: number, ipNumber: string): void {
    this.coverCode = coverCode;
    this.sumAssured = sumAssured;
    this.age = age;
    this.ipNumber = ipNumber;
  }

  onCalculateSACheckboxChange(event: Event): void {
    if ((event.target as HTMLInputElement).checked) {
      const memberDetails = this.collectMemberDetails();
      this.policyMemberService.calculateSumAssured(memberDetails).subscribe();
    }
  }

  handleInputChange(event: Event): void {
    const input = event.target as HTMLInputElement;
    this[input.name] = input.value;
  }

  savePolicyMemberDetails(): void {
    const policyMember = this.collectPolicyMemberDetails();
    this.policyMemberService.savePolicyMember(policyMember).subscribe();
  }

  onLateralShiftCheckboxChange(event: Event): void {
    const lateralShiftDTO = this.createLateralShiftDTO();
    this.policyMemberService.updateLateralShiftStatus(lateralShiftDTO).subscribe();
  }

  onMemberLoadingButtonClick(): void {
    this.router.navigate(['loading-details']);
  }

  checkAndTransferMemberLoadingDetails(): void {
    this.policyMemberService.getPolicyMemberRecords().subscribe(policyMembers => {
      this.loadingDetailsService.getLoadingDetailsRecords().subscribe(loadingDetails => {
        this.transferMemberLoadingDetails(policyMembers, loadingDetails);
      });
    });
  }

  validateWeight(weight: number): void {
    if (weight <= 0) {
      this.errorMessage = 'Please Select a Valid Weight for the person';
    }
  }

  calculateBMI(weight: number, height: number): void {
    if (height > 0) {
      this.bmi = weight / (height / 100) ** 2;
    }
  }

  handleAgeProofValidation(): void {
    this.policyMemberService.fetchValidAgeProofTypes().subscribe(ageProofTypes => {
      this.showAgeProofPopup(ageProofTypes);
    });
  }

  displayErrorMessage(message: string): void {
    this.errorMessage = message;
  }

  addMemberButtonClick(): void {
    this.openAddMemberDialog();
  }

  addMember(memberDetails: object): void {
    this.policyMemberService.addMember(memberDetails).subscribe();
  }

  validateBMI(): void {
    const bmiData = this.collectBMIData();
    this.policyMemberService.validateBMI(bmiData).subscribe(result => {
      this.updateFormStatus(result);
    });
  }

  heightValidation(height: number): void {
    this.policyMemberService.validateHeight(height).subscribe(response => {
      this.updateFormStatus(response.valid);
      this.updateButtonProperties(response.valid);
    });
  }

  private collectMemberDetailsFromForm(): object {
    // Logic to collect member details from the form
    return {};
  }

  private populatePartnerList(partnerList: any): void {
    // Logic to populate partner list
  }

  private focusOnAnnualIncomeField(): void {
    // Logic to focus on the Annual Income field
  }

  private assignCoverCode(coverCode: string): void {
    // Logic to assign cover code
  }

  private navigateToSumAssuredField(): void {
    // Logic to navigate to the sum assured field
  }

  private focusOnField(fieldName: string): void {
    // Logic to focus on a specific field
  }

  private showValidationError(message: string): void {
    // Logic to show validation error
  }

  private populateAgeProofDetails(details: any): void {
    // Logic to populate age proof details
  }

  private collectMemberDetails(): object {
    // Logic to collect member details
    return {};
  }

  private collectPolicyMemberDetails(): object {
    // Logic to collect policy member details
    return {};
  }

  private createLateralShiftDTO(): any {
    // Logic to create LateralShiftDTO
    return {};
  }

  private transferMemberLoadingDetails(policyMembers: any[], loadingDetails: any[]): void {
    // Logic to transfer member loading details
  }

  private showAgeProofPopup(ageProofTypes: any[]): void {
    // Logic to show age proof popup
  }

  private openAddMemberDialog(): void {
    // Logic to open add member dialog
  }

  private collectBMIData(): any {
    // Logic to collect BMI data
    return {};
  }

  private updateFormStatus(valid: boolean): void {
    // Logic to update form status
  }

  private updateButtonProperties(valid: boolean): void {
    // Logic to update button properties
  }
}
