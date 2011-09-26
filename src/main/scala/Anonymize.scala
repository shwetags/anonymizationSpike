package main.scala
//import com.gu.loremipsum.LoremIpsum
//import com.mongodb.casbah.Imports._
//import util.Random
//import com.mongodb.casbah.{Imports, MongoURI, MongoDB, MongoConnection}
//import com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers
//import org.bson.types.ObjectId

import com.mongodb.casbah.Imports._
import com.mongodb.casbah.{MongoURI, MongoDB, MongoConnection}
object Anonymizer extends App {


    val uri = MongoURI("mongodb://localhost:27017,localhost:27018,localhost:27019/soulmates")
    val db = MongoDB(MongoConnection(uri), uri.database)
    def anonymise(item :DBObject) = {
      val newItem = item.map{case (k,v) =>
        if (v.getClass.getSimpleName == "String"){
                 (k->"abc")
            }
        else
          (k->v)
      }
      newItem
    }
    val members = db("members")
    println(members.first)
    println("anony")
    println(anonymise(members.first))

//                 members.update(Map("_id" -> item.get("_id"), anonymiseString(item)))

//    }



}