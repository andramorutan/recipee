package ro.andramorutan.blog.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "recipe")
public class Recipe
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String recipeFrom;
  @OneToMany(targetEntity = Ingredient.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Ingredient> ingredients;
  @OneToMany(targetEntity = Instruction.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Instruction> instructions;
  @OneToMany(targetEntity = Note.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Note> notes;

  @Enumerated(EnumType.STRING)
  private Category category;

  private String hashtags;
  private String pdfUrl;

  public Integer getId()
  {
    return id;
  }

  public void setId(Integer id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getRecipeFrom()
  {
    return recipeFrom;
  }

  public void setRecipeFrom(String recipeFrom)
  {
    this.recipeFrom = recipeFrom;
  }

  public String getHashtags()
  {
    return hashtags;
  }

  public void setHashtags(String hashtags)
  {
    this.hashtags = hashtags;
  }

  public String getPdfUrl()
  {
    return pdfUrl;
  }

  public void setPdfUrl(String pdfUrl)
  {
    this.pdfUrl = pdfUrl;
  }

  public Category getCategory()
  {
    return category;
  }

  public void setCategory(Category category)
  {
    this.category = category;
  }

  public List<Ingredient> getIngredients()
  {
    return ingredients;
  }

  public String getIngredientsAsString()
  {
    return ingredients.stream().map(Ingredient::getDescription).collect(Collectors.joining("\n"));
  }

  public String getNotesAsString()
  {
    return notes.stream().map(Note::getDescription).collect(Collectors.joining("\n"));
  }

  public String getInstructionsAsString()
  {
    return instructions.stream().map(Instruction::getDescription).collect(Collectors.joining("\n"));
  }

  public void setIngredients(List<String> ingredients)
  {
    this.ingredients = new ArrayList<>();
    ingredients.forEach(s -> {
      Ingredient i = new Ingredient(s);
      this.ingredients.add(i);
    });
  }

  public List<Instruction> getInstructions()
  {
    return instructions;
  }

  public void setInstructions(List<String> instructions)
  {
    this.instructions = new ArrayList<>();
    instructions.forEach(s -> {
      Instruction i = new Instruction(s);
      this.instructions.add(i);
    });
  }

  public List<Note> getNotes()
  {
    return notes;
  }

  public void setNotes(List<String> notes)
  {
    this.notes = new ArrayList<>();
    notes.forEach(s -> {
      Note i = new Note(s);
      this.notes.add(i);
    });
  }
}
