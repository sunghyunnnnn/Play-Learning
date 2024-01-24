package com.example.demo.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="member")
public class Member {

   @Id
   private String id;
   private String name;
   private String pw;
   private String birth;
   private String email;
   private String address;
   private String phonenum;
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getBirth() {
      return birth;
   }
   public void setBirth(String Birth) {
      this.birth = Birth;
   }
   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }
   public String getAddress() {
      return address;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   public String getPhonenum() {
      return phonenum;
   }
   public void setPhonenum(String phonenum) {
      this.phonenum = phonenum;
   }
   @Override
   public String toString() {
      return "Member [name=" + name + ", id=" + id + ", pw=" + pw + ", birth=" + birth + ", email=" + email
            + ", address=" + address + ", phonenum=" + phonenum + "]";
   }
   
   
   
}