package com.guardian

import com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers
import org.scala_tools.time.Imports._
import org.scalatest.Spec
import org.scalatest.matchers.ShouldMatchers
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.MongoURI._
import com.mongodb.casbah.MongoDB._
import com.mongodb.casbah.{MongoDB, MongoURI, MongoCollection}

class MongoAnonymiserTest extends Spec with ShouldMatchers {

  RegisterJodaTimeConversionHelpers()


  val dbUri = MongoURI("mongodb://localhost:27017,localhost:27018,localhost:27019/soulmates_integration")
  val db = MongoDB(MongoConnection(dbUri), dbUri.database)
  val col = db("col")

  it("should anonymise mongo collection") {
    db.dropDatabase()

    val shweta = MongoDBObject(
      "name" -> "Shweta",
      "age" -> 44,
      "dob" -> new DateTime("1970-12-23")
    )
    val rajdeep = MongoDBObject(
      "name" -> "rajdeep",
      "age" -> 54,
      "dob" -> new DateTime("1940-12-23")
    )
    col+=shweta
    col.first.get("_id")
    col+=rajdeep
    col foreach{}

    new MongoAnonymiser(dbUri).anonymiseCollection("col")
    val actualCollection =
    actualCollection foreach{doc =>
      doc should not be(shweta) & should not be(rajdeep)

    }
  }


}