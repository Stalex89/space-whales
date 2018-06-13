package models;

import java.util.*;
/**
 * A simple representation of a user. 
 * @author Philip Johnson
 */
public class UserInfo {
 
  private String name;
  private String email;
  private String password;
  private Chest buyingChest;
  private Chest playingChest;
  private List<TShirt> tshirtsWon;
  
  /**
   * Creates a new UserInfo instance.
   * @param name The name.
   * @param email The email.
   * @param password The password.
   */
  public UserInfo(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.buyingChest = null;
    this.playingChest = null;
    this.tshirtsWon = new ArrayList<TShirt>();
  }
  
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }
  /**
   * @param email the email to set
   */
  public void setEmail(String email) {
    this.email = email;
  }
  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }
  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  public List<TShirt> getTShirtsWon() {
    return this.tshirtsWon;
  }

  public boolean addWonTShirt(TShirt ts) {
    return this.tshirtsWon.add(ts);
  } 

  public boolean startBuyingChest(Chest ch) {

    this.buyingChest = ch;
    return true;
  } 

  public Chest finishBuyingChest() {
    Chest ch = this.buyingChest;
    this.buyingChest = null;
    return ch;
  } 

  public boolean startPlayingRoulette(Chest ch) {

    this.playingChest  = ch;
    return true;
  } 

  public Chest finishPlayingRoulette() {
    Chest ch = this.playingChest;
    this.playingChest = null;
    return ch;
  } 

}
