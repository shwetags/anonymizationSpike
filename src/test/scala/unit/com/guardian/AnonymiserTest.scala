package com.guardian

import com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers
import org.scala_tools.time.Imports._
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import com.mongodb.casbah.Imports._

class AnonymiserTest extends Spec with ShouldMatchers {

  RegisterJodaTimeConversionHelpers()

  it("should anonymiseString Mongo Document") {
    new Anonymiser().anonymiseDocument(DBObject("name" -> "Shweta")) should not be( DBObject("name" -> "Shweta"))
    new Anonymiser().anonymiseDocument(DBObject("dob" -> new DateTime("1988-02-02"))) should not be( DBObject("dob" -> new DateTime("1988-02-02")))
    new Anonymiser().anonymiseDocument(DBObject("int" -> 2)) should be( DBObject("int" -> 2))

  }

  it("should anonymiseString string values"){
    new Anonymiser().anonymiseString("Shweta") should  not be ("Shweta")
  }

  it("should anonymiseString date values"){
    new Anonymiser().anonymiseDate(new DateTime("1988-02-02")) should  not be (new DateTime("1988-02-02"))
  }

}