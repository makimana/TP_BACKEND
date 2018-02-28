package domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity

public class Chauffage extends IntelligentPeripherik {

  private Residence residence;
  private String power;


  public Chauffage() {

    super();
  }

  @ManyToOne
  @JsonIgnore
  public Residence getResidence() {

    return this.residence;
  }

  public void setResidence(Residence residence) {
    this.residence = residence;

  }

  public String getPower() {
    return power;
  }

  public void setPower(String power) {
    this.power = power;
  }


}


