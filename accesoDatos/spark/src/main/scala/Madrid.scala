import java.util.{Collections, Date}
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

  def lastIndexSplit(s: String): String = {
    val array = s.split("/")
    array(array.length-1)
  }

  val lastIndexSplitUDF = udf[String, String](lastIndexSplit)


  madrid.filter(col("NOMBRE-INSTALACION").equalTo("Auditorio y sala de exposiciones Paco de Lucía (Latina)"))
    .withColumn("TIPO", lastIndexSplitUDF($"TIPO"))
    .select(col("TITULO"),col("TIPO")).foreach(row => println(row(0)+ " "+row(1)))
  madrid.filter(col("NOMBRE-INSTALACION").equalTo("Auditorio y sala de exposiciones Paco de Lucía (Latina)"))
    .withColumn("TIPO", substring_index($"TIPO","/",-1))
    .select(col("TITULO"),col("TIPO")).foreach(row => println(row(0)+ " "+row(1)))


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

  madrid.groupBy($"NOMBRE-INSTALACION").count().sort(desc("count")).limit(1).show(false)
  madrid.filter(col("NOMBRE-INSTALACION").like("%Latina%")).groupBy($"NOMBRE-INSTALACION").count().sort(desc("count"))
    .select(avg($"count").as("media")).show(false)

  val d = madrid.filter(col("NOMBRE-INSTALACION").like("%Latina%")).groupBy($"NOMBRE-INSTALACION").count().sort(desc("count"))
    .select(avg($"count").as("media")).first().getDouble(0);
  println(d);

  madrid.filter(col("NOMBRE-INSTALACION").like("%Latina%")).groupBy($"NOMBRE-INSTALACION").count()
    .sort(desc("count")).withColumn("media",lit(d)).filter(col("count") > col("media")).show(false)




madrid.select(date_format(to_date($"FECHA"),"yyyy-MM")).distinct().show(false)

madrid.withColumn("FECHA2",date_format(to_date($"FECHA"),"yyyy-MM")).stat.crosstab("FECHA2","CODIGO-POSTAL-INSTALACION").sort(asc("FECHA2_CODIGO-POSTAL-INSTALACION"))
  .show(false)
  madrid.stat.freqItems(Seq("FECHA")).show(false)
}
