import java.util.Collections
import java.util.function.Consumer
import java.util.stream.Collectors

import CountWords.spark
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, Row, SparkSession}
import org.apache.spark.sql.functions._

object Madrid extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder().
    master("local").getOrCreate()
  import spark.implicits._

  spark.sparkContext.setLogLevel("ERROR");

  val madridJson = spark.read.json("datos/students.json")

  madridJson.printSchema()
  madridJson.show()

  val madrid = spark.read.option("header", "true").option("encoding", "windows-1252").csv("datos/206974-0-agenda-eventos-culturales-100.csv")

  madrid.printSchema()
madrid.show()
  madrid.filter(col("NOMBRE-INSTALACION").like("(Latina)") && $"TIPO".contains("kk"))
  madrid.filter(col("NOMBRE-INSTALACION").equalTo("Auditorio y sala de exposiciones Paco de Lucía (Latina)") || col("TIPO") === "jjj")
    .select(col("TITULO"),col("TIPO")).foreach(row => println(row(0)+ " "+row(1).toString.split("/")(3)))

  madrid.filter(month($"FECHA").equalTo(1))
    .select(col("TITULO"),date_format(to_date(col("FECHA")),"dd/MM/YYYY")).foreach(row => println(row(0)+ " "+row(1)))

  val lista = madrid.filter(month($"FECHA").equalTo(1))
    .select(col("TITULO"),date_format(to_date(col("FECHA")),"dd/MM/YYYY")).collect()

//  lista.forEach(new Consumer[Row] {
//    override def accept(t: Row): Unit = {println(t)}
//  })

  lista.foreach(println);
  for (row <- lista)
    {
      println(row)
    }



}
