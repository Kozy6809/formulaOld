/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package formula

//import javax.persistence._
//
//@Entity
//@Table(name="mtbl製造備考マスタ")
//@Access(AccessType.FIELD)
/**
 * holbeinMasterM.mtbl製造備考マスタのエンティティクラス。
 * 元表にはプライマリキーが設定されていない
 */
case class Cmaster (
  var pcodeNew:Int,
  var pcode:Int,
  var comment:String
){
  def this() = this(0,0,null)
  override def toString = pcodeNew +" "+ pcode +" "+ comment
}
