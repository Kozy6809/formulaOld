/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package formula

case class Form1 (
  var pk:Form1PK,
  var date:java.sql.Timestamp,
  var mcode:Int,
  var percent:Float,
  var form2:Form2
){
  def this() = this(null,null,0,0.0f,null)
  override def toString = pk.pcode +" "+ date +" "+ pk.order +" "+
  mcode +" "+ percent
}

case class Form1PK (
  var pcode:Int,
  var order:Short
){
  def this() = this(0,0)
}
