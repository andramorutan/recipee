package ro.andramorutan.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "note")
public class Note
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String description;

  public Note()
  {
  }

  public Note(String description)
  {
    this.description = description;
  }

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }
}
