/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package formula

import javax.persistence._

@Entity
@Table(name="mtbl製造マスタ")
@Access(AccessType.FIELD)
/**
 * holbeinMasterM.mtbl製造マスタのエンティティクラス<p>
 * Scalaのケースクラスはパラメータが22個までしか取れないため、
 * 埋め込みクラスを使って分割している
 */
case class Pmaster (
  var pcode:Int, // 技術データ
  var pcodeNew:Int,
  var name:String, // 技術データ 品種名込みの色名
  var sg:Double, // 技術データ
  var isMedium:Short, // 技術データにすべきか?
  var publisherID:Int, // 技術データ
  var registerDate:java.sql.Date, // 新規の場合は記入する
  var updateDate:java.sql.Timestamp, // 技術データ
  var emb:PmasterEmbed
){
  def this() = this(0,0,null,0.0,0,0,null,null,null)
  
  override def toString = pcode+" "+pcodeNew+" "+name+" "+sg+" "+emb.priceSeries+" "+
  emb.productKindCode+" "+emb.factoryCode+" "+emb.sameMonth+" "+emb.employeeID+" "+
  emb.m1+" "+emb.m2+" "+emb.m3+" "+emb.productionAmount+" "+emb.minimumAmount+" "+
  emb.priority+" "+isMedium+" "+emb.spareStockAmount+" "+emb.invoiceFlag+" "+
  emb.cautionFlag+" "+publisherID+" "+emb.stdTime+" "+emb.stdRoll+" "+
  emb.stdPathTime+" "+emb.registerSpec+" "+registerDate+" "+emb.alterDate+" "+
  updateDate+" "+emb.printDate+" "+emb.computerName
}

case class PmasterEmbed (
  var priceSeries:String,
  var productKindCode:String,
  var factoryCode:Short,
  var sameMonth:Short,
  var employeeID:Short,
  var m1:String,
  var m2:String,
  var m3:String,
  var productionAmount:Double,
  var minimumAmount:Double,
  var priority:Int,
  var spareStockAmount:Int,
  var invoiceFlag:Short,
  var cautionFlag:Short,
  var stdTime:Double,
  var stdRoll:Int,
  var stdPathTime:Short,
  var registerSpec:Short,
  var alterDate:java.sql.Date,
  var printDate:java.sql.Timestamp,
  var computerName:String
){  
  def this() = this(null,null,0,0,0,null,null,null,0.0,0.0,0,0,0,0,0.0,0,0,0,null,null,null)
}
