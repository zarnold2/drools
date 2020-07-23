package com.example;

import com.example.model.Applicant;
import com.example.model.SuggestedRole;
import com.example.service.ApplicantService;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

public class ApplicantServiceIntegrationTest
{
  private ApplicantService applicantService;

  @Before
  public void setup() {
      applicantService = new ApplicantService();
  }

  @Test
  public void whenCriteriaMatching_ThenSuggestManagerRole() throws IOException {
      Applicant applicant = new Applicant("Davis", 37, 1600000.0, 11);
      SuggestedRole suggestedRole = new SuggestedRole();
      applicantService.suggestARoleForApplicant(applicant, suggestedRole);
      assertEquals("Manager", suggestedRole.getRole());
  }

  @Test
  public void whenCriteriaMatching_ThenSuggestSeniorDeveloperRole() throws IOException {
      Applicant applicant = new Applicant("John", 37, 1200000.0, 8);
      SuggestedRole suggestedRole = new SuggestedRole();
      applicantService.suggestARoleForApplicant(applicant, suggestedRole);
      assertEquals("Senior developer", suggestedRole.getRole());
  }

  @Test
  public void whenCriteriaMatching_ThenSuggestDeveloperRole() throws IOException {
      Applicant applicant = new Applicant("Davis", 37, 800000.0, 3);
      SuggestedRole suggestedRole = new SuggestedRole();
      applicantService.suggestARoleForApplicant(applicant, suggestedRole);
      assertEquals("Developer", suggestedRole.getRole());
  }

  @Test
  public void whenCriteriaNotMatching_ThenNoRole() throws IOException {
      Applicant applicant = new Applicant("John", 37, 1200000.0, 5);
      SuggestedRole suggestedRole = new SuggestedRole();
      applicantService.suggestARoleForApplicant(applicant, suggestedRole);
      assertNull(suggestedRole.getRole());
  }

}
