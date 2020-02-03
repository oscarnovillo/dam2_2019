import java.util.Base64.Encoder

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{Dataset, SparkSession}

import org.apache.spark.sql.{Encoder, Encoders}


object CountWords extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)


  val spark = SparkSession.builder().
    master("local").getOrCreate()
  val textFile = spark.read.textFile("datos/el_quijote.txt")
  import spark.implicits._

  println(textFile.count())

  val text2 = textFile.flatMap(linea => linea.split(" "))


  val wordCounts = textFile.flatMap(line => line.split(" ")).groupByKey(identity).count().withColumnRenamed("count(1)","count")

wordCounts.sort(desc("count"))
  val array = wordCounts.orderBy($"count".desc).limit(10).collect()

  println(array(0).getLong(1))

  val lista = wordCounts.orderBy($"count".desc).limit(10).collectAsList()


  println(array.deep.mkString("\n"))

}
