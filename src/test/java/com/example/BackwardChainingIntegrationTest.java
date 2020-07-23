package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.kie.api.runtime.KieSession;

import com.example.config.DroolsBeanFactory;
import com.example.model.Fact;
import com.example.model.Result;

public class BackwardChainingIntegrationTest
{

  private Result result;
  private KieSession ksession;

  @Before
  public void before()
  {
    result = new Result();
    ksession = new DroolsBeanFactory().getKieSession();
  }

  @Test
  public void whenWallOfChinaIsGiven_ThenItBelongsToPlanetEarth()
  {

    ksession.setGlobal("result", result);
    ksession.insert(new Fact("Asia", "Planet Earth"));
    ksession.insert(new Fact("China", "Asia"));
    ksession.insert(new Fact("Great Wall of China", "China"));

    ksession.fireAllRules();

    // Assert Decision one
    assertEquals(result.getValue(), "Decision one taken: Great Wall of China BELONGS TO Planet Earth");
  }

}
