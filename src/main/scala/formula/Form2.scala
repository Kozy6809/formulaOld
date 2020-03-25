/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package formula

case class Form2 (
  var pcode:Int,
  var date:java.sql.Timestamp,
  var sg:Float,
  var person:String,
  var comment:String,
  var reason:String,
  var confDate:java.sql.Timestamp,
  var form1:java.util.List[Form1]
){
  def this() = this(0,null,0.0f,null,null,null,null,null)
  override def toString() = pcode +" "+ date +" "+ sg +" "+ person +" "+
  comment +" "+ reason +" "+ confDate
}
