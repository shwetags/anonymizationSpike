package com.guardian

import com.mongodb.casbah.Imports._
import org.scala_tools.time.Imports._
import com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers

class Anonymiser {

  RegisterJodaTimeConversionHelpers()

  def anonymiseDocument(document: DBObject): DBObject = document.mapValues {
    case v: String => anonymiseString(v)
    case v: DateTime => anonymiseDate(v)
    case v => v
  }

  def anonymiseString(document: String): String = "abcd"
  def anonymiseDate(document: DateTime): DateTime = DateTime.now

}