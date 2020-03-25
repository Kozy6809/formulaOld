/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package formula

/**
 * holbeinMasterM.mtbl製造処方マスタのエンティティクラス
 */
case class Fmaster (
  var pk:FmasterPK,
  var pcodeNew:Int,
  var mcode:Int, // 技術データ
  var percent:Double // 技術データ
){
  def this() = this(null,0,0,0.0)
  override def toString = pk.pcode+" "+pk.order+" "+pcodeNew+" "+mcode+" "+percent
}

case class FmasterPK (
  var pcode:Int, // 技術データ
  var order:Short // 技術データ
){
  def this() = this(0,0)
}
