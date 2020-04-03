package ro.andramorutan.blog.web.model;

import ro.andramorutan.blog.model.Recipe;

public class RecipeForm
{
  private String name;
  private String from;
  private String ingredients;
  private String instructions;
  private String notes;
  private String hashTags;
  private String pdfUrl;
  private String category;

  public RecipeForm(Recipe recipe)
  {
    name = recipe.getName();
    from = recipe.getRecipeFrom();
    category = recipe.getCategory() == null? "CAKES" : recipe.getCategory().name();
    pdfUrl = recipe.getPdfUrl();
    hashTags = recipe.getHashtags();
    ingredients = recipe.getIngredientsAsString();
    instructions = recipe.getInstructionsAsString();
    notes = recipe.getNotesAsString();
  }

  public RecipeForm()
  {

  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getFrom()
  {
    return from;
  }

  public void setFrom(String from)
  {
    this.from = from;
  }

  public String getIngredients()
  {
    return ingredients;
  }

  public void setIngredients(String ingredients)
  {
    this.ingredients = ingredients;
  }

  public String getInstructions()
  {
    return instructions;
  }

  public void setInstructions(String instructions)
  {
    this.instructions = instructions;
  }

  public String getNotes()
  {
    return notes;
  }

  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  public String getHashTags()
  {
    return hashTags;
  }

  public void setHashTags(String hashTags)
  {
    this.hashTags = hashTags;
  }

  public String getPdfUrl()
  {
    return pdfUrl;
  }

  public void setPdfUrl(String pdfUrl)
  {
    this.pdfUrl = pdfUrl;
  }

  public String getCategory()
  {
    return category;
  }

  public void setCategory(String category)
  {
    this.category = category;
  }
}
