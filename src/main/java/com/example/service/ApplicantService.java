package com.example.service;

import java.io.IOException;

import org.kie.api.runtime.KieSession;

import com.example.config.DroolsBeanFactory;
import com.example.model.Applicant;
import com.example.model.SuggestedRole;

public class ApplicantService
{
  
  KieSession kieSession = new DroolsBeanFactory().getKieSession();

  public SuggestedRole suggestARoleForApplicant(Applicant applicant,SuggestedRole suggestedRole) throws IOException {
      kieSession.insert(applicant);
      kieSession.setGlobal("suggestedRole",suggestedRole);
      kieSession.fireAllRules();
      System.out.println(suggestedRole.getRole());
      return  suggestedRole;

  }

}
